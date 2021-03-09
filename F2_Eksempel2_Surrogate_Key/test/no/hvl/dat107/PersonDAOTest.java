package no.hvl.dat107;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonDAOTest {
    
    /*
     * Problemet med testing av klasser som jobber mot database
     * er at det er ikke alltid så lett å vite hva som er i
     * databasen. I tillegg må vi passe på at tester ikke endrer
     * på dataene slik at andre tester feiler.
     * 
     * Men ved å ha noen "faste" testdata i databasen kan man
     * via JUnit teste både at vi har kontakt med databasen og
     * at grunnleggende funksjonalitet virker.
     */

    PersonDAO personDAO;
    Person person1;
    
    @Before
    public void foerHverTest() {
        personDAO = new PersonDAO();
        person1 = personDAO.retrievePerson(1);
    }
    
	@Test
	public void person1SkalHetePer() {
		assertEquals("Per Viskeler", person1.getNavn());
	}
	
	@Test
	public void endringAvNavnSkalVirkeFint() {
	    
        String gammeltNavn = person1.getNavn();
        String nyttNavn = "Nytt Navn";
        
        //Skifter til nytt navn og sjekker
        person1.setNavn(nyttNavn);
        personDAO.updatePerson(person1);
        person1 = personDAO.retrievePerson(1);
        assertEquals(nyttNavn, person1.getNavn());
        
        //Skifter tilbake for å ikke ødelegge for fremtidige tester.
        //Dette kan gjøres bedre, men det blir litt komplisert.
        person1.setNavn(gammeltNavn);
        personDAO.updatePerson(person1);
        person1 = personDAO.retrievePerson(1);
        assertEquals(gammeltNavn, person1.getNavn());
	}
	
	

}
