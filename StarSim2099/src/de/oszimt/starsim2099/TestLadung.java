package de.oszimt.starsim2099;

public class TestLadung {

	public static void main(String[] args) {

		double posX = (double)(Math.random() * 160);
		double posY = (double)(Math.random() * 50);
		int masse = 122;
		String typ = "Test-Ladung (gepunktet)";
		
		Ladung meineLadung = new Ladung();
		meineLadung.setTyp(typ);
		meineLadung.setMasse(masse);
		meineLadung.setPosX(posX);
		meineLadung.setPosY(posY);
		
		if (meineLadung.getTyp().equals(typ))
			System.out.println("Implementierung 'Typ'  korrekt!");
		
		if (meineLadung.getMasse() == masse)
			System.out.println("Implementierung 'Masse'  korrekt!");
		
		if (meineLadung.getPosX() == posX)
			System.out.println("Implementierung 'Position X' korrekt!");
		
		if (meineLadung.getPosY() == posY)
			System.out.println("Implementierung 'Position Y' korrekt!");

	}

}
