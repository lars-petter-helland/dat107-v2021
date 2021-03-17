package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TodolisteDAO {

    private EntityManagerFactory emf;

    public TodolisteDAO() {
        emf = Persistence.createEntityManagerFactory("TodoPU");
    }

    public Todoliste finnListe(int listeNr) {
        EntityManager em = emf.createEntityManager();

        Todoliste liste = null;
        try {
        	
            //TODO
            
        } finally {
            em.close();
        }
        return liste;
    }

    public void lagreListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            //TODO
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void slettListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            //TODO
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void oppdaterListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            //TODO
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public Todoliste finnListePaaNavn(String navn) {

        String queryString = "???"; //TODO

        EntityManager em = emf.createEntityManager();

        Todoliste liste = null;
        try {
        	//TODO
            
        } catch (NoResultException e) {
            // catcher denne og returnerer null :)
        } finally {
            em.close();
        }
        return liste;
    }

    public List<Todo> finnTodosIListe(int listeId) {

        String queryString = "???"; //TODO

        EntityManager em = emf.createEntityManager();

        List<Todo> todos = null;
        try {
            TypedQuery<Todo> query = em.createQuery(queryString, Todo.class);
            query.setParameter("listeId", listeId);
            todos = query.getResultList();
            
        } finally {
            em.close();
        }
        return todos;
    }

}
