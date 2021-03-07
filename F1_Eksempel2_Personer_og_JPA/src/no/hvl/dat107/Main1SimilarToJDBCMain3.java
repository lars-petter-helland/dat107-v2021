package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main1SimilarToJDBCMain3 {

	public static void main(String[] args) {

		String jpql = "SELECT p FROM Person p";
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("personPersistenceUnit");

		EntityManager em = emf.createEntityManager();
		
		System.out.println("Kobler til database...");

		try {
	        TypedQuery<Person> query = em.createQuery(jpql, Person.class);
	        List<Person> personer = query.getResultList();
		    
	        for (Person p : personer) {
	            System.out.print("Id: " + p.getId());
	            System.out.println(", Navn: " + p.getNavn());
	        }
		} finally {
	        em.close();
		}

		System.out.println("Ferdig!");
	}

}
