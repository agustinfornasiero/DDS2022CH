/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */

@Entity
@Table(name = "cuestionario")
public class Cuestionario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String clave;
    @Column
    private String estado;
    @Column(name = "puntaje_obtenido")
    private double puntajeObtenido;
    @Column(name = "tiempo_maximo_permitido")
    private int tiempoMaxinoPermitido;
    @Column(name = "fecha_hora_inicio")
    private Instant fechaHoraInicio;
    @Column(name = "fecha_hora_fin")
    private Instant fechaHoraFin;
     @Column(name = "fecha_hora_no_finalizacion")
    private Instant fechaHoraNoFinalizacion;
    @Column(name= "accesos_permitidos")
    private int accesosPermitidos;
    @Column(name= "veces_accedidos")
    private int vecesAccedido;
    @Column
    private String instrucciones;
    //falta el registro
    @OneToOne(fetch = FetchType.EAGER,
     cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;
    
    
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_cuestionario")
    private List<BloquePreguntas> bloquePreguntas;

    
    
     @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_cuestionario")
    private List<Puntaje> puntajes;


    
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

    public void setFechaHoraFinalizacion(Instant fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
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

    public Instant getFechaHoraFin() {
        return fechaHoraFin;
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

    public void setFechaHoraNoFinalizacion(Instant fechaHoraNoFinalizacion) {
        this.fechaHoraNoFinalizacion = fechaHoraNoFinalizacion;
    }

    public Instant getFechaHoraNoFinalizacion() {
        return fechaHoraNoFinalizacion;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    
}
