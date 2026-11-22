package coevolution.visual;

import coevolution.environment.World;
import coevolution.visual.OurColors;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class WorldView extends Pane implements World.WorldListener{
	private Circle backgroundCircle;
    private void connectToWorld(World world) {
    	this.prefWidthProperty().bind(world.radiusProperty().multiply(2*1.2));
    	this.prefHeightProperty().bind(world.radiusProperty().multiply(2*1.2));
    	centerXProperty().bind(this.prefWidthProperty().divide(2));
    	centerYProperty().bind(this.prefHeightProperty().divide(2));
    	
    	backgroundCircle = new Circle();
    	backgroundCircle.centerXProperty().bind(centerXProperty());
    	backgroundCircle.centerYProperty().bind(centerYProperty());
    	backgroundCircle.radiusProperty().bind(world.radiusProperty());
    	backgroundCircle.setFill(OurColors.worldInsideColor);
    	this.getChildren().add(backgroundCircle);
    }
}