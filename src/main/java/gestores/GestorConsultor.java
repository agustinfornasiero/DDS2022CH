/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;
import com.mycompany.consultorach.entidades.Consultor;
import dtos.UsuarioDTO;


/**
 *
 * @author Zapa
 */
public class GestorConsultor {
    private static GestorConsultor instancia;

    
    private GestorConsultor(){
    }
    
    public synchronized static GestorConsultor getInstance(){
        if(instancia == null)
            instancia = new GestorConsultor();
        return instancia;
    }
    
    
    public boolean chequearCamposVacios(String user, char[] pass){
        if(pass.length==0 || user.isEmpty() ){
            
        return false;
    }
        else{
                return true;
                }
        
    }
    
     public UsuarioDTO autenticarUsuario(UsuarioDTO userDTO){
        
        GestorLDAP gestorLDAP = new GestorLDAP();
        Consultor c = gestorLDAP.autenticar(userDTO);
        
        UsuarioDTO consultorDTO = new UsuarioDTO(c.getNombre(),c.getApellido(),c.getContrasenia());
        
        return  consultorDTO;
    }
    
}


