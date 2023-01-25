/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Candidato;
import org.hibernate.SessionFactory;
import com.mycompany.consultorach.entidades.Cuestionario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 *
 * @author Vulturius
 */
public class CuestionarioPGDao implements CuestionarioDao{
    private SessionFactory sessionFactory;

    
    public CuestionarioPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
     public Cuestionario Get(int id){
        Session session = sessionFactory.openSession();
       
        Cuestionario cuestionario = (Cuestionario) session.get(Cuestionario.class, id);
        session.close();
        return cuestionario;
    }
    
    public List<Cuestionario> obtenerCuestionario(String clave, int idCandidato) {
        String estadoA, estadoE;
        estadoA="ACTIVO";
        estadoE="EN_PROCESO";
        Session session = sessionFactory.openSession();
        Query<Cuestionario> query = session.createQuery("SELECT c FROM Cuestionario c WHERE c.clave=:clv AND c.candidato.id=:idCandidato AND (c.estado=:ACTIVO OR c.estado=:EN_PROCESO)", Cuestionario.class);
        query.setParameter("clv", clave);
        query.setParameter("idCandidato", idCandidato);
        query.setParameter("ACTIVO", estadoA);
        query.setParameter("EN_PROCESO", estadoE);
        return query.getResultList();
        /*Cuestionario c=query.getSingleResult();
        if(c== null)return null;
        else return c;*/
    }
     public List<Cuestionario> getCuestionarioByidCandidato(int id) {
        Session session = sessionFactory.openSession();
        Query<Cuestionario> query = session.createQuery("SELECT c FROM Cuestionario c WHERE c.candidato.id=:idCandidato", Cuestionario.class);
        query.setParameter("idCandidato", id);
        return query.getResultList();
    }

    public void Save(Cuestionario c) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        session.close();
    }

  

   
}
