package no.hvl.dat107;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//a)    Søke opp vitnemålet til en gitt student.
		//b.i)  Registrere en ny karakter for en gitt student. Karakter finnes ikke fra før.
		//b.ii) Registrere en ny karakter for en gitt student. Karakter finnes fra før!
		//c)    Søke opp karakteren til en gitt student i et gitt kurs.
		
		VitnemalDAO vitnemalDAO = new VitnemalDAO();

		
//		//a) Søke opp vitnemålet til en gitt student.
//		Vitnemal vitnemal = vitnemalDAO.finnVitnemalForStudent(123456);
//
//		System.out.println("\n### Vitnemål for student 123456:");
//		vitnemal.skrivUt();
//		
//		
//		//b.i)  Registrere en ny karakter for en gitt student. Karakter finnes ikke fra før.
//		
//		String emnekodeRegistrering = "DAT666";
//		
//		System.out.println("\n### Legger inn en ny karakter:");
//		
//		Karakter nyKarakter = vitnemalDAO.registrerKarakterForStudent(
//				123456, emnekodeRegistrering, LocalDate.of(2019, 12, 12), "C");
//		
//		System.out.println(nyKarakter);
//		
//		vitnemal = vitnemalDAO.finnVitnemalForStudent(123456);
//		System.out.println("\n### Vitnemål for student 123456:");
//		vitnemal.skrivUt();
//
//		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
//
//		
//		//b.ii) Oppdatere karakter for en gitt student. Karakter finnes fra før!
//		System.out.println("\n### Oppdaterer karakter:");
//		
//		Karakter oppdatertKarakter = vitnemalDAO.registrerKarakterForStudent(
//				123456, emnekodeRegistrering, LocalDate.of(2020, 04, 03), "A");
//		
//		System.out.println(oppdatertKarakter);
//		
//		vitnemal = vitnemalDAO.finnVitnemalForStudent(123456);
//		System.out.println("\n### Vitnemål for student 123456:");
//		vitnemal.skrivUt();
//
//		pauseOgSjekkDatabasen("\nSjekk at vi har fått oppdatert databasen riktig.");
//		
//		//c) Søke opp karakteren til en gitt student i et gitt kurs.
//		Karakter dat102Karakter = vitnemalDAO.finnKarakter(123456, "DAT102");	
//		
//		System.out.println("\n### Karakter i DAT102 for student 123456:");
//		System.out.println(dat102Karakter);
		
		System.out.println("\n Ferdig!");
	}

	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
}
