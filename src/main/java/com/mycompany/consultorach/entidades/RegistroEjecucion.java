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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name = "registro_ejecucion")
public class RegistroEjecucion implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     @Column(name="fecha_hora")
     private Instant fechaHora;
     @Column
     private String accion;

      @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_registro_ejecucion")
      
    private List<Cuestionario> cuestionarios;

    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }
     
     
    public Integer getId() {
        return id;
    }

    public Instant getFechaHora() {
        return fechaHora;
    }

    public String getAccion() {
        return accion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaHora(Instant fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
     
     
     
     
}
