package coevolution.life;

import coevolution.life.MoveableEntity;
import coevolution.environment.Entity;
import coevolution.environment.World;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Creature extends MoveableEntity {
	private DoubleProperty speedProperty;
	
    public Creature(World world, double x, double y, double radius, double speed, double lookingAt) {
    	super(world, x, y, radius, lookingAt);
    	this.speedProperty = new SimpleDoubleProperty(speed);
    }
    
    public void step() {
    	// look around
    	Perception perception = getWorld().perceive(this);
    	// if threat -> run
    	Entity closestThreat = perception.getClosestThreat();
    	if (closestThreat != null) {
    		this.moveAwayFromEntity(closestThreat, getSpeed());
    		return;
    	}
    	// if desire -> walk towards
    	Entity closestDesire = perception.getClosestDesire();
    	if (closestDesire != null) {
    		this.moveToEntity(closestDesire, getSpeed());
    		return;
    	}
    	// else wander
    	if (getWorld().isInWorld(this)) {
    		this.moveForward(getSpeed());
    	} else {
    		this.moveToCenter(getSpeed());
    	}
    }
    
    public double getSpeed() {
        return speedProperty.get();
    }

    public void setSpeed(double speed) {
        speedProperty.set(speed);
    }

    public DoubleProperty speedProperty() {
        return speedProperty;
    }

}
