/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.mycompany.consultorach.entidades.OpcionRespuestaCuestionario;
import com.mycompany.consultorach.entidades.Ponderacion;
import com.mycompany.consultorach.entidades.PonderacionCuestionario;
import com.mycompany.consultorach.entidades.Pregunta;
import com.mycompany.consultorach.entidades.PreguntaCuestionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zapam
 */
public class GestorPregunta {
     private static GestorPregunta instancia;
    
    public GestorPregunta(){
    }
    
    public synchronized static GestorPregunta getInstance(){
        if(instancia == null)
            instancia = new GestorPregunta();
        return instancia;
    }
    
public List<PreguntaCuestionario> crearPreguntaCuestionario(List<Pregunta> listaPreguntas) {
       
        List<PreguntaCuestionario> preguntasCuestionario = new ArrayList();
        List<PonderacionCuestionario> ponderacionesCuest = new ArrayList();
        GestorOpcionRespuesta gestorOR = new GestorOpcionRespuesta();
        
        for(int i=0 ; i< listaPreguntas.size(); i++){
            
            PreguntaCuestionario pc = new PreguntaCuestionario();
            OpcionRespuestaCuestionario orc = new OpcionRespuestaCuestionario();
            
            pc.setDescripcion(listaPreguntas.get(i).getDescripcion());
            pc.setNombre(listaPreguntas.get(i).getNombre());
            pc.setEliminado(listaPreguntas.get(i).getEliminado());
            pc.setPregunta(listaPreguntas.get(i).getPregunta());
            
            //CREAR OPCION RTA CUESTIONARIO
            orc = gestorOR.crearOpcionRespuestaCuestionario(listaPreguntas.get(i).getOpRespuesta());            
            pc.setOrc(orc);
        
            
            
            //CREAR PONDERACION A PREGUNTA CUESTIONARIO
           //for(int j =0; j<listaPreguntas.size(); j++){
                List<Ponderacion> ponderaciones = new ArrayList();
               // ponderaciones.addAll(listaPreguntas.get(i).getPonderaciones()); 
               
                //ponderaciones.get(i).getPonderacion();
                
                
                for(int k=0; k<orc.getListaIorc().size();k++){
                    PonderacionCuestionario ponderacionCuestionario = new PonderacionCuestionario();
                    
                   //ponderacionCuestionario.setPonderacionCuestionario(ponderaciones.get(k).getPonderacion());
                  ponderacionCuestionario.setItemOpcionRespuestaCuestionario(orc.getListaIorc().get(k));
                    ponderacionesCuest.add(ponderacionCuestionario);
                }
                 pc.setPonderacionesCuestionario(ponderacionesCuest);
           // }
           preguntasCuestionario.add(pc);
        }
            
 /*ponderacionesCuest = crearPonderacionCuestionario(listaPreguntas.get(i).getPonderaciones(), orc);
            pc.setPonderacionesCuestionario(ponderacionesCuest);*/
       
        return preguntasCuestionario;
    }
     
     public List<PonderacionCuestionario> crearPonderacionCuestionario(List<Ponderacion> ponderaciones, OpcionRespuestaCuestionario orc){
         List<PonderacionCuestionario> lista = new ArrayList();
         for(int i =0; i<ponderaciones.size(); i++){
             PonderacionCuestionario pondeC = new PonderacionCuestionario();
             pondeC.setPonderacionCuestionario(ponderaciones.get(i).getPonderacion());
             pondeC.setItemOpcionRespuestaCuestionario(orc.getListaIorc().get(i));
             lista.add(pondeC);
         }
         return lista;
     } 
     
}