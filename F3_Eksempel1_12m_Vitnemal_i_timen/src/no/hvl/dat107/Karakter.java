package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning3")
public class Karakter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int karnr;
	private String emnekode;
	private String bokstav;
	
	@ManyToOne
	@JoinColumn(name = "StudNr", referencedColumnName = "StudNr")
	private Vitnemal vitnemal;

	@Override
	public String toString() {
		return "Karakter [karnr=" + karnr + ", emnekode=" + emnekode 
				+ ", bokstav=" + bokstav + "]";
	}
	
}
