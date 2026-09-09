import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MyEventHandler implements EventHandler<ActionEvent>  {

	private TankSimulator f;

	public MyEventHandler(TankSimulator f) {
		this.f = f;
	}

	@Override
	public void handle(ActionEvent e) {

		// Hole Quelle
		Object obj = e.getSource();
		
		/* Verarbeite Events
		 *  - btnBeenden
		 *  - btnEinfuellen
		 *  - ...
		 */
		if (obj == f.btnBeenden)
			Platform.exit();
		
		if (obj == f.btnEinfuellen) {
			 double fuellstand = f.myTank.getFuellstand();
			 fuellstand = fuellstand + 5;
			 f.myTank.setFuellstand(fuellstand);
			 f.lblFuellstand.setText(""+fuellstand + " l");
		}
	}

}