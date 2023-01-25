package com.mycompany.consultorach;

import com.mycompany.consultorach.entidades.Candidato;
import com.mycompany.consultorach.entidades.Consultor;
import com.mycompany.consultorach.entidades.Cuestionario;
import com.mycompany.consultorach.entidades.Puesto;
import daos.CandidatoPGDao;
import daos.ConsultorPGDao;
import daos.CuestionarioPGDao;
import daos.PuestoPGDao;
import dtos.PuestoDTO;
import dtos.UsuarioDTO;
import gestores.GestorCandidato;
import gestores.GestorConsultor;
import gestores.GestorPuesto;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 *
 * @author Vulturius
 * NO ES RECOMENDABLE CAMBIARLE EL NOMBRE A LA CLASE POR DEFECTO
 */
public class ConsultoraCH {

    public static void main(String[] args) {
       JFrame ventana = new JFrame();
       JPanel padre = new JPanel();
        
        
       ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       ventana.setSize(500, 400);
       ventana.setContentPane(new AutenticarUsuario(ventana,null));
      
        ventana.setVisible(true);
        PuestoPGDao puestoPGDao = new PuestoPGDao();
       
     

    }
   
}
