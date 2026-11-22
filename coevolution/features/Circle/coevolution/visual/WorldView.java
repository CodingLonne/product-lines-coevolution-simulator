package coevolution.visual;

import coevolution.environment.World;
import javafx.scene.shape.Circle;

public class WorldView {
	private Circle backgroundCircle;
    private void connectToWorld(World world) {
    	backgroundCircle = new Circle();
    	backgroundCircle.centerXProperty().bind(centerXProperty());
    	backgroundCircle.centerYProperty().bind(centerYProperty());
    	backgroundCircle.radiusProperty().bind(world.radiusProperty());
    }
}
