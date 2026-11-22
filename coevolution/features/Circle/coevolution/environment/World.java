package coevolution.environment;

import coevolution.CentralConfig;
import coevolution.environment.Entity;
import coevolution.life.Creature;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class World {
	// for convenience 0, 0 is the center of the world
    private final DoubleProperty radiusProperty;
    private final CentralConfig config;
    
    public World(CentralConfig config) {
        radiusProperty = new SimpleDoubleProperty(config.getWorldSize());
    }

    // spawn n creatures equally spaced along the edge
    public void spawnCreaturesOnEdge(int n) {
    	double angleStepSize = 2 * Math.PI / n;
    	for (int i = 0; i < n; i++) {
    		double angle = angleStepSize * i;
    		double x = this.getRadius() * Math.cos(angle);
    		double y = this.getRadius() * Math.sin(angle);
    		this.spawnCreatureAt(x, y, config.getDefaultRadius(), config.getDefaultSpeed(), angle + Math.PI);
    	}
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
    
    public boolean isInWorld(Entity entity) {
    	double distanceFromCenter = entity.distanceToCoords(0, 0);
    	return distanceFromCenter < getRadius();
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
    
    public double getDistanceToEdge(Entity entity) {
    	return Math.max(0, getRadius()-entity.distanceToCoords(0, 0));
    }
    
    // get random position
    public double[] getRandomPosition() {
        double r = getRadius() * Math.sqrt(Math.random());
        double a = Math.random() * 2 * Math.PI;
        return new double[] { r * Math.cos(a), r * Math.sin(a) };
    }
}
