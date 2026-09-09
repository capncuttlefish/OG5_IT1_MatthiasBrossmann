package de.oszimt.spaeti;

public class Food extends Artikel {

	// Attribute
	private boolean kuehlung;
	private String haltbarkeit;
	
	// Konstruktor
	public Food(int _artikelnr, String _bezeichnung) {
		// Konstruktor der Oberklasse aufrufen
		super(_artikelnr, _bezeichnung);		
	}

	// Methoden
	
	public boolean ueberpruefeHaltbarkeit()
	{
		// TODO: Methode implementieren
		return true;
	}
	
	public boolean isKuehlung() {
		return kuehlung;
	}

	public void setKuehlung(boolean kuehlung) {
		this.kuehlung = kuehlung;
	}

	public String getHaltbarkeit() {
		return haltbarkeit;
	}

	public void setHaltbarkeit(String haltbarkeit) {
		this.haltbarkeit = haltbarkeit;
	}
	

}
