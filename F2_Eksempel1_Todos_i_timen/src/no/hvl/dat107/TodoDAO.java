package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author lph-lokal
 *
 */
public class TodoDAO {
	
	private EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("todoPersistenceUnit");
	
	/**
	 * @param pk
	 * @return
	 */
	public Todo finnTodoMedPk(int pk) {
		
		EntityManager em = emf.createEntityManager();

		try {
			return null; //TODO

		} finally {
			em.close();
		}
	}

	/**
	 * @return
	 */
	public List<Todo> finnAlleTodos() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			return null; //TODO
		
		} finally {
			em.close();
		}
	}

	/**
	 * @param tekst
	 * @return
	 */
	public List<Todo> finnTodosMedTekst(String tekst) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			return null; //TODO
		
		} finally {
			em.close();
		}
	}

	/**
	 * @param todony
	 */
	public void lagreNyTodo(Todo todony) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			//TODO
			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	/**
	 * @param pk
	 */
	public void slettTodoMedPk(int pk) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			//TODO
			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	/**
	 * @param todo
	 */
	public void oppdaterTodo(Todo todo) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			//TODO
			
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void oppdaterTekst(int id, String nyTekst) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			//TODO
						
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
}
