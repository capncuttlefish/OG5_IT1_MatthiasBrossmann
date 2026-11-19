package de.promocode.logic;

import java.util.Random;

public class CodeGenerator {

	public static long[] getSortedList(int laenge, long min, long max) {
		Random rand = new Random(111111);
		long[] zahlenliste = new long[laenge];
		long naechsteZahl = min;

		for (int i = 0; i < laenge; i++) {
			naechsteZahl += rand.nextInt(3) + 1;
			zahlenliste[i] = naechsteZahl;
		}
		
		System.out.println("Letzte Zahl ist " + zahlenliste[zahlenliste.length-1]);
		return zahlenliste;
	}

}
