/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import com.mycompany.consultorach.entidades.Consultor;
import dtos.UsuarioDTO;

/**
 *
 * @author Vulturius
 */
public interface ServicioAutenticacion {
    public Consultor autenticar(UsuarioDTO user);
}
