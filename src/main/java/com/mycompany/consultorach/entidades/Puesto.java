package com.mycompany.consultorach.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "puesto")
public class Puesto {
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
    private String empresa;
    
    @Column
    private Boolean eliminado;
    
 
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_puesto")
    private List<Puntuacion> puntuaciones;

      @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_registro_auditoria")
     private RegistroAuditoria registroAuditoria;

    public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
        this.registroAuditoria = registroAuditoria;
    }

    public RegistroAuditoria getRegistroAuditoria() {
        return registroAuditoria;
    }
    
    public void setPuntuaciones(List<Puntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
     public Puesto(){
    }
    public void setId(Integer id){
        this.id = id;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }   

    public List<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }
}