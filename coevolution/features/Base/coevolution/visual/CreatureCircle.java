package coevolution.visual;

import coevolution.life.Creature;
import coevolution.environment.World;
import coevolution.visual.OurColors;
import coevolution.visual.WorldView;
import javafx.scene.shape.Circle;

public class CreatureCircle extends Circle {
	
    public CreatureCircle(WorldView worldView, Creature creature) {
    	this.centerXProperty().bind(worldView.centerXProperty().add(creature.xProperty()));
    	this.centerYProperty().bind(worldView.centerYProperty().add(creature.yProperty()));
    	this.radiusProperty().bind(creature.radiusProperty());
    	this.setFill(OurColors.creatureColor);
    }
}
