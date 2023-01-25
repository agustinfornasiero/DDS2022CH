/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Zapa
 */
@Entity
@Table(name = "bloque_preguntas")
public class BloquePreguntas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int numero;
    @Column
    private String estado;
    @Column(name="cant_preguntas")
    int cantPreguntas;
    @Column(name="bloque_final")
    private boolean BloqueFinal;
    
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_bloque_preguntas")
    private List<PreguntaCuestionario> preguntasCuestionario = new ArrayList();
    

    public void addPreguntaCuestionario(PreguntaCuestionario pc){
        preguntasCuestionario.add(pc);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(int cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    public boolean isBloqueFinal() {
        return BloqueFinal;
    }

    public void setBloqueFinal(boolean BloqueFinal) {
        this.BloqueFinal = BloqueFinal;
    }

    public List<PreguntaCuestionario> getPreguntaCuestionario() {
        return preguntasCuestionario;
    }

    public void setPreguntaCuestionario(List<PreguntaCuestionario> preguntasCuestionario) {
        this.preguntasCuestionario = preguntasCuestionario;
    }
    
    
}
