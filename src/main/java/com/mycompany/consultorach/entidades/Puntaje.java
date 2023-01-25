/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
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
 * @author zapam
 */
@Entity
@Table(name="puntaje")
public class Puntaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
     @Column
    private int puntaje;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_competencia_evaluacion")
    private CompetenciaEvaluacion ce;
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int punaje) {
        this.puntaje = puntaje;
    }

    public CompetenciaEvaluacion getCe() {
        return ce;
    }

    public void setCe(CompetenciaEvaluacion ce) {
        this.ce = ce;
    }
    
    
}
