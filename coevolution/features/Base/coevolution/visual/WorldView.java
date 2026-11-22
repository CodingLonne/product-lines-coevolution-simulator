package coevolution.visual;

import coevolution.environment.World;
import coevolution.life.Creature;
import coevolution.visual.CreatureCircle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import java.util.HashMap;
import java.util.Map;

public class WorldView extends Pane implements World.WorldListener {
	DoubleProperty centerX = new SimpleDoubleProperty();
	DoubleProperty centerY = new SimpleDoubleProperty();
	
	// tracking connections
	Map<Creature, CreatureCircle> creatureBodies = new HashMap<Creature, CreatureCircle>();
	
    public WorldView(World world) {
    	this.setBackground(new Background(new BackgroundFill(OurColors.worldOutsideColor, null, null)));
    	
    	// do shape specific configs
    	this.connectToWorld(world);
    }


    public void spawnCreature(Creature creature) {
    	//TODO give body
    }
    
	public void despawnCreature(Creature creature) {
		//TODO take body away
	}
	public double getCenterX() {
		return centerX.get();
	}
	
	public void setCenterX(double centerX) {
		this.centerX.set(centerX);
	}
	
	public DoubleProperty centerXProperty() {
		return centerX;
	}
	
	public double getCenterY() {
		return centerY.get();
	}
	
	public void setCenterY(double centerY) {
		this.centerY.set(centerY);
	}
	
	public DoubleProperty centerYProperty() {
		return centerY;
	}
}
