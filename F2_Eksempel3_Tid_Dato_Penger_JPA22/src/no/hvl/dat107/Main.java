package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        
        TidOgPengerDAO dao = new TidOgPengerDAO();
        
        TidOgPenger top = dao.hentTidOgPengerMedId(1);
        System.out.println(top);
        
        TidOgPenger ny = new TidOgPenger(
                new BigDecimal("199.50"),
                LocalDate.of(2021, Month.APRIL, 1),
                LocalTime.of(14, 50),
                LocalDateTime.of(2021, Month.AUGUST, 31, 23, 59));
        
        dao.lagreIDatabasen(ny);
        
        TidOgPenger denNye = dao.hentTidOgPengerMedId(ny.getId());
        System.out.println(denNye);
    }

}
