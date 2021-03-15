package no.hvl.dat107;

// Sjekk ut https://www.thoughts-on-java.org/map-date-time-api-jpa-2-2/

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tidogpenger", schema = "datatyper")
public class TidOgPenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal belop;
    private LocalDate dato;
    private LocalTime klokkeslett;
    private LocalDateTime tidsstempel;

    public TidOgPenger() {
    }

    public TidOgPenger(BigDecimal belop, LocalDate dato, LocalTime klokkeslett,
            LocalDateTime tidsstempel) {
        this.belop = belop;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.tidsstempel = tidsstempel;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBelop() {
        return belop;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getKlokkeslett() {
        return klokkeslett;
    }

    public LocalDateTime getTidsstempel() {
        return tidsstempel;
    }

    @Override
    public String toString() {
        return "TidOgPenger [id=" + id + ", belop=" + belop + ", dato=" + dato + ", klokkeslett="
                + klokkeslett + ", tidsstempel=" + tidsstempel + "]";
    }

}
