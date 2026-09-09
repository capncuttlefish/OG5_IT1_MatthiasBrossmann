package omnom;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HaustierGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final long UPDATEDAUER = 1000; //Konstante der Spielgeschwindigkeit
	private JPanel contentPane;
	private HaustierPanel pnlHaustier;
	private Haustier tier;
	private JProgressBar pgbHunger;
	private JProgressBar pgbSchlaf;
	private JProgressBar pgbZufrieden;
	private JProgressBar pgbGesundheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Haustier omNom = new Haustier("Om Nom");
		new HaustierGUI(omNom).gameloop();
	}

	protected void gameloop() {
		//Zufallsgenerator
		Random rand = new Random();
		
		//Spielgeschwindigkeit (�nderung alle UPDATEDAUER Sek)
		long updateTime = System.currentTimeMillis() + UPDATEDAUER;//Millisekunden
		
		//GameLoop
		while (true) {
			//Schaut ob wieder x Sek vergangen sind
			if(System.currentTimeMillis() > updateTime){
				//Werte des Haustieres �ndern
				tier.setHunger(tier.getHunger()-rand.nextInt(5));
				tier.setMuede(tier.getMuede()-rand.nextInt(2));
				tier.setZufrieden(tier.getZufrieden()-rand.nextInt(3));
				if (rand.nextInt(100) == 50)
				  tier.setGesund(10);
				
				//�berpr�fen ob Werte unter Limit fallen
				if(tier.getHunger() <= 30) pnlHaustier.setHunger(false);
				if(tier.getMuede() <= 30) pnlHaustier.setMuede(false);
				if(tier.getZufrieden() <= 30) pnlHaustier.setZufrieden(false);
				if(tier.getGesund() <= 30) pnlHaustier.setGesund(false);
				
				//n�chste Updatezeit setzen
				updateTime = System.currentTimeMillis() + UPDATEDAUER;
			}	
			
			//aktuelle Werte zeichnen
			this.pgbHunger.setValue(tier.getHunger());
			this.pgbSchlaf.setValue(tier.getMuede());
			this.pgbZufrieden.setValue(tier.getZufrieden());
			this.pgbGesundheit.setValue(tier.getGesund());
			this.repaint();
		}

	}

	/**
	 * Create the frame.
	 */
	public HaustierGUI(Haustier tier) {
		setTitle(tier.getName());
		this.tier = tier;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblHunger = new JLabel("Hunger");
		lblHunger.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHunger.setBounds(10, 11, 54, 14);
		panel.add(lblHunger);

		JLabel lblSchlaf = new JLabel("Schlaf");
		lblSchlaf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSchlaf.setBounds(10, 36, 54, 14);
		panel.add(lblSchlaf);

		JLabel lblGlck = new JLabel("Zufrieden");
		lblGlck.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGlck.setBounds(10, 61, 54, 14);
		panel.add(lblGlck);

		JLabel lblGesundheit = new JLabel("Gesundheit");
		lblGesundheit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGesundheit.setBounds(0, 86, 64, 14);
		panel.add(lblGesundheit);

		pgbHunger = new JProgressBar();
		pgbHunger.setBounds(74, 11, 146, 14);
		panel.add(pgbHunger);

		pgbSchlaf = new JProgressBar();
		pgbSchlaf.setBounds(74, 36, 146, 14);
		panel.add(pgbSchlaf);

		pgbZufrieden = new JProgressBar();
		pgbZufrieden.setBounds(74, 61, 146, 14);
		panel.add(pgbZufrieden);

		pgbGesundheit = new JProgressBar();
		pgbGesundheit.setBounds(74, 86, 146, 14);
		panel.add(pgbGesundheit);

		JButton btnFuettern = new JButton("F\u00FCttern");
		btnFuettern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlHaustier.setEssen(true);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlHaustier.setEssen(false);
			}
			
		});
		btnFuettern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFuetterClick();
			}
		});
		btnFuettern.setBounds(10, 111, 89, 23);
		panel.add(btnFuettern);

		JButton btnSchlafen = new JButton("Schlafen");
		btnSchlafen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSchlafenClick();
			}
		});
		btnSchlafen.setBounds(109, 111, 89, 23);
		panel.add(btnSchlafen);

		JButton btnSpielen = new JButton("Spielen");
		btnSpielen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSpielenClick();
			}
		});
		btnSpielen.setBounds(208, 111, 89, 23);
		panel.add(btnSpielen);

		JButton btnMedizin = new JButton("Medizin");
		btnMedizin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMedizinClick();
			}
		});
		btnMedizin.setBounds(307, 111, 89, 23);
		panel.add(btnMedizin);

		pnlHaustier = new HaustierPanel();
		pnlHaustier.setBounds(263, 11, 89, 89);
		panel.add(pnlHaustier);

		setVisible(true);
	}
	
	public void btnFuetterClick(){
		pnlHaustier.setEssen(false);
		pnlHaustier.setHunger(true);
		tier.fuettern(30);
	}
	
	public void btnSchlafenClick(){
		pnlHaustier.setMuede(true);
		tier.schlafen(100);
	}
	
	public void btnSpielenClick(){
		pnlHaustier.setZufrieden(true);
		tier.spielen(20);
	}
	
	public void btnMedizinClick(){
		pnlHaustier.setGesund(true);
		tier.heilen();
	}
	
	
}
