package listengenerator;

import java.util.Random;

public class SortedListGenerator {

	public static long[] getSortedList(int laenge){
		Random rand = new Random(111111);
		long[] zahlenliste = new long[laenge];
		long naechsteZahl = 0;
		
		for(int i = 0; i < laenge; i++){
			naechsteZahl += rand.nextInt(3)+1;
			zahlenliste[i] = naechsteZahl;
		}
		
		return zahlenliste;
	}
	
	public static void main(String[] args){
		final int ANZAHL = 20000000; //20.000.000
		
		long[] a = getSortedList(ANZAHL);
		long gesuchteZahl = a[ANZAHL-1];
		
		long time = System.currentTimeMillis();
		
		for(int i = 0; i < a.length; i++)
			if(a[i] == gesuchteZahl)
				System.out.println(i);
		
		System.out.println(System.currentTimeMillis() - time + "ms");
		
		//for(long x: a)
		//	System.out.println(x);		
		
	}
}