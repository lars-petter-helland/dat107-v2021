package no.hvl.dat107.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(schema = "forelesning5c")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String navn;
    
    @OneToMany(mappedBy="prosjekt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s", innrykk, id, navn);
    }
    
    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(a -> a.skrivUt("\n   "));
    }

    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.add(prosjektdeltagelse);
    }

    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.remove(prosjektdeltagelse);
    }

	public int getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}
 
    
}






