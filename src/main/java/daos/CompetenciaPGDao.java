
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Competencia;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class CompetenciaPGDao implements CompetenciaDao{
    
    private SessionFactory sessionFactory;

    
    public CompetenciaPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
     public Competencia Get(int id){
        Session session = sessionFactory.openSession();
       
        Competencia competencia = (Competencia) session.get(Competencia.class, id);
        session.close();
        return competencia;
    }
    
    public int Save(Competencia p){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.getTransaction().commit();
        session.close();
        return p.getId();
    }

    public List<Integer> getCodigoAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT codigo FROM Competencia").getResultList();
        //session.close();
        
    }
    public List<String> getNombreAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT nombre FROM Competencia").getResultList();
    }
    
 
    public Competencia Get(String n){
        Session session = sessionFactory.openSession();
    
        Query<Competencia> query = session.createQuery("FROM Competencia c WHERE c.nombre =:nombre", Competencia.class);
     query.setParameter("nombre", n);
     return query.uniqueResult();
    }

}
