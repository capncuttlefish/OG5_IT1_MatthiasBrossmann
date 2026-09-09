package de.oszimt.kiezmedien;

public class CD extends Medium {

	private String artist;
	private int anzahlTracks;
	private double gesamtlaenge;
	
	public CD(String _titel, String _artist) {
		setTitel(_titel);
		this.artist = _artist;
	}

	public boolean sucheInSpotify() {
		// TODO: Steam-Suche anbinden
		return false;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getAnzahlTracks() {
		return anzahlTracks;
	}

	public void setAnzahlTracks(int anzahlTracks) {
		this.anzahlTracks = anzahlTracks;
	}

	public double getGesamtlaenge() {
		return gesamtlaenge;
	}

	public void setGesamtlaenge(double gesamtlaenge) {
		this.gesamtlaenge = gesamtlaenge;
	}

}
