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
@Table(name ="pregunta_cuestionario")
public class PreguntaCuestionario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column 
    private String nombre;
    @Column
    private String pregunta;
    @Column
    private String descripcion;
    @Column
    private boolean eliminado;
  
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_opcion_respuesta_cuestionario")
    OpcionRespuestaCuestionario orc;
    
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_pregunta_cuestionario")
    List<PonderacionCuestionario> ponderacionesCuestionario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    private Pregunta preg;
    
    /*@OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name ="id_pregunta_cuestionario")
    private List<Respuesta> respuesta;*/
    
        public List<PonderacionCuestionario> getPonderacionesCuestionario() {
        return ponderacionesCuestionario;
    }

    public void setPonderacionesCuestionario(List<PonderacionCuestionario> pc) {
        this.ponderacionesCuestionario = pc;
    }
    

    public OpcionRespuestaCuestionario getOrc() {
        return orc;
    }

    public void setOrc(OpcionRespuestaCuestionario orc) {
        this.orc = orc;
    }
    
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
    
}