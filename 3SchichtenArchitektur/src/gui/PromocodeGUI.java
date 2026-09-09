package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.IPromoCodeLogic;

public class PromocodeGUI extends JFrame {

	private static final long serialVersionUID = 2303911575322895620L;
	private JPanel contentPane;
	private JLabel lblPromocode;

	/**
	 * Create the frame.
	 */
	public PromocodeGUI(IPromoCodeLogic logic) {
		setTitle("PromotionCodeGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblPromocode = new JLabel("");
		lblPromocode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromocode.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		contentPane.add(lblPromocode, BorderLayout.CENTER);
		
		JButton btnNewPromoCode = new JButton("Generiere neuen Promotioncode");
		btnNewPromoCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = logic.getNewPromoCode();
				lblPromocode.setText(code);
			}
		});
		contentPane.add(btnNewPromoCode, BorderLayout.SOUTH);
		
		JLabel lblBeschriftungPromocode = new JLabel("Promotioncode für 2-fach IT$ in einer Stunde");
		contentPane.add(lblBeschriftungPromocode, BorderLayout.NORTH);
		this.setVisible(true);
	}

}
