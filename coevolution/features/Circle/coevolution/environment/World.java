package coevolution.environment;

import coevolution.CentralConfig;
import coevolution.environment.Entity;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class World {
	// for convenience 0, 0 is the center of the world
    private final DoubleProperty radiusProperty;
    public World(CentralConfig config) {
        radiusProperty = new SimpleDoubleProperty(config.getWorldSize());
    }

    public double getRadius() {
        return radiusProperty.get();
    }

    public void setRadius(double radius) {
        radiusProperty.set(radius);
    }

    public DoubleProperty radiusProperty() {
        return radiusProperty;
    }
    
    // get direction to closest edge
    public double getDirectionToEdge(Entity entity) {
    	// direction from entity to edge is same as direction from center to entity for circle shape.
        return Math.atan2(entity.getY(), entity.getX());
    }
    
    // get direction to center
    public double getDirectionToCenter(Entity entity) {
        return Math.atan2(-entity.getY(), -entity.getX());
    }
}
