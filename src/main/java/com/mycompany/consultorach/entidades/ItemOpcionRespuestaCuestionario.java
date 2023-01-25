/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Vulturius
 */
@Entity
@Table(name ="item_opcion_respuesta_cuestionario")
public class ItemOpcionRespuestaCuestionario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String descripcion;
    @Column(name="orden_visualizacion")
    private int ordenVisualizacion;
@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_opcion_respuesta")
    Competencia competencia;
    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    
   
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOrdenVisualizacion(int ordenVisualizacion) {
        this.ordenVisualizacion = ordenVisualizacion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOrdenVisualizacion() {
        return ordenVisualizacion;
    }
}
