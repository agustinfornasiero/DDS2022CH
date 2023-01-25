/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import com.mycompany.consultorach.entidades.BloquePreguntas;
import com.mycompany.consultorach.entidades.Candidato;
import com.mycompany.consultorach.entidades.Puntaje;
import java.time.Instant;
import java.util.List;


public class CuestionarioDTO {
    
   
    private int id;
    
    
    private String estado;
  
    private int tiempoMaxinoPermitido;
 
    private Instant fechaHoraInicio;
   
    private Instant fechaHoraFinalizacion;
    
    private int accesosPermitidos;
   
    private int vecesAccedido;
   
    private String instrucciones;
   
    private double puntajeObtenido;
   
    private String clave;
    
    
    private Candidato candidato;
    boolean acceso;

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public boolean isAcceso() {
        return acceso;
    }
    
    List<BloquePreguntas> bloquePreguntas;
    
    List<Puntaje> puntajes;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTiempoMaxinoPermitido(int tiempoMaxinoPermitido) {
        this.tiempoMaxinoPermitido = tiempoMaxinoPermitido;
    }

    public void setFechaHoraInicio(Instant fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setFechaHoraFinalizacion(Instant fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public void setAccesosPermitidos(int accesosPermitidos) {
        this.accesosPermitidos = accesosPermitidos;
    }

    public void setVecesAccedido(int vecesAccedido) {
        this.vecesAccedido = vecesAccedido;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setPuntajeObtenido(double puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getClave() {
        return clave;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public int getTiempoMaxinoPermitido() {
        return tiempoMaxinoPermitido;
    }

    public Instant getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public Instant getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public int getAccesosPermitidos() {
        return accesosPermitidos;
    }

    public int getVecesAccedido() {
        return vecesAccedido;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public double getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setCandidato(Candidato c) {
        this.candidato = c;
    }

    public List<BloquePreguntas> getBloquePreguntas() {
        return bloquePreguntas;
    }

    public void setBloquePreguntas(List<BloquePreguntas> bloquePreguntas) {
        this.bloquePreguntas = bloquePreguntas;
    }

    public List<Puntaje> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(List<Puntaje> puntajes) {
        this.puntajes = puntajes;
    }

    
}
