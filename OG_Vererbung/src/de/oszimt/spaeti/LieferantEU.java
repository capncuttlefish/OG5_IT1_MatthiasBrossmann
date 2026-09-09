package de.oszimt.spaeti;

public class LieferantEU extends Lieferant {

	private String land;
	private String ustid;

	public LieferantEU() {
		super();
	}
	
	public void meldeZollAn(int artikelnr)
	{

	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getUstid() {
		return ustid;
	}

	public void setUstid(String ustid) {
		this.ustid = ustid;
	}

}
