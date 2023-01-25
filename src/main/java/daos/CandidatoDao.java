/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mycompany.consultorach.entidades.Candidato;
import dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author zapam
 */
public interface CandidatoDao {
     public List<String> getDocumentoAll();
      public Candidato Get(int numeroCandidato);
      public Candidato buscarCandidato(String numDoc,String tipoDocumento);
      public List<Candidato> buscarCandidatoSegunCriterio(UsuarioDTO user);
}
