/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import com.mycompany.consultorach.entidades.PreguntaCuestionario;
import java.util.List;


/**
 *
 * @author Zapa
 */

public class BloquePreguntasDTO {
   
    int id;
   
    int numero;
    
    String estado;
    
    int cantPreguntas;
   
    boolean BloqueFinal;
    
    
    List<PreguntaCuestionario> preguntaCuestionario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(int cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    public boolean isBloqueFinal() {
        return BloqueFinal;
    }

    public void setBloqueFinal(boolean BloqueFinal) {
        this.BloqueFinal = BloqueFinal;
    }

    public List<PreguntaCuestionario> getPreguntaCuestionario() {
        return preguntaCuestionario;
    }

    public void setPreguntaCuestionario(List<PreguntaCuestionario> preguntaCuestionario) {
        this.preguntaCuestionario = preguntaCuestionario;
    }
    
    
}
