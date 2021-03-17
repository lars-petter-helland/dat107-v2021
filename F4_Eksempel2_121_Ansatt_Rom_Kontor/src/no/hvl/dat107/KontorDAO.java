package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KontorDAO {

    private EntityManagerFactory emf;

    public KontorDAO() {
        emf = Persistence.createEntityManagerFactory(
                "KontorPersistenceUnit");
    }

    public Rom finnRomNr(String romNr) {
        EntityManager em = emf.createEntityManager();
        Rom rom = null;
        try {
            rom = em.find(Rom.class, romNr);
        } finally {
            em.close();
        }
        return rom;
    }
    
    public Ansatt finnAnsattNr(int ansNr) {
        EntityManager em = emf.createEntityManager();
        Ansatt ansatt = null;
        try {
            ansatt = em.find(Ansatt.class, ansNr);
        } finally {
            em.close();
        }
        return ansatt;
        
    }
    
//    public List<Rom> finnAlleRom() {
//        JPQL
//    }
//    
//    public List<Ansatt> finnAlleAnsatte() {
//        JPQL
//    }

}
