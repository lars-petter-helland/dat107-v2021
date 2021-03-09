package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PersonDAO {

    private EntityManagerFactory emf;
    
    public PersonDAO() {
        emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
    }
    
    public int savePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(p);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return p.getId();
    }
    
    public Person retrievePerson(int id) {

        EntityManager em = emf.createEntityManager();

        Person p = null;
        try {
            p = em.find(Person.class, id);
        } finally {
            em.close();
        }
        
        return p;
    }
    
    public List<Person> retrieveAllePersoner() {

        EntityManager em = emf.createEntityManager();

        List<Person> personer = null;
        try {
            String queryString = "SELECT p FROM Person p ORDER BY p.id";
            TypedQuery<Person> query = em.createQuery(queryString, Person.class);
            personer = query.getResultList();
        } finally {
            em.close();
        }
        return personer;
    }
    
    public void updatePerson(Person p) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Person q = em.merge(p);
            
            boolean x = p.getNavn().equals("X");
            if (x) p.setNavn("Tull");   //Virker ikke siden p er detached
            if (x) q.setNavn("Tull");   //Virker siden q er managed
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void deletePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.merge(p));
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
