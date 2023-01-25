
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Puesto;
import com.mycompany.consultorach.entidades.Puntuacion;
import dtos.PuestoDTO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class PuestoPGDao implements PuestoDao{

    private SessionFactory sessionFactory;

    
    public PuestoPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
     public Puesto Get(int id){
        Session session = sessionFactory.openSession();
       
        Puesto puesto = (Puesto) session.get(Puesto.class, id);
        session.close();
        return puesto;
    }
    
    public int SavePuesto(Puesto p){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.getTransaction().commit();
        session.close();
        return p.getId();
    }

    public List<Integer> getCodigoAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT codigo FROM Puesto").getResultList();
        
    }
    public List<String> getNombreAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT nombre FROM Puesto").getResultList();
    }
    public int SavePuntuacion(Puntuacion puntuacion) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(puntuacion);
        session.getTransaction().commit();
        session.close();
        return puntuacion.getId();
        
    }
    
     public List<Puesto> buscarPuestos(PuestoDTO dto){
       Session session = sessionFactory.openSession();
        Query<Puesto> query;
         if(dto.getCodigoP().isEmpty()==false){
            int codigo=Integer.parseInt(dto.getCodigoP());
         query = session.createQuery("SELECT p FROM Puesto p WHERE p.codigo=:codigo", Puesto.class);
            query.setParameter("codigo", codigo);
       
        }else if(dto.getNombre().isEmpty()==false && dto.getEmpresa().isEmpty()==false)
         {
              query = session.createQuery("SELECT p FROM Puesto p WHERE p.nombre LIKE :nombre AND p.empresa LIKE :empresa", Puesto.class);
            query.setParameter("nombre", dto.getNombre() +"%");
            query.setParameter("empresa", dto.getEmpresa() +"%");
         }else if(dto.getNombre().isEmpty()==false && dto.getEmpresa().isEmpty()==true){
             query = session.createQuery("SELECT p FROM Puesto p WHERE p.nombre LIKE :nombre", Puesto.class);
            query.setParameter("nombre", dto.getNombre() +"%");
         }else{
             query = session.createQuery("SELECT p FROM Puesto p WHERE  p.empresa LIKE :empresa", Puesto.class);
            query.setParameter("empresa", dto.getEmpresa() +"%");
         }
         return query.getResultList();
    }
       public Puesto obtenerPuesto(Integer codigo) {
        
        Session session = sessionFactory.openSession();
        Query<Puesto> query = session.createQuery("SELECT p FROM Puesto p WHERE p.codigo=:cod", Puesto.class);
        query.setParameter("cod", codigo);
        return query.getSingleResult();
        
    }
       
       public Puesto unicoPuesto(String nombreEmpresa,String nombrePuesto){
         Session session = sessionFactory.openSession();
        Query<Puesto> query = session.createQuery("SELECT p FROM Puesto p WHERE p.nombre=:nom AND p.empresa=:emp", Puesto.class);
        query.setParameter("nom", nombrePuesto);
        query.setParameter("emp", nombreEmpresa);
        return query.getSingleResult();
       }
}
