package de.oszimt.starsim2099;

public class TestPilot {

	public static void main(String[] args) {
		double posX = (double)(Math.random() * 160);
		double posY = (double)(Math.random() * 50);
		String grad = "Testpilot";
		String name = "Max Musterpilot";
		
		Pilot meinPilot = new Pilot();
		meinPilot.setGrad(grad);
		meinPilot.setName(name);
		meinPilot.setPosX(posX);
		meinPilot.setPosY(posY);
		
		if (meinPilot.getGrad().equals(grad))
			System.out.println("Implementierung 'Grad'  korrekt!");
		
		if (meinPilot.getName().equals(name))
			System.out.println("Implementierung 'Name'  korrekt!");
		
		if (meinPilot.getPosX() == posX)
			System.out.println("Implementierung 'Position X'  korrekt!");
		
		if (meinPilot.getPosY() == posY)
			System.out.println("Implementierung 'Position Y' korrekt!");
	}

}
