package gui;

import java.util.Scanner;

import logic.IPromoCodeLogic;

public class PromocodeTUI {

	public PromocodeTUI(IPromoCodeLogic logic) {
		char wahl;
		Scanner scan = new Scanner(System.in);
		System.out.println("Promotioncodegenerator für 2-fach IT$ in einer Stunde");
		do {
			System.out.println("Möchten Sie einen (P)romotioncode generieren oder das Programm (b)eenden? (P/b)");
			wahl = scan.next().charAt(0); //Nutzereingabe registrieren
			if (wahl == 'P') //Promocode generieren und ausgeben
				System.out.println(logic.getNewPromoCode());
		} while (wahl != 'b'); //Programm wiederholen oder beenden
		scan.close();
	}
}
