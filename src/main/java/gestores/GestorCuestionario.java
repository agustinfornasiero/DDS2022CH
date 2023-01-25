/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

/*import com.mycompany.consultorach.entidades.BloquePreguntas;
import com.mycompany.consultorach.entidades.BloquePreguntasDTO;
import com.mycompany.consultorach.entidades.Candidato;
import com.mycompany.consultorach.entidades.Competencia;
import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;*/
import com.mycompany.consultorach.entidades.BloquePreguntas;
import com.mycompany.consultorach.entidades.Candidato;
import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;
import com.mycompany.consultorach.entidades.Cuestionario;
import com.mycompany.consultorach.entidades.FactorEvaluacion;
import com.mycompany.consultorach.entidades.PreguntaCuestionario;
import com.mycompany.consultorach.entidades.Puntaje;
/*import com.mycompany.consultorach.entidades.CuestionarioDTO;
import com.mycompany.consultorach.entidades.FactorEvaluacion;
import com.mycompany.consultorach.entidades.PreguntaCuestionario;
import com.mycompany.consultorach.entidades.Puntaje;
import com.mycompany.consultorach.entidades.PuntuacionEvaluacion;*/
import daos.CuestionarioPGDao;
import daos.FactoryDao;
import daos.PuestoDao;
import dtos.BloquePreguntasDTO;
import dtos.CuestionarioDTO;
//import dtos.CompetenciaDTO;
import dtos.UsuarioDTO;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Zapa
 */
public class GestorCuestionario {
 private static GestorCuestionario instancia;
    private FactoryDao factory;
    private PuestoDao puestoDao;
    public synchronized static GestorCuestionario getInstance(){
        if(instancia == null)
            instancia = new GestorCuestionario();
        return instancia;
    }
    /*void existeCuestionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public Cuestionario existeCuestionario(String clave, int idCandidato){
        CuestionarioPGDao cuestionarioPGDao = new CuestionarioPGDao();
        List<Cuestionario> c = new ArrayList();
            c = cuestionarioPGDao.obtenerCuestionario(clave, idCandidato);
        
            if(c.isEmpty()){
                return new Cuestionario();
            }else{
                 return c.get(0);
            }
           
    }
    public List<Cuestionario> generarCuestionario(List<CompetenciaEvaluacion> competenciasEval, List<UsuarioDTO> usuariosDTO) {
        List<Candidato> candidatos = new ArrayList();
        GestorCandidato gestorCandidatos = GestorCandidato.getInstance();
        candidatos = gestorCandidatos.buscarCandidatos(usuariosDTO);
         
        List<Cuestionario> cuestionarios = new ArrayList();
         
        
        for(int i=0; i<candidatos.size(); i++){
            
            Cuestionario c = new Cuestionario();
            List<Puntaje> listaPuntajes = new ArrayList();
            c.setEstado("ACTIVO");
            c.setTiempoMaxinoPermitido(120);
            c.setAccesosPermitidos(3);
            c.setInstrucciones("instrucciones");
            
            c.setClave(usuariosDTO.get(i).getClave());
            cuestionarios.add(c);
            (candidatos.get(i)).setCuestionario(c);
            c.setCandidato(candidatos.get(i));
            
            //candidatos.get(i).setCuestionario(c);
            //candidatos.get(i).setCuestionario(c);
            
            for(int t=0; t<competenciasEval.size(); t++){
                Puntaje p = new Puntaje();
                p.setPuntaje(0);
                p.setCe(competenciasEval.get(t));
                listaPuntajes.add(p);
            }
            c.setPuntajes(listaPuntajes);
            
        }
        /*for(int j=0; j<candidatos.size();j++){
            candidatos.get(j).setCuestionario(cuestionarios.get(j));
        }
        */
        return cuestionarios;
    }
    
   public CuestionarioDTO obtenerCuestionario(int idCuestionario){
        
        CuestionarioPGDao cuestionarioPG = new CuestionarioPGDao();
        CuestionarioDTO dto = new CuestionarioDTO();
        Cuestionario c = cuestionarioPG.Get(idCuestionario);
        String estado = c.getEstado();
        int cantAccesos = c.getVecesAccedido();
        Instant hoy = Instant.now();
        long tiempoTranscurrido = ChronoUnit.MINUTES.between(hoy, c.getFechaHoraInicio());
        
        dto.setId(c.getId());
        dto.setInstrucciones(c.getInstrucciones());
        
        if(c.getEstado() == "EN_PROCESO"){
            System.out.println("El cuestionario esta en proceso");
            dto.setAcceso(false);
            //aca habria que dar un retorno para la capa de presentacion
        }
        if(c.getEstado() == "ACTIVO" && tiempoTranscurrido > (ChronoUnit.MINUTES.between(c.getFechaHoraFin(), c.getFechaHoraInicio()))){
             System.out.println("Tiempo maximo superado. Cuestionario SIN CONTESTAR");
              dto.setAcceso(false);
        }
           
        else{
            
            System.out.println("algo");
             dto.setAcceso(true);
            //aca debemos mostrar las intruccciones
            
        }
        return dto;
    }
   
    public List<BloquePreguntasDTO> inicializarCuestionario(int idCuestionario){
        
        CuestionarioPGDao cuestionarioPG = new CuestionarioPGDao();
        Cuestionario c = cuestionarioPG.Get(idCuestionario);
        
        List<CompetenciaEvaluacion> listaCE = new ArrayList();
        List<FactorEvaluacion> listaFE = new ArrayList();
        List<FactorEvaluacion> listaFEaux = new ArrayList();
        List<BloquePreguntas> bloqPreguntas = new ArrayList();
        List<PreguntaCuestionario> preguntas = new ArrayList();
        
        for(int i=0; i<c.getPuntajes().size(); i++){
            listaCE.add(c.getPuntajes().get(i).getCe());
        }
        for(int i=0; i<listaCE.size(); i++){
            listaFE.addAll(listaCE.get(i).getFactoresEvaluacion());
        }
        listaFEaux = listaFE;
        for(int i=0; i<listaFE.size(); i++){
            if(listaFE.get(i).getPreguntaCuestionario().size() < 2){
                listaFEaux.remove(i);}
                else{
                int preguntasPorFactor = listaFE.get(i).getPreguntaCuestionario().size();
                
                for(int j=0; j<preguntasPorFactor; j++){
                     preguntas.add(listaFE.get(i).getPreguntaCuestionario().get(j));
                }
            }
        }
        List<BloquePreguntasDTO> bloquesDTO = new ArrayList();
        for(int i=0; i<listaFEaux.size(); i++){
            BloquePreguntasDTO dto = new BloquePreguntasDTO();
            BloquePreguntas bp = new BloquePreguntas();
            
            bp.setNumero(i);
            bp.setEstado("INCOMPLETO");
            bp.setCantPreguntas(2);
            dto.setNumero(i);
            dto.setEstado("INCOMPLETO");
            dto.setCantPreguntas(2);
            if(i == listaFEaux.size()-1) {
                bp.setBloqueFinal(true);
                  dto.setBloqueFinal(true);
            }
            else {
                bp.setBloqueFinal(false);
                dto.setBloqueFinal(false);
            }
                      
            for(int k=0; k<bp.getCantPreguntas(); k++){
                int alAzar = generarNro(preguntas.size());
                bp.addPreguntaCuestionario(preguntas.get(alAzar));
                
                preguntas.remove(alAzar);
            }
            dto.setPreguntaCuestionario(bp.getPreguntaCuestionario());
            bloqPreguntas.add(bp);
            bloquesDTO.add(dto);
        }
        c.setBloquePreguntas(bloqPreguntas);
        c.setFechaHoraInicio(Instant.now());
        c.setEstado("EN_PROCESO");
        cuestionarioPG.Save(c);
     
    return bloquesDTO;
    }
    
    private int generarNro(int cantPreguntas){
        
      
        int randomNum = ThreadLocalRandom.current().nextInt(0, cantPreguntas);
        return randomNum;
    }
    
}
