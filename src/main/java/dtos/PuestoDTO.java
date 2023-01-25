package dtos;

import com.mycompany.consultorach.entidades.Competencia;
import com.mycompany.consultorach.entidades.Puesto;
import com.mycompany.consultorach.entidades.Puntuacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Zapa
 */
public class PuestoDTO extends Puesto{

     private Integer id;

   

   
    private String codigoP;
    private String nombre;
    private String descripcion;
    private String empresa;
    private Boolean eliminado;
    private ArrayList<String> competencias;
    
    
     private List<Puntuacion> puntuaciones;
     private List<Puntuacion> puntuacionesNoCumplen;


    public void setPuntuacionesNoCumplen(List<Puntuacion> puntuacionesNoCumplen) {
        this.puntuacionesNoCumplen = puntuacionesNoCumplen;
    }

    public List<Puntuacion> getPuntuacionesNoCumplen() {
        return puntuacionesNoCumplen;
    }

    public void setPuntuaciones(List<Puntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public List<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }
    
 public String getCodigoP() {
        return codigoP;
    }
    public ArrayList<Integer> getPuntaje() {
        return puntaje;
    }
    private ArrayList<Integer> puntaje;
    
    public ArrayList<String> getCompetencias() {
        return competencias;
    }
   
    public void setCompetencias(ArrayList<String> competencias) {
        this.competencias = competencias;
    }

    public void setPuntaje(ArrayList<Integer> puntaje) {
        this.puntaje = puntaje;
    }

   
    
 

    
    
    public Integer getId() {
        return id;
    }

   
    public String getNombre() {
        return nombre.toUpperCase();
    }

    public String getDescripcion() {
        return descripcion.toUpperCase();
    }

    public String getEmpresa() {
        return empresa.toUpperCase();
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    

    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

   
   
    
}
