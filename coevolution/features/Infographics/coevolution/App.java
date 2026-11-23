import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import coevolution.visual.GraphPane;
import javafx.scene.shape.Circle;

public class App extends Application{
	public static Scene makeScene(HBox hbox) {
		GraphPane graph = new GraphPane();
		hbox.getChildren().add(graph);
		return original(hbox);
	}
}