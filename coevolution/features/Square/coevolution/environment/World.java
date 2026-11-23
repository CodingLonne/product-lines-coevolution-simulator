package coevolution.environment;

import coevolution.CentralConfig;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class World {
    // 0,0 is the center; halfSize = distance from the center to each side
    private final DoubleProperty halfSizeProperty;
    private final CentralConfig config;

    public World(CentralConfig config) {
        halfSizeProperty = new SimpleDoubleProperty(config.getWorldSize());
    }

    public double getHalfSize() { return halfSizeProperty.get(); }
    public void setHalfSize(double h) { halfSizeProperty.set(h); }
    public DoubleProperty halfSizeProperty() { return halfSizeProperty; }

    // spawn n creatures equally spaced along the perimeter, facing inward
    public void spawnCreaturesOnEdge(int n) {
        double h = getHalfSize();
        double sideLength = 2 * h;
        double step = 4 * sideLength / n;
        for (int i = 0; i < n; i++) {
            double d = (i + 0.5) * step;            
            int side = (int) (d / sideLength) % 4;  
            double t = d % sideLength;              
            double x, y, facing;
            switch (side) {
                case 0:  x = -h + t; y = -h;     facing = Math.PI / 2;  break; // top
                case 1:  x = h;      y = -h + t; facing = Math.PI;      break; // right
                case 2:  x = h - t;  y = h;      facing = -Math.PI / 2; break; // bottom
                default: x = -h;     y = h - t;  facing = 0;            break; // left
            }
            spawnCreatureAt(x, y, config.getDefaultRadius(),config.getDefaultSpeed(), facing);
        }
    }

    // direction to the closest side
    public double getDirectionToEdge(Entity entity) {
        double gapX = getHalfSize() - Math.abs(entity.getX());
        double gapY = getHalfSize() - Math.abs(entity.getY());
        if (gapX <= gapY) return entity.getX() >= 0 ? 0 : Math.PI;
        return entity.getY() >= 0 ? Math.PI / 2 : -Math.PI / 2;
    }

    public double getDirectionToCenter(Entity entity) {
        return Math.atan2(-entity.getY(), -entity.getX());
    }
    
    public double getDistanceToEdge(Entity entity) {
        return Math.min(getHalfSize() - Math.abs(entity.getX()),
                        getHalfSize() - Math.abs(entity.getY()));
    }
    public boolean isInWorld(Entity entity) {
    	boolean xOk = Math.abs(entity.getX()) <= this.getHalfSize();
    	boolean yOk = Math.abs(entity.getY()) <= this.getHalfSize();
    	return xOk && yOk;
    }

    // used by Food
    public double[] getRandomPosition() {
        double h = getHalfSize();
        return new double[] { (Math.random() * 2 - 1) * h, (Math.random() * 2 - 1) * h };
    }
}