package com.mycompany.consultorach.entidades;


import enums.TipoCompetencia;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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


@Entity
@Table(name = "competencia")
public class Competencia {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer codigo;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String tipo_competencia;
    @Column
    private Boolean eliminado;
 
   @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_competencia")
   List<Factor> factores;
   
    
     @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_registro_auditoria")
     private RegistroAuditoria registroAuditoria;

    public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
        this.registroAuditoria = registroAuditoria;
    }

    public RegistroAuditoria getRegistroAuditoria() {
        return registroAuditoria;
    }
   
    public Integer getId() {
        return id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<Factor> getFactores() {
        return factores;
    }

    public void setFactores(List<Factor> factores) {
        this.factores = factores;
    }
    
    public void setTipo_competencia(String tipo_competencia) {
        this.tipo_competencia = tipo_competencia;
    }

    public String getTipo_competencia() {
        return tipo_competencia;
    }
    
}