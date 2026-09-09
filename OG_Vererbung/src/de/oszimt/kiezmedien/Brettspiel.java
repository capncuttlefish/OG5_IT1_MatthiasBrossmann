package de.oszimt.kiezmedien;

public class Brettspiel extends Spiel {

	private boolean spielDesJahres;

	public Brettspiel(String _titel, int _anzahlSpieler) {
		// TODO Auto-generated constructor stub
		super(_titel, _anzahlSpieler);
	}

	public double berechneSpassfaktor()
	{
		// Berechne Spa�faktor f�r Brettspiele
		return 0.0;
	}
	
	public boolean getSpielDesJahres() {
		return spielDesJahres;
	}

	public void setSpielDesJahres(boolean _spielDesJahres) {
		this.spielDesJahres = _spielDesJahres;
	}

}
