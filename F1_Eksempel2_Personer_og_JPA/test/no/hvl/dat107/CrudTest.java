package no.hvl.dat107;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CrudTest {

	@Test
	public void person1001SkalHetePer() {
		Main3CompleteCrud crud = new Main3CompleteCrud();
		Person p = crud.retrievePerson(1001);
		assertEquals("Per Viskeler", p.getNavn());
	}
	
	

}
