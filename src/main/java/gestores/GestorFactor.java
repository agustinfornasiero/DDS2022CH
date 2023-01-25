/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.mycompany.consultorach.entidades.Factor;
import com.mycompany.consultorach.entidades.FactorEvaluacion;
import com.mycompany.consultorach.entidades.PreguntaCuestionario;
import java.util.List;

/**
 *
 * @author zapam
 */
public final class GestorFactor {
    private static GestorFactor instancia;
    
    
    public GestorFactor(){
        
    }
    
    public synchronized static GestorFactor getInstance(){
    if (instancia == null)
        instancia = new GestorFactor();
    return instancia;
    }

   public FactorEvaluacion crearFactorEvaluacion(Factor f) {
        
        FactorEvaluacion factorEvaluacion = new FactorEvaluacion();
        GestorPregunta gestorPregunta = GestorPregunta.getInstance();
        factorEvaluacion.setCodigo(f.getCodigo());
        factorEvaluacion.setNombre(f.getNombre());
        factorEvaluacion.setOrden(f.getOrden());
        factorEvaluacion.setDescripcion(f.getDescripcion());
        factorEvaluacion.setEliminado(f.getEliminado());
        factorEvaluacion.setFactor(f);

        List<PreguntaCuestionario> preguntasCues = gestorPregunta.crearPreguntaCuestionario(f.getPreguntas());
        
        factorEvaluacion.setPreguntaCuestionario(preguntasCues);
  
        return factorEvaluacion;
    }
    
}
