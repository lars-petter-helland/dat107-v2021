package no.hvl.dat107;

public class Main2 {

    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO();

        Person lars = new Person();
        lars.setNavn("Lars");
        System.out.println(lars);
        
        int id = personDAO.savePerson(lars);
        System.out.println(lars);
        
        System.out.println("Returnert ID: " + id);
    }

}
