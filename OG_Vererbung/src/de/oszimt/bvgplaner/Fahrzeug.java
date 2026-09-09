package de.oszimt.bvgplaner;

public class Fahrzeug {

	private String interneNummer;
	private int anzahlPlaetze;
	
	public Fahrzeug(String _interneNummer) {
		this.interneNummer = _interneNummer;
	}

	public String getInterneNummer() {
		return interneNummer;
	}

	public void setInterneNummer(String interneNummer) {
		this.interneNummer = interneNummer;
	}

	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	public void setAnzahlPlaetze(int anzahlPlaetze) {
		this.anzahlPlaetze = anzahlPlaetze;
	}

}
