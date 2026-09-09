package de.oszimt.starsim2099;

import java.util.ArrayList;
import net.slashie.util.Position;

public class Universum {

	// Attribute
	private int universumBreite = 160;
	private int universumHoehe = 50;
	private ArrayList<Position> listSterne = new ArrayList<Position>();
	private char sternShape = '*';

	// Konstruktor
	/**
	 * @param width   Breite des Universums
	 * @param height  Höhe des Universums
	 */
	public Universum(int width, int height) {
		this.universumBreite = width;
		this.universumHoehe = height;

		// Generiere zufällige Sterne in einer Dichte von ca 5 Sterne pro 10x10,
		// auch über den eigentlichen "Rand" hinaus
		int starDensitySize = 5;
		for (int i = 0; i < (universumBreite / starDensitySize) * (universumHoehe / starDensitySize); i++) {
			listSterne.add(new Position((int) (Math.random() * (universumBreite + 80) - 40),
					(int) (Math.random() * (universumHoehe + 80) - 40)));
		}

	}

	// Methoden

	/**
	 * @return Breite des Universums
	 */
	public int getUniversumBreite() {
		return universumBreite;
	}

	/**
	 * @return Höhe des Universums
	 */
	public int getUniversumHoehe() {
		return universumHoehe;
	}

	/**
	 * @return die Dimension des Universums
	 */
	public Dimension getUniversumDimension() {
		return new Dimension(universumBreite, universumHoehe);
	}

	/**
	 * @return Liste der Sterne (bzw. deren Positionsangabe)
	 */
	public ArrayList<Position> getListSterne() {
		return listSterne;
	}

	/**
	 * @param sternShape the sternShape to set
	 */
	public void setSternShape(char sternShape) {
		this.sternShape = sternShape;
	}

	
	public char getSternShape() {
		return this.sternShape ;
	}

}
