/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mycompany.consultorach.entidades.Cuestionario;
import java.util.List;

/**
 *
 * @author zapam
 */
public interface CuestionarioDao {
    public Cuestionario Get(int id);
     public List<Cuestionario> obtenerCuestionario(String clave, int idCandidato);
      public List<Cuestionario> getCuestionarioByidCandidato(int id);
       public void Save(Cuestionario c);
}
