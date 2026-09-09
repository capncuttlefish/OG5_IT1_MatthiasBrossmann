package omnom;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class HaustierPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image[] img;
	private boolean hunger;
	private boolean muede;
	private boolean zufrieden;
	private boolean gesund;
	private boolean essen;
		
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public HaustierPanel() {
		super();
		this.hunger = true;
		this.muede = true;
		this.zufrieden = true;
		this.gesund = true;
		this.essen = false;
		
		img = new Image[10];
		try {
            // Bild einlesen
            img[0] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/normal.png"));
            img[1] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/normal2.png"));
            img[2] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/normal3.png"));
            img[3] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/krank.png"));
            img[4] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/hungrig.png"));
            img[5] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/traurig.png"));
            img[6] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/muede.png"));
            img[7] = ImageIO.read(HaustierPanel.class.getResourceAsStream("/bilder/isst.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setHunger(boolean hunger) {
		this.hunger = hunger;
	}

	public void setMuede(boolean muede) {
		this.muede = muede;
	}

	public void setZufrieden(boolean zufrieden) {
		this.zufrieden = zufrieden;
	}

	public void setGesund(boolean gesund) {
		this.gesund = gesund;
	}
	
	public void setEssen(boolean essen){
		this.essen = essen;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(essen)
			g.drawImage(img[7], 1, 1, 89, 89, null);
		else if(hunger && muede && zufrieden && gesund){
			int bild = (int)(System.currentTimeMillis() / 5000 % 3);
		    g.drawImage(img[bild], 1, 1, 89, 89, null);
		}else if(!gesund){
			g.drawImage(img[3], 1, 1, 89, 89, null);
		}else if(!hunger){
			g.drawImage(img[4], 1, 1, 89, 89, null);
		}else if(!zufrieden){
			g.drawImage(img[5], 1, 1, 89, 89, null);
		}else if(!muede){
			g.drawImage(img[6], 1, 1, 89, 89, null);
		}else{
			g.drawImage(img[0], 1, 1, 89, 89, null);
		}
		
	}

}
