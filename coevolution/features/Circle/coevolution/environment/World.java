package coevolution.environment;

import coevolution.CentralConfig;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class World {
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
}
