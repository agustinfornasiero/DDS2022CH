package gestores;

import com.mycompany.consultorach.entidades.Competencia;
import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;
//import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;
import com.mycompany.consultorach.entidades.Puesto;
import com.mycompany.consultorach.entidades.PuestoEvaluacion;
import com.mycompany.consultorach.entidades.Puntuacion;
//import com.mycompany.consultorach.entidades.PuntuacionEvaluacion;

import daos.CompetenciaPGDao;
import daos.FactoryDao;
import daos.PuestoDao;
import daos.PuestoPGDao;
import dtos.PuestoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import Dtos.PuestoDTO;
//import Excepciones.DatosNoValidosAltaPuestoExcecption;


public final class GestorPuesto {
    private static GestorPuesto instancia;
    private FactoryDao factory;
    private PuestoDao puestoDao;
    
    private GestorPuesto(){
    }
    
    public synchronized static GestorPuesto getInstance(){
        if(instancia == null)
            instancia = new GestorPuesto();
        return instancia;
    }
    

    public boolean crearPuesto(PuestoDTO dto) {
   
            Puesto p = new Puesto();
            
            p.setCodigo(Integer.parseInt(dto.getCodigoP())) ;
            p.setNombre(dto.getNombre());
            p.setEmpresa(dto.getEmpresa());
            p.setDescripcion(dto.getDescripcion());
            p.setEliminado(false);
            if( existePuesto(p) == true ){
                return false;
            }
            else{
                guardarPuesto( p, dto.getPuntaje(), dto.getCompetencias());
                return true;
            }
    }
      public boolean existePuesto(Puesto p){
        PuestoPGDao puestoPG = new PuestoPGDao();
        List<Integer> listCod = new ArrayList();
        List<String> listNom = new ArrayList();
       
        listCod = puestoPG.getCodigoAll();
        listNom = puestoPG.getNombreAll();
        
        listCod.forEach(System.out::println);
        listNom.forEach(System.out::println);
        
        if(listCod.contains(p.getCodigo()) || listNom.contains(p.getNombre())){
            return true;
        }
        else {
            
            return false;             
        }
    }
         public void guardarPuesto(Puesto p,ArrayList<Integer> puntajes, ArrayList<String> competencias){
        PuestoPGDao puestoPG = new PuestoPGDao();
        CompetenciaPGDao compePG = new CompetenciaPGDao();
        List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();
        for(int i=0; i< puntajes.size(); i++){
            
            Puntuacion puntuacion = new Puntuacion();
            puntuacion.setPuntajeMinimo(puntajes.get(i));
            Competencia c = compePG.Get(competencias.get(i));
            
            puntuacion.setCompetencia(c);
            puntuaciones.add(puntuacion);
        }
        p.setPuntuaciones(puntuaciones);
        puestoPG.SavePuesto(p);
 
    }
         
        public int[] validarDatos(String c, String n, String e, String d, JTable t ){
             int[] mensajes = new int[5];
               if( c.matches(".*[^0-9].*" )){
              
           
            mensajes[1] = 1;
             } 
            if(n.matches(".*[^aA-zZ]+$.*") || e.matches(".*[^aA-zZ]+$.*") ){
                
           
            mensajes[2] = 1;
         
            }
            if(d.matches(".*[^0-9aA-zZ]")){
               
                mensajes[3]=1;
            }
            if(c.isEmpty() || n.isEmpty() || e.isEmpty() || d.isEmpty()){
           
           
            mensajes[0]=1;
           
        }
            ArrayList columna = new ArrayList();
       DefaultTableModel model = (DefaultTableModel) t.getModel();
    for(int i = 0;i<model.getRowCount();i++)
    {   
   columna.add(model.getValueAt(i,0)); //get the all row values at column index 0
   
}
        if(columna.isEmpty()==true){
            mensajes[4]=1;
        }
            return mensajes;
         }
        
        public List<Puesto> buscarPuestoSegunCriterio( PuestoDTO dto){
       //int  cod = Integer.parseInt(codigo);
            PuestoPGDao puestoPG = new PuestoPGDao();
        List<Puesto> listaPuestos = new ArrayList();
        listaPuestos = puestoPG.buscarPuestos(dto);
        return listaPuestos;}
        
        public int[] validarDatosGestionarPuesto(PuestoDTO dto){
           int[] mensajes = new int[3];
            if(dto.getNombre().isEmpty() && dto.getEmpresa().isEmpty() && dto.getCodigoP().isEmpty() ){
              mensajes[0] = 1;
           } 
            return mensajes;
        }
        
         public List<Puntuacion> seleccionarPuesto(PuestoDTO puestoDTO){
            PuestoPGDao puestoPG = new PuestoPGDao();
            //Puesto p = puestoPG.Get(puestoDTO.getId());
            List<Competencia> competencias = new ArrayList();
            List<Puntuacion> puntuaciones = new ArrayList();
            Puesto p = puestoPG.unicoPuesto(puestoDTO.getEmpresa(), puestoDTO.getNombre());
            //Obtengo cada Competencia asociada al Puesto 
            for(int i=0; i<p.getPuntuaciones().size(); i++){
                competencias.add(p.getPuntuaciones().get(i).getCompetencia());
            }
            puntuaciones=p.getPuntuaciones();
            List<Puntuacion> puntuacionesAux=new ArrayList();
           // puntuacionesAux.addAll(puntuaciones);
           List<Competencia> competenciasAux = new ArrayList();
            competenciasAux.addAll(competencias);
            //Por cada FACTOR asociado a COMPETENCIA veo si cumple las condiciones
            //esto es si la listaPReguntas x Factor < 2, si es cierto quito la competencia de la lista
          
           /* for(int i=0; i<puntuaciones.size(); i++){
                
                if(puntuaciones.get(i).getCompetencia().getFactores().isEmpty()) puntuacionesAux.remove(i);
                
                for(int g=0; g<puntuaciones.get(i).getCompetencia().getFactores().size(); g++){
                if(puntuaciones.get(i).getCompetencia().getFactores().get(g).getPreguntas().size() < 2 || puntuaciones.get(i).getCompetencia().getFactores().get(g).getPreguntas().isEmpty()) puntuacionesAux.remove(i);
            }
            }*/
            for(int i=0; i<competencias.size(); i++){
                
                if(competencias.get(i).getFactores().isEmpty()) puntuacionesAux.add(puntuaciones.get(i));
                //else{
                for(int g=0; g<competencias.get(i).getFactores().size(); g++){
                if(competencias.get(i).getFactores().get(g).getPreguntas().isEmpty() || competencias.get(i).getFactores().get(g).getPreguntas().size() < 2  )
                    puntuacionesAux.add(puntuaciones.get(i));
            }
        }
       if(puntuacionesAux.isEmpty()){
            System.out.println("Las competencias seleccionadas cumplen");  
            return puntuaciones;
        }else{
           return puntuacionesAux;
       }
        /*else if(puntuacionesAux.size() <= puntuaciones.size()){
            competencias.removeAll(competenciasAux);
           competencias.forEach(System.out::println);
        }*/
          //return competencias;  
        }

       public PuestoEvaluacion crearPuestoEvaluacion(PuestoDTO puestoDTO) {
       PuestoPGDao puestoPG = new PuestoPGDao();
       Puesto p = puestoPG.obtenerPuesto(puestoDTO.getCodigo());
        
       PuestoEvaluacion puestoEvaluacion = new PuestoEvaluacion();
       puestoEvaluacion.setPuesto(p);
       puestoEvaluacion.setCodigo(p.getCodigo());
       puestoEvaluacion.setDescripcion(p.getDescripcion());
       puestoEvaluacion.setNombre(p.getNombre());
       puestoEvaluacion.setEliminado(p.getEliminado());
       puestoEvaluacion.setEmpresa(p.getEmpresa());
    
       
       GestorCompetencia gestorCompetencia = GestorCompetencia.getInstance();
       CompetenciaEvaluacion ce = new CompetenciaEvaluacion();
       List<CompetenciaEvaluacion> competenciasEval = new ArrayList();
       
       for(int i=0; i<p.getPuntuaciones().size(); i++){
       ce =  gestorCompetencia.crearCompetenciaEvaluacion(p.getPuntuaciones().get(i).getCompetencia());
       ce.setPuntajeMinimo(p.getPuntuaciones().get(i).getPuntajeMinimo());
     
       competenciasEval.add(ce);
       
       }
       puestoEvaluacion.setCompetenciasEval(competenciasEval);
       
       return puestoEvaluacion;         
    }
    
    public PuestoDTO traerPuesto(String nombreEmpresa,String nombrePuesto){
        PuestoDTO puestoSeleccionado = new PuestoDTO();
        Puesto p = new Puesto();
        PuestoPGDao dao = new PuestoPGDao();
        p = dao.unicoPuesto( nombreEmpresa, nombrePuesto);
        puestoSeleccionado.setCodigo(p.getCodigo());
        puestoSeleccionado.setNombre(p.getNombre());
        puestoSeleccionado.setEmpresa(p.getEmpresa());
        // habria que discriminar las puntuaciones
       //puestoSeleccionado.setPuntuaciones(p.getPuntuaciones());
       
        List<Competencia> competencias = new ArrayList();
            
        //la siguiente linea es mia
        List<Puntuacion> puntuaciones = new ArrayList();
        List<Puntuacion> pAux = new ArrayList();
        puntuaciones=p.getPuntuaciones();
        
        for(int i=0; i<puntuaciones.size(); i++){
              competencias.add(p.getPuntuaciones().get(i).getCompetencia());
            }
            
            List<Competencia> competenciasAux = new ArrayList();
            competenciasAux=competencias;
            
            for(int i=0; i<competencias.size(); i++){
                for(int g=0; g<competencias.get(i).getFactores().size(); g++){
                if(competencias.get(i).getFactores().get(g).getPreguntas().size() < 2) competenciasAux.remove(i);
            }
        }
        if(competenciasAux.size() == competencias.size()){
            System.out.println("Las competencias seleccionadas cumplen"); 
            puestoSeleccionado.setPuntuaciones(p.getPuntuaciones());
        }
        else if(competenciasAux.size() < competencias.size()){
            competencias.removeAll(competenciasAux);
            competencias.forEach(System.out::println);
            for(int k=0; k<puntuaciones.size();k++){
                if(puntuaciones.get(k).getCompetencia()==competencias.get(k)){
                    pAux.add(puntuaciones.get(k));
                }
            }
            puestoSeleccionado.setPuntuacionesNoCumplen(p.getPuntuaciones());
        }
        
      
       
        return puestoSeleccionado;
    }
    
    
    public List<Competencia> recuperarCompetencias(PuestoDTO puesto){
         Puesto p = new Puesto();
       
        PuestoPGDao dao = new PuestoPGDao();
        p.setCodigo(puesto.getCodigo());
         p = dao.unicoPuesto( puesto.getEmpresa(), puesto.getNombre());
         List<Competencia> competencias = new ArrayList();
            
        //la siguiente linea es mia
        List<Puntuacion> puntuaciones = new ArrayList();
       
        puntuaciones=p.getPuntuaciones();
        
        for(int i=0; i<puntuaciones.size(); i++){
              competencias.add(p.getPuntuaciones().get(i).getCompetencia());
            }
        return competencias;
    }
}