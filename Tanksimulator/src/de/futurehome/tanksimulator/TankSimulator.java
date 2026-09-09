package de.futurehome.tanksimulator;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

@SuppressWarnings("serial")
public class TankSimulator extends Frame {
	
	public Tank myTank;
	
	private Label lblUeberschrift = new Label("Tank-Simulator");
	public  Label lblFuellstand = new Label("     ");
	
	public Button btnBeenden = new Button("Beenden");
	public Button btnEinfuellen = new Button("Einf�llen");
	public Button btnVerbrauchen = new Button("Verbrauchen");
	
	private Panel pnlNorth = new Panel();
	private Panel pnlCenter = new Panel(new FlowLayout());
	private Panel pnlSouth = new Panel(new GridLayout(1, 0));

	private MyActionListener myActionListener = new MyActionListener(this);

	public TankSimulator() {
		super("Tank-Simulator");
		
		myTank = new Tank(0);
		
		this.lblUeberschrift.setFont(new Font("", Font.BOLD, 16));
		this.pnlNorth.add(this.lblUeberschrift);
		this.pnlCenter.add(this.lblFuellstand);
		this.pnlSouth.add(this.btnEinfuellen);
		this.pnlSouth.add(this.btnVerbrauchen);
		this.pnlSouth.add(this.btnBeenden);
		this.add(this.pnlNorth, BorderLayout.NORTH);
		this.add(this.pnlCenter, BorderLayout.CENTER);
		this.add(this.pnlSouth, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
		// Ereignissteuerung
		this.btnEinfuellen.addActionListener(myActionListener);
		this.btnVerbrauchen.addActionListener(myActionListener);
		this.btnBeenden.addActionListener(myActionListener);
	}

	public static void main(String argv[]) {
		new TankSimulator();
	}
}