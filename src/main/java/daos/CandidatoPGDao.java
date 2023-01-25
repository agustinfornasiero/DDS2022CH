/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.consultorach.entidades.Candidato;
import dtos.UsuarioDTO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Zapa
 */
public class CandidatoPGDao implements CandidatoDao{
    private SessionFactory sessionFactory;

    
    public CandidatoPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    public List<String> getDocumentoAll() {
            
         Session session = sessionFactory.openSession();
         return  session.createQuery("SELECT documento FROM Candidato").getResultList();
      
    }
    
     public Candidato Get(int numeroCandidato){
        Session session = sessionFactory.openSession();
       
        Candidato candidato = (Candidato) session.get(Candidato.class, numeroCandidato);
        session.close();
        return candidato;
    }

    public Candidato buscarCandidato(String numDoc,String tipoDocumento) {
        Session session = sessionFactory.openSession();
        Query<Candidato> query = session.createQuery("SELECT c FROM Candidato c WHERE c.documento=:doc AND c.tipoDocumento=:tipo", Candidato.class);
        query.setParameter("doc", numDoc);
        query.setParameter("tipo", tipoDocumento);
        return query.getSingleResult();
        
    }
    
     public List<Candidato> buscarCandidatoSegunCriterio(UsuarioDTO user) {
        
        Session session = sessionFactory.openSession();
        
        int nroCandidato = user.getNumeroCandidato();
        String apellido = user.getApellido();
        String nombre = user.getNombre();
        
        
        if(nroCandidato!=-1)
        {   
        Query<Candidato> query = session.createQuery("SELECT c FROM Candidato c WHERE c.numeroCandidato=:num", Candidato.class);
        query.setParameter("num", nroCandidato);
        return query.getResultList();
        }
        else if(nroCandidato==-1 && (apellido.isEmpty()==false && nombre.isEmpty()==false))
        {
        Query<Candidato> query = session.createQuery("SELECT c FROM Candidato c WHERE c.nombre LIKE :nom AND c.apellido LIKE :ape", Candidato.class);
        query.setParameter("ape", apellido +"%");
        query.setParameter("nom", nombre +"%");
        return query.getResultList();      
        }
        else if(nroCandidato==-1 && apellido.isEmpty() && nombre.isEmpty()==false)
        {
        Query<Candidato> query = session.createQuery("SELECT c FROM Candidato c WHERE c.nombre LIKE :nom", Candidato.class);
        query.setParameter("nom", nombre +"%");
        return query.getResultList();      
        }
        else if(nroCandidato==-1 && apellido.isEmpty()==false && nombre.isEmpty())
        {
        Query<Candidato> query = session.createQuery("SELECT c FROM Candidato c WHERE c.apellido LIKE :ape", Candidato.class);
        query.setParameter("ape", apellido +"%");
        return query.getResultList();      
        }
        else return null;
    }
}