package de.oszimt.starsim2099;

public class Main {

	public static void main(String[] args) {

		
		// GameControl erstellen
		GameControl meinGame = new GameControl();
		
		// Universum einrichten
		int universumBreite = 320;
		int universumHoehe = 100;
		Universum meinUniversum = new Universum(universumBreite, universumHoehe);
		meinGame.setUniversum(meinUniversum);
		
		// Raumschiff hinzufügen
		Raumschiff meinStarCarrier = new Raumschiff();
		meinStarCarrier.setTyp("Star-Carrier DF100");
		meinStarCarrier.setAntrieb("Sol 8");
		meinStarCarrier.setMaxLadekapazitaet(250);
		meinStarCarrier.setPosX(universumBreite / 2);
		meinStarCarrier.setPosY(universumHoehe  / 2);
		meinStarCarrier.setWinkel(180);
		meinGame.setRaumschiff(meinStarCarrier);
		
		// Pilot hinzufügen
		Pilot meinHansSolo = new Pilot();
		meinHansSolo.setName("Hans Solo");
		meinHansSolo.setGrad("Offzs. 2");
		meinHansSolo.setPosX(Math.random() * universumBreite);
		meinHansSolo.setPosY(Math.random() * universumHoehe);
		meinGame.setPilot(meinHansSolo);
		
		// Planeten hinzufügen
		Planet meineErde = new Planet();
		meineErde.setName("Erde");
		meineErde.setAnzahlHafen(2);
		meineErde.setPosX(Math.random() * universumBreite);
		meineErde.setPosY(Math.random() * universumHoehe);
		meinGame.addPlanet(meineErde);

		Planet meinCentaurus = new Planet();
		meinCentaurus.setName("Centaurus 7");
		meinCentaurus.setAnzahlHafen(1);
		meinCentaurus.setPosX(Math.random() * universumBreite);
		meinCentaurus.setPosY(Math.random() * universumHoehe);
		meinGame.addPlanet(meinCentaurus);


		//// Ladungen hinzufügen
		// Pamps (grün)
		Ladung meinePampsGruen = new Ladung();
		meinePampsGruen.setTyp("Pamps (grün)");
		meinePampsGruen.setMasse(120);
		meinePampsGruen.setPosX(Math.random() * universumBreite);
		meinePampsGruen.setPosY(Math.random() * universumHoehe);
		meinGame.addLadung(meinePampsGruen);

		// Pamps (gelb)
		Ladung meinePampsGelb = new Ladung();
		meinePampsGelb.setTyp("Pamps (gelb)");
		meinePampsGelb.setMasse(130);
		meinePampsGelb.setPosX(Math.random() * universumBreite);
		meinePampsGelb.setPosY(Math.random() * universumHoehe);
		meinGame.addLadung(meinePampsGelb);
		
		// klingonischer Werkzeugstahl
		Ladung meinStahl = new Ladung();
		meinStahl.setTyp("klingonischer Werkzeugstahl");
		meinStahl.setMasse(400);
		meinStahl.setPosX(Math.random() * universumBreite);
		meinStahl.setPosY(Math.random() * universumHoehe);
		meinGame.addLadung(meinStahl);
		
		// Borg-Schrott
		Ladung meinSchrott = new Ladung();
		meinSchrott.setTyp("Borg-Schrott");
		meinSchrott.setMasse(100);
		meinSchrott.setPosX(Math.random() * universumBreite);
		meinSchrott.setPosY(Math.random() * universumHoehe);
		meinGame.addLadung(meinSchrott);
		
		// Treibstoff
		Ladung meinTreibstoff = new Ladung();
		meinTreibstoff.setTyp("Treibstoff Nukleus 1000");
		meinTreibstoff.setMasse(50);
		meinTreibstoff.setPosX(Math.random() * universumBreite);
		meinTreibstoff.setPosY(Math.random() * universumHoehe);
		meinGame.addLadung(meinTreibstoff);
		
		// Starte Spiel
		meinGame.run();

	}

}
