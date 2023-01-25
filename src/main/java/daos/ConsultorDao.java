/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mycompany.consultorach.entidades.Consultor;
import dtos.UsuarioDTO;

/**
 *
 * @author Zapa
 */
public interface ConsultorDao {
    public Consultor Get(int id);
    public Consultor buscarConsultor(UsuarioDTO userDTO);
}

