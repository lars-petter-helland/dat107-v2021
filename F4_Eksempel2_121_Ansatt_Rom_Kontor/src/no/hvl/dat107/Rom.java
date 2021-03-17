package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rom", schema = "forelesning4")
public class Rom {
    
    @Id
    private String romNr;
    private double kvm;
    
    @OneToOne(mappedBy = "kontor")
    private Ansatt ansatt;

    @Override
    public String toString() {
        String ansattString = ansatt != null ? ", kontoret til " 
                + ansatt.getFornavn() + " " + ansatt.getEtternavn() : "";
        return "Rom [romNr=" + romNr + ", kvm=" + kvm + ansattString + "]";
    }

    public String getRomNr() {
        return romNr;
    }
    
    
}



