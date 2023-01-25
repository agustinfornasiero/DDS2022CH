/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import com.mycompany.consultorach.entidades.ItemOpcionRespuesta;
import com.mycompany.consultorach.entidades.ItemOpcionRespuestaCuestionario;
import com.mycompany.consultorach.entidades.OpcionRespuesta;
import com.mycompany.consultorach.entidades.OpcionRespuestaCuestionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vulturius
 */
public class GestorOpcionRespuesta {
    public OpcionRespuestaCuestionario crearOpcionRespuestaCuestionario(OpcionRespuesta opRespuesta) {
       
        OpcionRespuestaCuestionario orc = new OpcionRespuestaCuestionario();
        
        orc.setDescripcion(opRespuesta.getDescripcion());
        orc.setNombre(opRespuesta.getNombre());
        orc.setEliminado(opRespuesta.isEliminado());
        
        List<ItemOpcionRespuestaCuestionario> lista = new ArrayList();
        lista=crearItemOpcionRespuestaCuestioanrio(opRespuesta.getListaIor());
        orc.setListaIorc(lista);
        return orc;
    }
    
    
 

    private List<ItemOpcionRespuestaCuestionario> crearItemOpcionRespuestaCuestioanrio(List<ItemOpcionRespuesta> listaIor) {
       
       List<ItemOpcionRespuestaCuestionario> lista = new ArrayList();
        for(int i=0; i<listaIor.size(); i++){
             ItemOpcionRespuestaCuestionario iorc = new ItemOpcionRespuestaCuestionario();
             iorc.setDescripcion(listaIor.get(i).getDescripcion());
             iorc.setOrdenVisualizacion(listaIor.get(i).getOrdenVisualizacion());
             lista.add(iorc);
        }
        return lista;
    }
}
