/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name = "parametros_del_sistema")
public class ParametrosDelSistema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String instrucciones;
    @Column(name="cant_preguntas")
    private int cantidadPreguntas;
    @Column(name="accesos_permitidos")
    private int accesosPermitidos;
    @Column(name="tiempo_maximo_permitido")
    private int tiempoMaximoPermitido;
    @Column(name="tiempo_maximo_activo_permitido")
    private int tiempoMaximoActivoPermitido;

    public Integer getId() {
        return id;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public int getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public int getAccesosPermitidos() {
        return accesosPermitidos;
    }

    public int getTiempoMaximoPermitido() {
        return tiempoMaximoPermitido;
    }

    public int getTiempoMaximoActivoPermitido() {
        return tiempoMaximoActivoPermitido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setCantidadPreguntas(int cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public void setAccesosPermitidos(int accesosPermitidos) {
        this.accesosPermitidos = accesosPermitidos;
    }

    public void setTiempoMaximoPermitido(int tiempoMaximoPermitido) {
        this.tiempoMaximoPermitido = tiempoMaximoPermitido;
    }

    public void setTiempoMaximoActivoPermitido(int tiempoMaximoActivoPermitido) {
        this.tiempoMaximoActivoPermitido = tiempoMaximoActivoPermitido;
    }
    
    
    
}
