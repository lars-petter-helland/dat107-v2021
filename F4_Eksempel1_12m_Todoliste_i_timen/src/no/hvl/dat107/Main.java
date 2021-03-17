package no.hvl.dat107;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
        
        TodolisteDAO todolisteDAO = new TodolisteDAO();

        Todo rydde = new Todo("Rydde");
        Todo vaskeOpp = new Todo("Vaske opp");
        Todo stovsuge = new Todo("Støvsuge");
        Todo vaskeVinduer = new Todo("Vaske vinduer");
        
        //------------------------------------------------------------------------
        
//        System.out.println("\n\nLager en liste [Husarbeid], legger til 3 todos og lagrer ...");
//        
//        Todoliste husarbeid = new Todoliste("Husarbeid");
//        
//        husarbeid.leggTil(rydde);
//        husarbeid.leggTil(vaskeOpp);
//        husarbeid.leggTil(stovsuge);
//        
//        todolisteDAO.lagreListe(husarbeid);
//        int listeId = husarbeid.getListeId();
//       
//        System.out.println("Etter lagreListe():");
//        System.out.println(todolisteDAO.finnListe(listeId));
//
//		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
//        
//        //------------------------------------------------------------------------
//        
//        System.out.println("\n\nEndrer navn, fjerner [Vaske Opp], legger til [Vaske vinduer], "
//        		+ "endrer støvsuging-tekst til \"Gøy støvsuging\" og oppdaterer ...");
//
//        husarbeid.setNavn("Gøy husarbeid");
//        husarbeid.fjern(vaskeOpp);         
//        husarbeid.leggTil(vaskeVinduer);   
//        stovsuge.setTekst("Gøy støvsuging");
//       
//        todolisteDAO.oppdaterListe(husarbeid);
//        
//        System.out.println("Etter oppdaterListe():");
//        System.out.println(todolisteDAO.finnListe(listeId));
//        
//		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
//        
//        //------------------------------------------------------------------------
//        
////        System.out.println("\n\nSøker opp listen på navn ...");
////        
////        System.out.println("Etter finnListePaaNavn(\"Gøy husarbeid\")");
////        System.out.println(todolisteDAO.finnListePaaNavn("Gøy husarbeid"));
//        
//        //------------------------------------------------------------------------
//        
////        System.out.println("\n\nHvis kun enveis forhold, finne todos med JPQL ...");
////        
////        System.out.println("Etter finnTodosIListe(husarbeid.getListeId())");
////        System.out.println(todolisteDAO.finnTodosIListe(listeId));
////        
//        //------------------------------------------------------------------------
//        
//        System.out.println("\n\nSletter listen ...");
//        
//        todolisteDAO.slettListe(husarbeid);
//        System.out.println("Etter slettListe()");
//        System.out.println(todolisteDAO.finnListe(listeId));
//        
//		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
//        
        System.out.println("Programmet er ferdig! :)");
    }
    
	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
    
}






