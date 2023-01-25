
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
@Table(name= "ponderacion")
public class Ponderacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column
    private Integer ponderacion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_item_opcion_respuesta")
    private ItemOpcionRespuesta ior;

    public Ponderacion() {
    }
    

    public Integer getId() {
        return id;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Integer ponde) {
        this.ponderacion = ponde;
    }
    public void setItemOpcionRespuesta(ItemOpcionRespuesta ior){
        this.ior = ior;
    }
    public ItemOpcionRespuesta getItemOpcionRespuesta(){
        return ior;
    }

}