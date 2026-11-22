package coevolution.life;

import coevolution.life.MoveableEntity;
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
