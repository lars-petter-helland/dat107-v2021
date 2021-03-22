package no.hvl.dat107;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "f5d")
public class Avdeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;
    
    @OneToMany(mappedBy="avdeling")
    private List<Ansatt> ansatte = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "sjef_id")
    private Ansatt sjef;
    
    public void skrivUtMedAnsatte() {
        skrivUt();
        ansatte.forEach(Ansatt::skrivUt);
    }

    public void skrivUt() {
        System.out.printf(" Avdeling %d(%s): %d ansatte, sjef = %s%n", 
                id, navn, ansatte.size(), sjef.getNavn());
    }

    public void leggTilAnsatt(Ansatt ansatt) {
        ansatte.add(ansatt);
        ansatt.setAvdeling(this);
    }

    public void fjernAnsatt(Ansatt ansatt) {
        ansatte.remove(ansatt);
        ansatt.setAvdeling(null);
    }

	public int getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public Ansatt getSjef() {
		return sjef;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

    
}
