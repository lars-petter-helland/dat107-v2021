package no.hvl.dat107;

public class Main {

    public static void main(String[] args) {
        
        KontorDAO kontorDAO = new KontorDAO();
        
        Rom romE425 = kontorDAO.finnRomNr("E425");
        System.out.println(romE425);
        Rom romF118 = kontorDAO.finnRomNr("F118");
        System.out.println(romF118);
        
        Ansatt ansatt1 = kontorDAO.finnAnsattNr(1);
        System.out.println(ansatt1);
        Ansatt ansatt2 = kontorDAO.finnAnsattNr(2);
        System.out.println(ansatt2);
        
    }
}
