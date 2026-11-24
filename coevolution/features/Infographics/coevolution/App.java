import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import coevolution.visual.GraphPane;
import javafx.scene.shape.Circle;

public class App extends Application{
	public static HBox makeWorld(World world) {
		HBox hbox = original(world);
		GraphPane graph = new GraphPane(world);
		hbox.getChildren().add(graph);
		return hbox;
	}
}