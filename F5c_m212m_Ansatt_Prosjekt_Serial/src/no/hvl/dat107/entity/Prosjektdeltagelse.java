package no.hvl.dat107.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(schema = "forelesning5c")
public class Prosjektdeltagelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektdeltagelse_Id;
    
    private int timer;
    
    @ManyToOne
    @JoinColumn(name="Ansatt_Id")
    private Ansatt ansatt;
    
    @ManyToOne
    @JoinColumn(name="Prosjekt_Id")
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int timer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.timer = timer;
        
        //Hvis vi gjør dette her slipper vi å gjøre det i EAO
        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk, 
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer);
    }
    
}






