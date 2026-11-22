package coevolution.visual;

import coevolution.environment.World;
import coevolution.life.Creature;
import coevolution.visual.CreatureCircle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import java.util.HashMap;
import java.util.Map;

public class WorldView extends Pane implements World.WorldListener {
	private DoubleProperty centerX = new SimpleDoubleProperty();
	private DoubleProperty centerY = new SimpleDoubleProperty();
	
	// tracking connections
	Map<Creature, CreatureCircle> creatureBodies = new HashMap<Creature, CreatureCircle>();
	
    public WorldView(World world) {
    	world.addListener(this);
    	this.setBackground(new Background(new BackgroundFill(OurColors.worldOutsideColor, null, null)));
    	for (Creature creature : world.getCreatures()) {
    		this.spawnCreature(creature);
    	}
    	// do shape specific configs
    	this.connectToWorld(world);
    }


    public void spawnCreature(Creature creature) {
    	CreatureCircle body = new CreatureCircle(this, creature);
    	creatureBodies.put(creature, body);
    	this.getChildren().add(body);
    }
    
	public void despawnCreature(Creature creature) {
		CreatureCircle body = creatureBodies.get(creature);
    	creatureBodies.remove(creature);
    	this.getChildren().remove(body);
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
