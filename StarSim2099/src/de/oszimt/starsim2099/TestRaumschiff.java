package de.oszimt.starsim2099;

public class TestRaumschiff {

	public static void main(String[] args) {

		double posX = (double)(Math.random() * 160);
		double posY = (double)(Math.random() * 50);
		int maxKapazitaet = 122;
		String typ = "Testflieger T2016";
		String antrieb = "Superantrieb";
		int winkel = 123;

		
		Raumschiff meinRaumschiff = new Raumschiff();
		meinRaumschiff.setTyp(typ);
		meinRaumschiff.setAntrieb(antrieb);
		meinRaumschiff.setMaxLadekapazitaet(maxKapazitaet);
		meinRaumschiff.setWinkel(winkel);
		meinRaumschiff.setPosX(posX);
		meinRaumschiff.setPosY(posY);
		
		if (meinRaumschiff.getTyp().equals(typ))
			System.out.println("Implementierung 'Typ' korrekt!");
		
		
		if (meinRaumschiff.getAntrieb().equals(antrieb))
			System.out.println("Implementierung 'Antrieb' korrekt!");
		
		if (meinRaumschiff.getMaxLadekapazitaet() == maxKapazitaet)
			System.out.println("Implementierung 'Kapazität' korrekt!");
		
		if (meinRaumschiff.getWinkel() == winkel)
			System.out.println("Implementierung 'Winkel' korrekt!");
		
		if (meinRaumschiff.getPosX() == posX)
			System.out.println("Implementierung 'Position X' korrekt!");
		
		if (meinRaumschiff.getPosY() == posY)
			System.out.println("Implementierung 'Position Y' korrekt!");

	}

}
