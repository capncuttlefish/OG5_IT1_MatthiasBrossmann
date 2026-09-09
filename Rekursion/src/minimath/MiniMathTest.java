package minimath;
/** MiniMathTest.java
 *
 * Testprogramm f�r verschiedene Berechnungen.
 *
 */
import java.util.Scanner;

class MiniMathTest {

	public static void main(String arg[]) {
	
	Scanner myScanner = new Scanner(System.in);
    char operator;
    int n;
    System.out.println("Auswahl");
    System.out.println(" (Z)weierpotenz");
    System.out.println(" (F)akultaet ");
    System.out.println(" (S)umme ");
    System.out.println(" (E)xit ");
    do {
      System.out.print("Ihre Auswahl:\t");
      operator = myScanner.next().charAt(0);
      switch(operator) {
        case 'z': ;
        case 'Z':
             System.out.print("     Exponent:  ");
             n = myScanner.nextInt();
             System.out.println("\t\t2 ^ "+n+" = "+ MiniMath.berechneZweiHoch(n)+"\n");
             break;
        case 'f': ;
        case 'F':
             System.out.print("     Argument:  ");
             n = myScanner.nextInt();
             System.out.println("\t\t"+n+"! = "+ MiniMath.berechneFakultaet(n)+"\n");
             break;
        case 's': ;
        case 'S':
             System.out.print("     Argument:  ");
             n = myScanner.nextInt();
             System.out.println("\t\tSumme von 1 bis "+n+" = "+ MiniMath.berechneSumme(n)+"\n");
             break;
        case 'e': ;
        case 'E':
            System.exit(0);
      } //switch
    } while(true);
  }//main
} // MiniMathTest

