package listengenerator;

import java.util.Scanner;

public class ListeTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("gib die zu prüfende zahl ein");
		int suche = scan.nextInt(); //scannt geprüfte zahl
		int[] gesucht = SortedListGenerator.getSortedList (laenge);
		long start = System.currentTimeMillis(); //stoppuhr start
		
	System.out.println("die zahl liegt am index " + BinarySearch.binaereSuche(gesucht, suche) );	
 
		long ende = System.currentTimeMillis(); //stoppuhr ende
		long dauer = ende - start;
		System.out.println("der algorithmus hat " + dauer + "ms gedauert");

	}
}
