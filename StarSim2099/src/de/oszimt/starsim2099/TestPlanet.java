package de.oszimt.starsim2099;

public class TestPlanet {

	public static void main(String[] args) {
		double posX = (double)(Math.random() * 160);
		double posY = (double)(Math.random() * 50);
		int anzahlHafen = 3;
		String name = "Max Musterpilot";
		
		Planet meinPlanet = new Planet();
		meinPlanet.setAnzahlHafen(anzahlHafen);
		meinPlanet.setName(name);
		meinPlanet.setPosX(posX);
		meinPlanet.setPosY(posY);
		
		if (meinPlanet.getAnzahlHafen() == anzahlHafen)
			System.out.println("Implementierung 'Hafen' korrekt!");
		
		if (meinPlanet.getName().equals(name))
			System.out.println("Implementierung 'Name'  korrekt!");
		
		if (meinPlanet.getPosX() == posX)
			System.out.println("Implementierung 'Position X' korrekt!");
		
		if (meinPlanet.getPosY() == posY)
			System.out.println("Implementierung 'Position Y' korrekt!");
	}

}
