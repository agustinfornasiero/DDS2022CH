package gestores;

import com.mycompany.consultorach.entidades.Consultor;
import com.mycompany.consultorach.entidades.Usuario;
import daos.ConsultorPGDao;
import daos.ServicioAutenticacion;
import dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zapa
 */
public class GestorLDAP implements ServicioAutenticacion{
    private static GestorLDAP instancia;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    private List<Usuario> usuarios = new ArrayList<>();
    
    
    public GestorLDAP(){
        Usuario u1 = new Usuario("USER1", "contra1");
        Usuario u2 = new Usuario("USER2", "contra2");
        Usuario u3 = new Usuario("USER3", "contra3");
        Usuario u4 = new Usuario("USER4", "contra4");
        Usuario u5 = new Usuario("USER5", "contra5");
        Usuario u6 = new Usuario("USER6", "contra6");
        Usuario u7 = new Usuario("USER7", "contra7");
        
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
        usuarios.add(u5);
        usuarios.add(u6);
        usuarios.add(u7);
    }
    public synchronized static GestorLDAP getInstance(){
        if(instancia == null)
            instancia = new GestorLDAP();
        return instancia;
    }

   
    
    public Consultor autenticar(UsuarioDTO user){
        
        if(datosValidos(user) == true){
            ConsultorPGDao consultorPG = new ConsultorPGDao();
            return consultorPG.buscarConsultor(user);
        }
       else
            return new Consultor();
    }
    
    public boolean datosValidos(UsuarioDTO user){
      //aquí intentamos hacerlo usando el metodo contains() y pasandole un objeto usuario
      //para que lo busque en la lista usuarios, pero no nos funcionó por lo que 
      //decidimos crear 2 lista y obtener nombre de usuario y contraseñas por separado
      List<String> nombres = new ArrayList<>();
      List<String> contrasenias = new ArrayList<>();
       for(int i= 0; i<usuarios.size(); i++){
       
        nombres.add(usuarios.get(i).getUsuario());
        contrasenias.add(usuarios.get(i).getContrasenia());
    }
       if(nombres.contains(user.getNombreDeUsuario())){
           if(contrasenias.contains(user.getContrasenia())){
               return true;
           }else{
               return false;
           }
       }else{
           return false;
       }
       
    }
    
}