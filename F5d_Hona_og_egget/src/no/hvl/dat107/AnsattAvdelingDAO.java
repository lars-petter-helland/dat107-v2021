package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AnsattAvdelingDAO {

    private EntityManagerFactory emf;

    public AnsattAvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("f5d");
    }

    public Ansatt finnAnsatt(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }
    
    public Avdeling finnAvdeling(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
    }
    
    public Ansatt lagreNyAnsatt(String navnPaaNyAnsatt, Avdeling avdeling) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Ansatt ansatt = null;
        
        try {
            tx.begin();
            
            //Antar at avdeling er en eksisterende avdeling i databasen.
            
            //1 - Lage et ansattobjekt med den ansattes navn og avdeling
            ansatt = new Ansatt(navnPaaNyAnsatt, avdeling);
            
            //Merk: B�de ansatt og avdeling er "detached", og ansatt er
            //      heller ikke lagret i databasen.

            //2 - Lagrer ansatt i databasen. Er n� ogs� "managed".
            em.persist(ansatt);
                        
            //3 - Vedlikeholde toveisforbindelsen ved � legge ansatt til
            //    i avdelingen og synce mot databasen.
            avdeling.leggTilAnsatt(ansatt);
            em.merge(avdeling);           
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return ansatt;
    }
    
    public Avdeling lagreNyAvdeling(String navnPaaNyAvdeling, Ansatt sjef) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Avdeling nyAvdeling = null;
        
        try {
            tx.begin();
            
            //Antar at sjef er en eksisterende ansatt i en annen avdeling
            //i databasen.
            
            //0 - Trenger � fjerne den ansatte fra den gamle avdelingen,
            //    s� begynner med � gj�re det.
            Avdeling gammelAvdeling = sjef.getAvdeling();
            gammelAvdeling.fjernAnsatt(sjef);
            em.merge(gammelAvdeling);
            
            //1 - Lage et avdelingsobjekt med avdelingens navn og sjef
            //    og legge til den ansatte.
            nyAvdeling = new Avdeling();
            nyAvdeling.setNavn(navnPaaNyAvdeling);
            nyAvdeling.setSjef(sjef);
            nyAvdeling.leggTilAnsatt(sjef);
            
            //Merk: B�de nyAvdeling og sjef er "detached", og nyAvdeling er
            //      heller ikke lagret i databasen.

            //2 - Lagrer nyAvdeling i databasen. Er n� ogs� "managed".
            em.persist(nyAvdeling);
                        
            //3 - Vedlikeholde toveisforbindelsen og synce mot databasen.
            sjef.setAvdeling(nyAvdeling);
            em.merge(sjef);           
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return nyAvdeling;
    }
    
}
