package no.hvl.dat107.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning6a")
@PrimaryKeyJoinColumn(referencedColumnName = "FNr")
public class Ansatt extends Person { 

    private String stilling;

    public Ansatt() {}
    
    public Ansatt(String fNr, String fornavn, String etternavn, String stilling) {
        super(fNr, fornavn, etternavn);
        this.stilling = stilling;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", stilling=" + stilling;
    }


}

