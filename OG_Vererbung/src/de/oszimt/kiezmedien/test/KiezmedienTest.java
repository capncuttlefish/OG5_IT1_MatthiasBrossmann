package de.oszimt.kiezmedien.test;

import org.junit.Test;

import de.oszimt.kiezmedien.Brettspiel;
import de.oszimt.kiezmedien.CD;
import de.oszimt.kiezmedien.DVD;
import de.oszimt.kiezmedien.Videospiel;

public class KiezmedienTest {

	@Test
	public void testBrettspiel() {
		Brettspiel b001 = new Brettspiel("Siedler von Vertan", 4);
		b001.setSpielDesJahres(true);
		b001.setVerliehen(false);

		assert (b001.getTitel().equals("Siedler von Vertan"));
		assert (b001.getAnzahlSpieler() == 4);
		assert (b001.getSpielDesJahres());
		assert (!b001.getVerliehen());
	}

	@Test
	public void testVideospiel() {
		Videospiel c001 = new Videospiel("Pacman III - Fressen oder gefressen werden", 1);
		
		c001.setPlattform("Commodore 64");
		c001.setVerliehen(false);
		
		assert (c001.getTitel().equals("Pacman III - Fressen oder gefressen werden"));
		assert (c001.getAnzahlSpieler() == 1);
		assert (c001.getPlattform().equals("Commodore 64"));
		assert (!c001.getVerliehen());

	}

	@Test
	public void testDVD() {
		DVD dvd001 = new DVD("Krieg der Sterne");

		dvd001.setAnzahlOscars(1);
		dvd001.setVerliehen(false);
		
		assert (dvd001.getTitel().equals("Krieg der Sterne"));		
		assert (dvd001.getAnzahlOscars() == 1);
		assert (!dvd001.getVerliehen());
	}

	@Test
	public void testCD() {
		CD cd001 = new CD("Best Of Fahrstuhlmusik", "James Last und Freunde");
		
		cd001.setAnzahlTracks(14);
		cd001.setVerliehen(true);
		
		assert (cd001.getTitel().equals("Best Of Fahrstuhlmusik"));		
		assert (cd001.getArtist().equals("James Last und Freunde"));				
		assert (cd001.getAnzahlTracks() == 14);
		assert (cd001.getVerliehen());
	}

}