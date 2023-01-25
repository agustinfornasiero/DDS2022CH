
package com.mycompany.consultorach.entidades;

//import java.util.List;

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



@Entity
@Table(name= "puntuacion")
public class Puntuacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column
    private Integer puntaje_minimo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    public Puntuacion() {
    }
    

    public Integer getId() {
        return id;
    }

    public Integer getPuntajeMinimo() {
        return puntaje_minimo;
    }

    public void setPuntajeMinimo(Integer puntajeMinimo) {
        this.puntaje_minimo = puntajeMinimo;
    }
    public void setCompetencia(Competencia c){
        this.competencia = c;
    }
    public Competencia getCompetencia(){
        return competencia;
    }

}