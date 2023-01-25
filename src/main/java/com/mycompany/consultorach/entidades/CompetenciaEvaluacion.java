/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
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
@Table(name = "competencia_evaluacion")
public class CompetenciaEvaluacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int codigo;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column(name="tipo_competencia")
    private String tipoCompetencia;
    @Column
    private boolean eliminado;
    @Column(name="puntaje_minimo")
    private int puntajeMinimo;


    
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_competencia_evaluacion")
    List<FactorEvaluacion> factoresEvaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competencia")
    Competencia competencia;

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(String tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<FactorEvaluacion> getFactoresEvaluacion() {
        return factoresEvaluacion;
    }

    public void setFactoresEvaluacion(List<FactorEvaluacion> factoresEvaluacion) {
        this.factoresEvaluacion = factoresEvaluacion;
    }

     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      public void setPuntajeMinimo(int puntajeMinimo) {
        this.puntajeMinimo = puntajeMinimo;
    }

    public int getPuntajeMinimo() {
        return puntajeMinimo;
    }
}
