package gestores;

import com.mycompany.consultorach.entidades.Competencia;
import com.mycompany.consultorach.entidades.CompetenciaEvaluacion;
import com.mycompany.consultorach.entidades.FactorEvaluacion;
import daos.FactoryDao;
import daos.CompetenciaDao;
import daos.CompetenciaPGDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zapa
 */
public class GestorCompetencia {
    private static GestorCompetencia instancia;
    private FactoryDao factory;
    private CompetenciaDao competenciaoDao;
    
    private GestorCompetencia(){
    }
    
    public synchronized static GestorCompetencia getInstance(){
        if(instancia == null)
            instancia = new GestorCompetencia();
        return instancia;
    }
    
    public List<String> recuperarNombreCompetencias(){
    CompetenciaPGDao competenciaPG = new CompetenciaPGDao();
    List<String> listNom = new ArrayList();
     listNom = competenciaPG.getNombreAll();
     return listNom;
}
     public CompetenciaEvaluacion crearCompetenciaEvaluacion(Competencia c) {
        
        CompetenciaEvaluacion competenciaEvaluacion = new CompetenciaEvaluacion();
        
        competenciaEvaluacion.setCodigo(c.getCodigo());
        competenciaEvaluacion.setEliminado(c.getEliminado());
        competenciaEvaluacion.setNombre(c.getNombre());
        competenciaEvaluacion.setTipoCompetencia(c.getTipo_competencia());
        competenciaEvaluacion.setDescripcion(c.getDescripcion());
        competenciaEvaluacion.setCompetencia(c);
        
        
        GestorFactor gestorFactor = new GestorFactor();

        List<FactorEvaluacion> factoresEval = new ArrayList();
        
        for(int i=0; i<c.getFactores().size(); i++){
            FactorEvaluacion fe = new FactorEvaluacion();
            fe = gestorFactor.crearFactorEvaluacion(c.getFactores().get(i));
           
            factoresEval.add(fe);
        }
        competenciaEvaluacion.setFactoresEvaluacion(factoresEval);
        return competenciaEvaluacion;
    }
   
}
