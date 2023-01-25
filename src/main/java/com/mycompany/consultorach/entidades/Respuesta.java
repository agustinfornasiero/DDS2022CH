/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "respuesta")
public class Respuesta implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
     
     
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name="id_item_opcion_respuesta_cuestionario")
     private ItemOpcionRespuestaCuestionario idIORC;

    public Integer getId() {
        return id;
    }

  /*  public PreguntaCuestionario getIdPreguntaCuestionario() {
        return idPreguntaCuestionario;
    }*/

    public ItemOpcionRespuestaCuestionario getIdIORC() {
        return idIORC;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public void setIdPreguntaCuestionario(PreguntaCuestionario idPreguntaCuestionario) {
        this.idPreguntaCuestionario = idPreguntaCuestionario;
    }*/

    public void setIdIORC(ItemOpcionRespuestaCuestionario idIORC) {
        this.idIORC = idIORC;
    }
     
     
     
}
