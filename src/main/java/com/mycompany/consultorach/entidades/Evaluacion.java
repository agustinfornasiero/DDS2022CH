/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.Table;

/**
 *
 * @author Zapa
 */
@Entity
@Table(name = "evaluacion")
public class Evaluacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name ="fecha_hora_inicio")
    Instant fechaHoraInicio;
    @Column(name = "fecha_hora_fin")
    Instant fechaHoraFin;
    
@OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_evaluacion")

    List<Cuestionario> cuestionarios;
    
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_puesto_evaluacion")
    PuestoEvaluacion puestoEvaluacion;
    
    
    public int getId() {
        return id;
    }

    public void setPuestoEvaluacion(PuestoEvaluacion puestoEvalucion) {
        this.puestoEvaluacion = puestoEvalucion;
    }

    public PuestoEvaluacion getPuestoEvalucion() {
        return puestoEvaluacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Instant fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Instant getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Instant fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }
    
    
}