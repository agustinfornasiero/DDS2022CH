
package daos;

import com.mycompany.consultorach.entidades.Competencia;
import java.util.List;

public interface CompetenciaDao {
    
    public int Save(Competencia c);
    public Competencia Get(int id);
    public List<Integer> getCodigoAll();
    public List<String> getNombreAll();
     public Competencia  Get(String nombre);
}
