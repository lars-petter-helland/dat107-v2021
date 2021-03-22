package no.hvl.dat107.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning5b")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String fornavn;
    private String etternavn;
    
    @OneToMany(mappedBy="ansatt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %d: %s %s", innrykk, id, fornavn, etternavn);
    }
    
    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(p -> p.skrivUt("\n   "));
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

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}
    
    

}
