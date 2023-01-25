package dtos;

import com.mycompany.consultorach.entidades.Cuestionario;
import java.time.Instant;

/**
 *
 * @author Zapa
 */
public class UsuarioDTO {

 
    int id;
    String contrasenia;
    String nombreDeUsuario;
    String tipoDocumento;
    String documento;
    String apellido;
    String nombre;
    Instant fechaNactimiento;
    String nacionalidad;
    String email;
    String escolaridad;
    String eliminado;
    String clave;
    Cuestionario cuestionario;
    boolean existeCuestionario;
     int numeroCandidato;
    public void setExisteCuestionario(boolean existeCuestionario) {
        this.existeCuestionario = existeCuestionario;
    }

    public boolean isExisteCuestionario() {
        return existeCuestionario;
    }
    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
   

    public UsuarioDTO(String nombre, String apellido, String contrasenia) {
   
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
         //this.contrasenia = contrasenia.toCharArray();
        
    }
    public UsuarioDTO(String nombreUsuario, String contrasenia){
        this.nombreDeUsuario=nombreUsuario;
        this.contrasenia=contrasenia;
    }
    public UsuarioDTO(String documento) {
        this.documento = documento;
    }

    public UsuarioDTO() {
        
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instant getFechaNactimiento() {
        return fechaNactimiento;
    }

    public void setFechaNactimiento(Instant fechaNactimiento) {
        this.fechaNactimiento = fechaNactimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }
    
    public String getClave(){
        return clave;
    }
    
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

     public String getDocumento() {
        return documento;
    }
      public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    
    /*public char[] getContrasenia() {
        return contrasenia;
    }*/
     public String getContrasenia() {
        return contrasenia;
    }

    /*public void setContrasenia(char[] contrasenia) {
        this.contrasenia = contrasenia;
    }*/
     public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }
    
}
