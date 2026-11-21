package coevolution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("Schematic generator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
