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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Zapa
 */
@Entity
@Table(name ="pregunta")
public class Pregunta implements Serializable{
    
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

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_pregunta")
    List<Ponderacion> ponderaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_opcion_respuesta")
    OpcionRespuesta or;
    
    
     @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_registro_auditoria")
     private RegistroAuditoria registroAuditoria;

    public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
        this.registroAuditoria = registroAuditoria;
    }

    public RegistroAuditoria getRegistroAuditoria() {
        return registroAuditoria;
    }
     
     

    public boolean isEliminado() {
        return eliminado;
    }

    public List<Ponderacion> getPonderaciones() {
        return ponderaciones;
    }

    public void setPonderaciones(List<Ponderacion> ponderaciones) {
        this.ponderaciones = ponderaciones;
    }


    public OpcionRespuesta getOr() {
        return or;
    }


    public void setOr(OpcionRespuesta or) {
        this.or = or;
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

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public OpcionRespuesta getOpRespuesta() {
        return or;
    }

    public void setOpRespuesta(OpcionRespuesta or) {
        this.or = or;
    }
    
    
}
