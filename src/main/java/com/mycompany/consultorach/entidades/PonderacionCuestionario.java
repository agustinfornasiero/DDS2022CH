
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
@Table(name= "ponderacioncuestionario")
public class PonderacionCuestionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column
    private Integer ponderacion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_item_opcion_respuesta_cuestionario")
    private ItemOpcionRespuestaCuestionario iorc;

    public PonderacionCuestionario() {
    }
    

    public Integer getId() {
        return id;
    }

    public Integer getPonderacionCuestionario() {
        return ponderacion;
    }

    public void setPonderacionCuestionario(Integer ponde) {
        this.ponderacion = ponde;
    }
    public void setItemOpcionRespuestaCuestionario(ItemOpcionRespuestaCuestionario iorc){
        this.iorc = iorc;
    }
    public ItemOpcionRespuestaCuestionario getItemOpcionRespuestaCuestionario (){
        return iorc;
    }

}