package de.oszimt.spaeti;

public class Getraenk extends Food {

	private double fuellmenge;
	private int altersfreigabe;
	
	public Getraenk(int _artikelnr, String _bezeichnung) {
		super(_artikelnr, _bezeichnung);
	}
	
	public boolean pruefeAlter(int _alter)
	{
		return (_alter >= altersfreigabe);
	}

	public int getAltersfreigabe() {
		return altersfreigabe;
	}

	public void setAltersfreigabe(int altersfreigabe) {
		this.altersfreigabe = altersfreigabe;
	}

	public double getFuellmenge() {
		return fuellmenge;
	}

	public void setFuellmenge(double fuellmenge) {
		this.fuellmenge = fuellmenge;
	}
	


}
