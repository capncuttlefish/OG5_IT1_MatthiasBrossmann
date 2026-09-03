package git_taschenrechner;

import java.util.Scanner;

public class TaschenrechnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myScanner = new Scanner(System.in);
		Taschenrechner ts = new Taschenrechner();

		int swValue;

		// Display menu graphics
		System.out.println("============================");
		System.out.println("|   MENU SELECTION DEMO    |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|        1. Addieren       |");
		System.out.println("|        2. Subtrahieren   |");
		System.out.println("|        3. Dividieren     |");
		System.out.println("|        4. Exit           |");
		System.out.println("============================");
		System.out.print(" Select option: ");
		swValue = myScanner.next().charAt(0);

		// Switch construct
		switch (swValue) {
		case '1':
			System.out.println("4 + 5 = " + ts.add(4, 5));
			break;
			
			
		  //  add your code here
		  
		  
		default:
			System.out.println("Invalid selection");
			break; // This break is not really necessary
		}

	}

}
