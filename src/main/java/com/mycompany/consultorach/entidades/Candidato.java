/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultorach.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Zapa
 */
@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="numero_candidato")
    private Integer numeroCandidato;
    @Column(name="tipo_documento")
    private String tipoDocumento;
    @Column
    private String documento;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column(name="fecha_nac")
    private Date fechaNacimiento;
    @Column
    private String nacionalidad;
    @Column
    private  String email;
    @Column
    private String escolaridad;
    @Column
    private boolean eliminado;
    
    @OneToOne(fetch = FetchType.EAGER,
     cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuestionario_actual")
    private Cuestionario cuestionario;

    public void setId(Integer id) {
        this.id = id;
    
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }
    
    
public void setNumeroCandidato(Integer numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
     public String getTipoDocumento() {
       return tipoDocumento;
    }
    public Integer getId() {
        return id;
    }
     

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
public String getNombre() {
        return nombre;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}