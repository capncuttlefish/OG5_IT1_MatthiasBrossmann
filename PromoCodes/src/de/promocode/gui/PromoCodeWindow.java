package de.promocode.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import de.promocode.logic.CodeGenerator;

public class PromoCodeWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblUeberschrift = new JLabel("PromoCode 2.0");
	private JLabel lblSuche = new JLabel("Code:");
	private JLabel lblFeedback = new JLabel("");

	private NumberTextField tfdSuche = new NumberTextField();

	private JButton btnBeenden = new JButton("Beenden");
	private JButton btnSuchen = new JButton("Suchen");

	private long[] listCodes;

	private JPanel pnlMain = new JPanel(new BorderLayout());
	private JPanel pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel pnlCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
	private JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private PromoCodeHandler myEventHandler = new PromoCodeHandler(this);

	public JLabel getLblFeedback() {
		return lblFeedback;
	}

	public NumberTextField getTfdSuche() {
		return tfdSuche;
	}

	public JButton getBtnBeenden() {
		return btnBeenden;
	}

	public JButton getBtnSuchen() {
		return btnSuchen;
	}

	public long[] getListCodes() {
		return listCodes;
	}

	public PromoCodeWindow() {
		super("PromoCode 2.0");

		// Bereite Liste vor
		listCodes = CodeGenerator.getSortedList(20000000, 100000000000L, 999999999999L);

		// Setze Schriftart
		this.lblUeberschrift.setFont(this.lblUeberschrift.getFont().deriveFont(Font.BOLD, 16f));

		// Fuege Elemente zu Panels
		this.pnlNorth.add(this.lblUeberschrift);
		this.pnlNorth.setBackground(new Color(0xc0c0c0));

		this.lblFeedback.setPreferredSize(new Dimension(90, 20));
		this.pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.pnlCenter.add(this.lblSuche);
		this.pnlCenter.add(this.tfdSuche);
		this.pnlCenter.add(this.lblFeedback);

		this.pnlSouth.add(this.btnSuchen);
		this.pnlSouth.add(this.btnBeenden);
		this.pnlSouth.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		// Fuege Panels hinzu
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);

		// Ereignissteuerung
		this.btnSuchen.addActionListener(myEventHandler);
		this.btnBeenden.addActionListener(myEventHandler);

		// Lade Frame
		this.setContentPane(pnlMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] argv) {
		SwingUtilities.invokeLater(() -> new PromoCodeWindow().setVisible(true));
	}
}
