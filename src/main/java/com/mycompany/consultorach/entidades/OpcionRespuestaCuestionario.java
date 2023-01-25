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
 * @author zapam
 */
@Entity
@Table(name ="opcion_respuesta_cuestionario")
public class OpcionRespuestaCuestionario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private boolean eliminado;
    
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_opcion_respuesta_cuestionario")
    List<ItemOpcionRespuestaCuestionario> listaIorc;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_respuesta")
    OpcionRespuesta opcionRespuesta;
    
    public List<ItemOpcionRespuestaCuestionario> getListaIorc() {
        return listaIorc;
    }

    public void setListaIorc(List<ItemOpcionRespuestaCuestionario> listaIorc) {
        this.listaIorc = listaIorc;
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
