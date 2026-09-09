package de.oszimt.bvgplaner.test;

import org.junit.Test;

import de.oszimt.bvgplaner.Betriebsstaette;
import de.oszimt.bvgplaner.Bus;
import de.oszimt.bvgplaner.Haltepunkt;
import de.oszimt.bvgplaner.Linie;
import de.oszimt.bvgplaner.Tram;

@SuppressWarnings("unused")
public class PlanerTest {

	@Test
	public void testBus()
	{
		
		String intNummer = "OB-352";
		String kennzeichen = "B-VG-1234";
		Bus bus001 = new Bus(intNummer);
		assert (bus001.getKennzeichen().equals(intNummer));
		
		bus001.setKennzeichen("B-VG-1234");
		bus001.setAnzahlPlaetze(64);
		bus001.setLaenge(23.7);	
		
		assert (bus001.getKennzeichen().equals(kennzeichen));
		assert (bus001.getInterneNummer().equals(kennzeichen));
		assert (bus001.getLaenge() == 23.7);
		assert (bus001.getAnzahlPlaetze() == 64);
		
	}
	
	@Test
	public void testReferences() {
		Betriebsstaette b1 = new Betriebsstaette();
		b1.setBezeichnung("Busdepot Lichtenberg");
		Bus bus001 = new Bus("OB-352");
		bus001.setKennzeichen("B-VG-1234");
		
		Haltepunkt h001 = new Haltepunkt();
		h001.setBezeichnung("Ostbahnhof");
		
		Haltepunkt h002 = new Haltepunkt();
		h002.setBezeichnung("Gruenberger Str. / Warschauer Str.");
		
		Linie l001 = new Linie(240);
		
		assert b1.getBezeichnung().equals("Busdepot Lichtenberg");
	}

}
