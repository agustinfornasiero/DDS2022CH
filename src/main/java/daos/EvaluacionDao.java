/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.consultorach.entidades.Evaluacion;

/**
 *
 * @author Vulturius
 */
public interface EvaluacionDao {
    public Evaluacion Get(int id);
    public int SaveEvaluacion(Evaluacion e);
}
