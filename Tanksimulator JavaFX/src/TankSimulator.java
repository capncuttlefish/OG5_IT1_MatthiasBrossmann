import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TankSimulator extends Application {

	public Tank myTank;

	private Label lblUeberschrift = new Label("Tank-Simulator");
	public Label lblFuellstand = new Label("     ");

	public Button btnBeenden = new Button("Beenden");
	public Button btnEinfuellen = new Button("Einfüllen");
	public Button btnVerbrauchen = new Button("Verbrauchen");

	private BorderPane pnlMain = new BorderPane();
	private FlowPane pnlNorth = new FlowPane();
	private FlowPane pnlCenter = new FlowPane();
	private ButtonBar pnlSouth = new ButtonBar();

	private MyEventHandler myEventHandler = new MyEventHandler(this);

	@Override
	public void start(Stage primaryStage) {

		// Startwert -> 0
		myTank = new Tank(0);

		// Setze Schriftart
		this.lblUeberschrift.setFont(Font.font(null, FontWeight.BOLD, 16));
		this.lblFuellstand.setFont(Font.font(null, FontWeight.NORMAL, 16));

		// Füge Elemente zu Panes
		this.pnlNorth.getChildren().addAll(this.lblUeberschrift);
		this.pnlNorth.setAlignment(Pos.CENTER);
		this.pnlNorth.setStyle("-fx-background-color:#c0c0c0");
		this.pnlCenter.getChildren().addAll(this.lblFuellstand);
		this.pnlCenter.setAlignment(Pos.CENTER);
		this.pnlCenter.setPadding(new Insets(10));
		this.pnlSouth.getButtons().addAll(this.btnEinfuellen, this.btnVerbrauchen, this.btnBeenden);
		this.pnlSouth.setPadding(new Insets(10));

		// Füge Panes hinzu
		pnlMain.setTop(pnlNorth);
		pnlMain.setCenter(pnlCenter);
		pnlMain.setBottom(pnlSouth);

		// Ereignissteuerung
		this.btnEinfuellen.setOnAction(myEventHandler);
		this.btnVerbrauchen.setOnAction(myEventHandler);
		this.btnBeenden.setOnAction(myEventHandler);

		// Lade Scene und Stage
		Scene myScene = new Scene(pnlMain);
		primaryStage.setTitle("Tank-Simulator");
		primaryStage.setScene(myScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String argv[]) {
		launch(argv);
	}
}