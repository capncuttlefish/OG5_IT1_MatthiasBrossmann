public class Tank {
	
	private double fuellstand;

	public Tank(double fuellstand) {
		this.fuellstand = fuellstand;
	}

	/**
	 * @return aktueller Füllstand
	 */
	public double getFuellstand() {
		return fuellstand;
	}

	/**
	 * @param fuellstand aktueller Füllstand
	 */
	public void setFuellstand(double fuellstand) {
		this.fuellstand = fuellstand;
	}

}
