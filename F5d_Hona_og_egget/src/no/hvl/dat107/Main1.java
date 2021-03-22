package no.hvl.dat107;

import java.time.LocalTime;

public class Main1 {

	public static void main(String[] args) {
		
		AnsattAvdelingDAO aadao = new AnsattAvdelingDAO();
		
		aadao.finnAnsatt(1).skrivUt();
		aadao.finnAnsatt(4).skrivUt();
		aadao.finnAnsatt(7).skrivUt();

		aadao.finnAvdeling(1).skrivUt();
		aadao.finnAvdeling(2).skrivUt();
		
		System.out.println("\n---\n");
		
		Avdeling avdeling1 = aadao.finnAvdeling(1);
		Ansatt per = aadao.lagreNyAnsatt("Per_"+LocalTime.now(), avdeling1);
		
		avdeling1.skrivUtMedAnsatte();
		
		System.out.println("\n---\n");
		
		Avdeling it = aadao.lagreNyAvdeling("IT_"+LocalTime.now(), per);
		
		avdeling1.skrivUtMedAnsatte();
		it.skrivUtMedAnsatte();

	}

}
