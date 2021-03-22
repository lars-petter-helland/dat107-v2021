package no.hvl.dat107.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(schema = "forelesning5b")
@IdClass(ProsjektdeltagelsePK.class)
public class Prosjektdeltagelse {

    private int timer;
    
    @Id
    @ManyToOne
    @JoinColumn(name="Ansatt_Id")
    private Ansatt ansatt;
    
    @Id
    @ManyToOne
    @JoinColumn(name="Prosjekt_Id")
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int timer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.timer = timer;
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk, 
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer);
    }

    @Override
    public String toString() {
        return "IKKE I BRUK";
//        return "PD(" + ansatt.getId() + ", " + prosjekt.getId() + "): " + timer + " timer";
    }
    
    
}






