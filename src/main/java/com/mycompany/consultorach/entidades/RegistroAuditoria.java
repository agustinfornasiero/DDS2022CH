/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name = "registro_auditoria")
public class RegistroAuditoria implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     @Column(name="fecha_eliminacion")
     private Instant fechaEliminacion;
     @Column(name="tipo_entidad")
     private String tipoEntidad;
     
     @ManyToOne(  fetch = FetchType.EAGER
            
            )
     @JoinColumn(name="id_consultor")
     private Consultor consultor;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaEliminacion(Instant fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Integer getId() {
        return id;
    }

    public Instant getFechaEliminacion() {
        return fechaEliminacion;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public Consultor getConsultor() {
        return consultor;
    }
     
     
}
