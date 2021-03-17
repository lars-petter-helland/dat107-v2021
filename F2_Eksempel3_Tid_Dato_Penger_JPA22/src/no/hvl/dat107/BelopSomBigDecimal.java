package no.hvl.dat107;

import java.math.BigDecimal;

public class BelopSomBigDecimal {

    public static void main(String[] args) {

        // IKKE OK BigDecimal fireKronerOgTiOre = new BigDecimal(4.10);
        // OK      BigDecimal fireKronerOgTiOre = new BigDecimal("4.10");
        // OK      BigDecimal fireKronerOgTiOre = BigDecimal.valueOf(4.10);

        BigDecimal fireKronerOgTiOre = BigDecimal.valueOf(4.10);
        BigDecimal tiOre = BigDecimal.valueOf(0.10);

        BigDecimal fireKroner = fireKronerOgTiOre.subtract(tiOre);

        // Hva blir skrevet ut p� skjermen?
        System.out.println(fireKronerOgTiOre);
        System.out.println(tiOre);
        System.out.println(fireKroner);
    }

}
