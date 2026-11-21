package coevolution.environment;

import javafx.beans.property.SimpleDoubleProperty;

public abstract class Entity {
	private World world;
	private SimpleDoubleProperty xProperty;
    private SimpleDoubleProperty yProperty;
    private SimpleDoubleProperty radiusProperty;
    
    public Entity(World world, double x, double y, double radius) {
    	this.world = world;
    	this.xProperty = new SimpleDoubleProperty(x);
    	this.yProperty = new SimpleDoubleProperty(y);
    	this.radiusProperty = new SimpleDoubleProperty(radius);
    }

	public boolean touches(Entity other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance <= this.getRadius() + other.getRadius();
    }
    
    public double getX() {
    	return xProperty.get();
    }

    public void setX(double x) {
        xProperty.set(x);
    }

    public SimpleDoubleProperty xProperty() {
        return xProperty;
    }

    public double getY() {
        return yProperty.get();
    }

    public void setY(double y) {
        yProperty.set(y);
    }

    public SimpleDoubleProperty yProperty() {
        return yProperty;
    }

    public double getRadius() {
        return radiusProperty.get();
    }

    public void setRadius(double radius) {
        radiusProperty.set(radius);
    }

    public SimpleDoubleProperty radiusProperty() {
        return radiusProperty;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}