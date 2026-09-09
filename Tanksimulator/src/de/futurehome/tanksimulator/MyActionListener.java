package de.futurehome.tanksimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
	public TankSimulator f;

	public MyActionListener(TankSimulator f) {
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == f.btnBeenden)
			System.exit(0);

		if (obj == f.btnEinfuellen) {
			double fuellstand = f.myTank.getFuellstand();
			fuellstand = fuellstand + 5;
			f.myTank.setFuellstand(fuellstand);

			f.lblFuellstand.setText("" + fuellstand);
         
		}
			
			if (obj == f.btnVerbrauchen) {
				double fuellstand1 = f.myTank.getFuellstand();
				fuellstand1 = fuellstand1 -2;
				f.myTank.setFuellstand(fuellstand1);
				
				f.lblFuellstand.setText("" + fuellstand1);
			}
		}

	}
