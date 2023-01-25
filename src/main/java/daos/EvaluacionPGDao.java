/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Evaluacion;
import com.mycompany.consultorach.entidades.Puesto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class EvaluacionPGDao implements EvaluacionDao {
     private SessionFactory sessionFactory; 
    public EvaluacionPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
    public Evaluacion Get(int id){
        Session session = sessionFactory.openSession();
       
        Evaluacion e = (Evaluacion) session.get(Evaluacion.class, id);
        session.close();
        return e;
    }
    public int SaveEvaluacion(Evaluacion e){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        return e.getId();
     }
}
