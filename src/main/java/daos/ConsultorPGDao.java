/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Consultor;
import dtos.UsuarioDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Zapa
 */
public class ConsultorPGDao implements ConsultorDao{
    
    private SessionFactory sessionFactory;
    
    public ConsultorPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
    public Consultor Get(int id){
        System.out.println("hasta aca llego");
        Session session = sessionFactory.openSession();
        Consultor consultor = (Consultor) session.get(Consultor.class, id);
        session.close();
        return consultor;
    }

    public Consultor buscarConsultor(UsuarioDTO userDTO) {
       
        Session session = sessionFactory.openSession();
        Query<Consultor> query = session.createQuery("SELECT c FROM Consultor c WHERE c.usuario=:user", Consultor.class);
        query.setParameter("user", userDTO.getNombreDeUsuario());
       
        return query.getSingleResult();
    }
    
}