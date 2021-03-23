package no.hvl.dat107.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning6a")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    private String fNr; // Fødselsnummer, 11 siffer, f.eks. "12345678901"
    
    private String fornavn;
    private String etternavn;
    
    public Person() {}
    
    public Person(String fNr, String fornavn, String etternavn) {
        this.fNr = fNr;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    @Override
    public String toString() {
        return "fNr=" + fNr + ", fornavn=" + fornavn + ", etternavn=" + etternavn;
    }

}
