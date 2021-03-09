package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main3CompleteCrud {

	public static void main(String[] args) {
		
		Main3CompleteCrud crud = new Main3CompleteCrud();
		
		System.out.println(crud.retrievePerson(1001));
		System.out.println(crud.retrievePerson(1002));
		System.out.println(crud.retrievePerson(1003));
		System.out.println("---");
		
		for (Person p : crud.retrieveAllePersoner2()) {
			System.out.println(p);
		}
		System.out.println("---");
		
		Person per = crud.retrievePerson(1001);
		System.out.println(per);
		
		crud.updatePerson(per.getId(), "X");
		per = crud.retrievePerson(1001);
		System.out.println(per);
		
		crud.updatePerson(per.getId(), "Per Viskeler");
		per = crud.retrievePerson(1001);
		System.out.println(per);
		System.out.println("---");
		
		Person mikke = new Person(1004, "Mikke Mus");
		crud.createPerson(mikke);
		mikke = crud.retrievePerson(1004);
		System.out.println(mikke);
		
		crud.deletePerson(mikke);
		mikke = crud.retrievePerson(1004);
		System.out.println(mikke);
		System.out.println("---");
		
	}
	
	//------------------------------------------------------------------------
	
	private EntityManagerFactory emf;
	
	public Main3CompleteCrud() {
		emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
	}
	
	public void createPerson(Person p) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(p); //Oppretter en ny rad i databasen
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
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
			TypedQuery<Person> query = em.createQuery(
			        "SELECT p FROM Person p", Person.class);
			personer = query.getResultList();
		} finally {
			em.close();
		}
		return personer;
	}
	
	public List<Person> retrieveAllePersoner2() {
		/* Tester ut NamedQuery */

		EntityManager em = emf.createEntityManager();

		List<Person> personer = null;
		try {
			TypedQuery<Person> query = em.createNamedQuery("hentAllePersoner", Person.class);
			personer = query.getResultList();
		} finally {
			em.close();
		}
		return personer;
	}
	
	public void updatePerson(int id, String nyttNavn) {

		EntityManager em = emf.createEntityManager();

		try {
			Person p = em.find(Person.class, id);
			p.setNavn(nyttNavn);
		
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
			
			em.remove(em.find(Person.class, p.getId()));
			
			em.getTransaction().commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
