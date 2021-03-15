package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VitnemalDAO {

    private EntityManagerFactory emf;

    public VitnemalDAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU");
    }

    public Vitnemal finnVitnemalForStudent(int studNr) {
        
        EntityManager em = emf.createEntityManager();

        try {
        	return em.find(Vitnemal.class, studNr);

        } finally {
            em.close();
        }
    }

    public Karakter finnKarakter(int studNr, String emnekode) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	//TODO
        	return null;
        	
        } finally {
            em.close();
        }
    }
    
    public Karakter registrerKarakterForStudent(int studNr, String emnekode, 
    		LocalDate eksDato, String bokstav) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	//TODO
        	return null;

        } finally {
            em.close();
        }
    }

}
