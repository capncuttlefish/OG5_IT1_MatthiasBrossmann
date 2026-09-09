package de.oszimt.starsim2099;

/**
 * @author Schleyer
 *
 * Datenklasse für eine Dimension (z.B. von einem Shape)
 */
public class Dimension {

	private int width;
	private int height;

	/**
	 * @param width		Breite
	 * @param height	Höhe
	 */
	public Dimension(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * @return Breite 
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return Höhe
	 */
	public int getHeight() {
		return height;
	}


}
