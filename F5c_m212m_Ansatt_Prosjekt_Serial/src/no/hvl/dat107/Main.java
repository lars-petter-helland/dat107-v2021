package no.hvl.dat107;

import no.hvl.dat107.dao.AnsattDAO;
import no.hvl.dat107.dao.ProsjektDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;

public class Main {

    public static void main(String[] args) {
        
        AnsattDAO ansattDAO = new AnsattDAO();
        ProsjektDAO prosjektDAO = new ProsjektDAO();
        
        Ansatt a2 = ansattDAO.finnAnsattMedId(2);
        a2.skrivUtMedProsjekter();

        Prosjekt p2 = prosjektDAO.finnProsjektMedId(2);
        p2.skrivUtMedAnsatte();

        Prosjekt p3 = prosjektDAO.finnProsjektMedId(3);
        p3.skrivUtMedAnsatte();

        ansattDAO.registrerProsjektdeltagelse(a2, p3);
        a2 = ansattDAO.finnAnsattMedId(2);
        p3 = prosjektDAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
        
        ansattDAO.slettProsjektdeltagelse(a2, p3);
        a2 = ansattDAO.finnAnsattMedId(2);
        p3 = prosjektDAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
    }

}
