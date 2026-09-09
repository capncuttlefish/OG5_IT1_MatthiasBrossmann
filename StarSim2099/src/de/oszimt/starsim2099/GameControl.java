package de.oszimt.starsim2099;

import java.util.ArrayList;
import java.util.Properties;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.util.Position;

public class GameControl {

	private static int screenWidth = 80;
	private static int screenHeight = 25;

	private int score = 0;

	private ArrayList<Planet> listPlaneten = new ArrayList<Planet>();
	private ArrayList<Ladung> listLadungen = new ArrayList<Ladung>();

	private Universum universum;
	private Pilot pilot;
	private Raumschiff raumschiff;

	private ConsoleSystemInterface meineConsole;

	private static final CSIColor BORDER_COLOR = new CSIColor(128, 0, 0, 128);
	private static final CSIColor SHIP_COLOR = CSIColor.GREEN;
	private static final CSIColor STAR_COLOR = CSIColor.FIREBRICK;
	private static final CSIColor PLANET_COLOR = CSIColor.BLUE;
	private static final CSIColor FREIGHT_COLOR = CSIColor.BROWNER;

	public GameControl() {
		Properties text = new Properties();
		text.setProperty("fontSize", "20");
		text.setProperty("font", "Consolas");
		meineConsole = new WSwingConsoleInterface("StarSim 2099", text);
	}

	/**
	 * @return the universe
	 */
	public Universum getUniversum() {
		return universum;
	}

	/**
	 * @param meinUniversum
	 *            the universum to set
	 */
	public void setUniversum(Universum meinUniversum) {
		this.universum = meinUniversum;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot meinPilot) {
		this.pilot = meinPilot;
	}

	public Raumschiff getRaumschiff() {
		return raumschiff;
	}

	public void setRaumschiff(Raumschiff meinRaumschiff) {
		this.raumschiff = meinRaumschiff;
	}

	public void addLadung(Ladung meineLadung) {
		if (!listLadungen.contains(meineLadung)) {
			listLadungen.add(meineLadung);
		}
	}

	public void removeLadung(Ladung meineLadung) {
		if (listLadungen.contains(meineLadung)) {
			listLadungen.remove(meineLadung);
		}
	}

	public void addPlanet(Planet meinPlanet) {
		if (!listPlaneten.contains(meinPlanet)) {
			listPlaneten.add(meinPlanet);
		}
	}

	public void removePlanet(Planet meinPlanet) {
		if (listPlaneten.contains(meinPlanet)) {
			listPlaneten.remove(meinPlanet);
		}
	}

	private void drawFrame() {
		for (int y = 0; y < screenHeight; y++) {
			if (y == 0 || y == screenHeight - 3 || y == screenHeight - 1) {
				for (int x = 0; x < screenWidth; x++) {
					meineConsole.print(x, y, '-', BORDER_COLOR);
				}
			} else {
				meineConsole.print(0, y, '|', BORDER_COLOR);
				meineConsole.print(screenWidth - 1, y, '|', BORDER_COLOR);
			}
		}
		meineConsole.print(2, screenHeight - 2, "Punkte: ", CSIColor.GRAY);
		meineConsole.print(39, screenHeight - 2, "Winkel: -360°", CSIColor.GRAY);
		meineConsole.print(53, screenHeight - 2, "Position: [      |      ]", CSIColor.GRAY);
	}

	private void drawStatus() {
		int linePosY = screenHeight - 2;
		meineConsole.print(10, linePosY, String.format("%04d", score), CSIColor.WHITE);
		meineConsole.print(47, linePosY, String.format("% 4d", raumschiff.getWinkel()), CSIColor.WHITE);
		meineConsole.print(65, linePosY, String.format("%04.0f", raumschiff.getPosX()), CSIColor.WHITE);
		meineConsole.print(72, linePosY, String.format("%04.0f", raumschiff.getPosY()), CSIColor.WHITE);

	}

	private void drawShip() {
		int centerX = 40;
		int centerY = 12;
		char[][] shipShape = Raumschiff.getDarstellung();
		drawShape(shipShape, SHIP_COLOR, new Position(centerX, centerY));
	}

	private void drawShape(char[][] shape, CSIColor color, Position center) {
		Dimension shapeSize = getShapeSize(shape);
		int offsetX = (int) Math.floor(shapeSize.getWidth() * 0.5);
		int offsetY = (int) Math.floor(shapeSize.getHeight() * 0.5);
		int coordX;
		int coordY;
		for (int y = 0; y < shapeSize.getHeight(); y++) {
			coordY = y + center.y - offsetY;
			if (coordY < 1 || coordY > screenHeight - 4)
				continue;
			char[] curRow = shape[y];
			for (int x = 0; x < curRow.length; x++) {
				coordX = x + center.x - offsetX;
				if (coordX < 1 || coordX > screenWidth - 2)
					continue;
				if (curRow[x] != '\0')
					meineConsole.print(coordX, coordY, curRow[x], color);
			}
		}

	}

	private Dimension getShapeSize(char[][] shape) {
		int height = shape.length;
		int width = -1;
		for (char[] curRow : shape) {
			width = Math.max(curRow.length, width);
		}
		return new Dimension(width, height);
	}

	private void drawStars() {
		for (Position stern : universum.getListSterne()) {
			Position transformedPos = transformPos(stern);
			if (transformedPos.x >= 1 && transformedPos.y >= 1 && transformedPos.x <= 78 && transformedPos.y <= 22) {
				meineConsole.print(transformedPos.x, transformedPos.y, universum.getSternShape(), STAR_COLOR);
			}
		}
	}

	private double degToRad(int angle) {
		return (angle / 180.0) * Math.PI;
	}

	private Position transformPos(Position pos) {
		int newX = (int) ((pos.x - raumschiff.getPosX()) * Math.cos(degToRad(raumschiff.getWinkel()))
				- (pos.y - raumschiff.getPosY()) * Math.sin(degToRad(raumschiff.getWinkel())) + raumschiff.getPosX()
				+ 0.5);
		int newY = (int) ((pos.y - raumschiff.getPosY()) * Math.cos(degToRad(raumschiff.getWinkel()))
				+ (pos.x - raumschiff.getPosX()) * Math.sin(degToRad(raumschiff.getWinkel())) + raumschiff.getPosY()
				+ 0.5);
		return new Position(39 + newX - (int) raumschiff.getPosX(), 11 + newY - (int) raumschiff.getPosY());
	}

	/*
	 * private boolean isSichtbar(int x, int y) { return (raumschiff.getPosX() -
	 * 39 <= x && x <= raumschiff.getPosX() + 39) && (raumschiff.getPosY() - 10
	 * <= y && y <= raumschiff.getPosY() + 10); }
	 */

	private void drawPlanet(Planet planet) {
		int centerX = (int) planet.getPosX();
		int centerY = (int) planet.getPosY();
		Position transformedPos = transformPos(new Position(centerX, centerY));
		char[][] planetShape = Planet.getDarstellung();
		drawShape(planetShape, PLANET_COLOR, transformedPos);
	}

	private void drawLadung(Ladung ladung) {
		int centerX = (int) ladung.getPosX();
		int centerY = (int) ladung.getPosY();
		char[][] ladungShape = Ladung.getDarstellung();
		Position transformedPos = transformPos(new Position(centerX, centerY));
		drawShape(ladungShape, FREIGHT_COLOR, transformedPos);
	}

	private void drawUniverse() {
		meineConsole.cls();
		meineConsole.saveBuffer();
		drawFrame();
		drawStars();
		// Male alle Planeten
		for (Planet planet : listPlaneten) {
			drawPlanet(planet);
		}
		// Male alle Ladungen
		for (Ladung ladung : listLadungen) {
			drawLadung(ladung);
		}
		// Male Raumschiff - immer in der Mitte
		drawShip();
		// Male Infos
		drawStatus();

		// Male Pilot
		// meinPilot.getPosX()
		meineConsole.refresh();
	}

	public void run() {
		meineConsole.cls();
		meineConsole.print(26, 5, "Willkommen bei StarSim 2099!", CSIColor.AMBER);
		meineConsole.saveBuffer();
		meineConsole.print(24, 20, "Drücken Sie LEERTASTE zum Start!");
		meineConsole.refresh();
		meineConsole.waitKey(CharKey.SPACE);

		CharKey keyPressed = null;
		do {
			drawUniverse();
			keyPressed = meineConsole.inkey();
			switch (keyPressed.code) {

			case CharKey.UARROW:
				int newX = Math
						.max(Math.min((int) (raumschiff.getPosX() - 2 * Math.sin(degToRad(raumschiff.getWinkel()))),
								universum.getUniversumBreite()), 0);
				int newY = Math
						.max(Math.min((int) (raumschiff.getPosY() - 2 * Math.cos(degToRad(raumschiff.getWinkel()))),
								universum.getUniversumHoehe()), 0);
				raumschiff.setPosX(newX);
				raumschiff.setPosY(newY);
				break;
			case CharKey.LARROW:
				raumschiff.setWinkel(raumschiff.getWinkel() + 5);
				break;
			case CharKey.RARROW:
				raumschiff.setWinkel(raumschiff.getWinkel() - 5);
				break;
			default:
			}
		} while (keyPressed.code != CharKey.ESC);
		System.exit(0);

	}

}
