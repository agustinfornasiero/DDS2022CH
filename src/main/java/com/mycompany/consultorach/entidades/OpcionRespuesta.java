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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zapam
 */
@Entity
@Table(name ="opcion_respuesta")
public class OpcionRespuesta implements Serializable{
    
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
    @JoinColumn(name = "id_opcion_respuesta")
    List<ItemOpcionRespuesta> listaIor;
    
   
   @OneToOne(fetch = FetchType.EAGER
           )
    @JoinColumn(name="id_registro_auditoria")
    private RegistroAuditoria registroAudotria;

    public RegistroAuditoria getRegistroAudotria() {
        return registroAudotria;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void setRegistroAudotria(RegistroAuditoria registroAudotria) {
        this.registroAudotria = registroAudotria;
    }
    
    public List<ItemOpcionRespuesta> getListaIor() {
        return listaIor;
    }

    public void setListaIor(List<ItemOpcionRespuesta> listaIor) {
        this.listaIor = listaIor;
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

    public void setEliminando(boolean eliminado) {
        this.eliminado = eliminado;
    }

    
    
}
