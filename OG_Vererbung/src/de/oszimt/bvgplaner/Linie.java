package de.oszimt.bvgplaner;

public class Linie {
	
	private int bezeichnung;
	private String[] linienverlauf;

	public Linie(int _bezeichnung) {
		// TODO Auto-generated constructor stub
		this.bezeichnung = _bezeichnung;
	}
	
	
	public double berechneGesamtlaenge() {
		// TODO: Methode implementieren
		return 0.0;
	}
	
	public double berechneFahrtdauer(int durchschnitssgeschwindigkeit, double dauerProHalt)
	{
		// TODO: Methode implementieren
		return 0.0;
	}
	
	
	public int getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(int bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String[] getLinienverlauf() {
		return linienverlauf;
	}

	public void setLinienverlauf(String[] linienverlauf) {
		this.linienverlauf = linienverlauf;
	}

}
