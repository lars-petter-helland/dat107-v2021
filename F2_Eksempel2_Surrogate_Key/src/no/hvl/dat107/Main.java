package no.hvl.dat107;

public class Main {

    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO();

        finnEnOgEn(personDAO);

        finnAlle(personDAO);

        skiftNavnFremOgTilbake(personDAO);

        opprettOgSlettPerson(personDAO);

    }

    private static void finnEnOgEn(PersonDAO personDAO) {

        System.out.println(personDAO.retrievePerson(1));
        System.out.println(personDAO.retrievePerson(2));
        System.out.println(personDAO.retrievePerson(3));
        System.out.println(personDAO.retrievePerson(4));

        System.out.println("---");
    }

    private static void finnAlle(PersonDAO personDAO) {

        for (Person p : personDAO.retrieveAllePersoner()) {
            System.out.println(p);
        }

        System.out.println("---");
    }

    private static void skiftNavnFremOgTilbake(PersonDAO personDAO) {

        Person per = personDAO.retrievePerson(1);

        System.out.println(per);

        per.setNavn("X");
        personDAO.updatePerson(per);
        per = personDAO.retrievePerson(1);
        System.out.println(per);

        per.setNavn("Per Viskeler");
        personDAO.updatePerson(per);
        per = personDAO.retrievePerson(1);
        System.out.println(per);

        System.out.println("---");
    }

    private static void opprettOgSlettPerson(PersonDAO personDAO) {

        Person mikke = new Person();
        mikke.setNavn("Mikke Mus");

        int nyPersonId = personDAO.savePerson(mikke);
        
        mikke = personDAO.retrievePerson(nyPersonId);
        System.out.println(mikke);

        personDAO.deletePerson(mikke);
        mikke = personDAO.retrievePerson(nyPersonId);
        System.out.println(mikke);

        System.out.println("---");
    }

}
