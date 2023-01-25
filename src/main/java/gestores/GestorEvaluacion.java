/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;
import com.mycompany.consultorach.entidades.Evaluacion;
import com.mycompany.consultorach.entidades.Cuestionario;
import com.mycompany.consultorach.entidades.PuestoEvaluacion;
import daos.EvaluacionPGDao;
import daos.FactoryDao;
import dtos.CompetenciaDTO;
import dtos.PuestoDTO;
import dtos.UsuarioDTO;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Zapa
 */
public class GestorEvaluacion {
    private static GestorEvaluacion instancia;
    private FactoryDao factory;

    
    private GestorEvaluacion(){
    }
    
    public synchronized static GestorEvaluacion getInstance(){
        if(instancia == null)
            instancia = new GestorEvaluacion();
        return instancia;
    }  
    public void generarEvaluacion( List<UsuarioDTO> usuariosDTO, PuestoDTO puestoDTO){
        
        Evaluacion e = new Evaluacion();
        
        GestorPuesto gestorPuesto = GestorPuesto.getInstance();
        PuestoEvaluacion pe = new PuestoEvaluacion();
        pe = gestorPuesto.crearPuestoEvaluacion(puestoDTO);
        
        List<CompetenciaEvaluacion> competenciasEval = new ArrayList();
        competenciasEval = pe.getCompetenciasEval();
        
        GestorCuestionario gestorCuestionario = new GestorCuestionario();
        List<Cuestionario> cuestionarios = gestorCuestionario.generarCuestionario(competenciasEval, usuariosDTO);
        
        e.setCuestionarios(cuestionarios);
        
       
       
       //A PARTIR DE ACA NECESITO EL PUESTO PARA PASARLE LAS COMPETENCIAS EVALAUCIONES A LOS CUESTIONARIOS
       
        e.setPuestoEvaluacion(pe);
        e.setCuestionarios(cuestionarios);
        e.setFechaHoraInicio(Instant.now());
        e.setFechaHoraFin(Instant.now().plus(30, ChronoUnit.DAYS));
        EvaluacionPGDao dao = new EvaluacionPGDao();
        dao.SaveEvaluacion(e);
      
    }   
}