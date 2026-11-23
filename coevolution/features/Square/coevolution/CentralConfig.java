package coevolution;

import javafx.beans.property.SimpleDoubleProperty;

public class CentralConfig {
    // for the square this is half the side length (same scale as the circle's radius)
    private SimpleDoubleProperty worldSizeProperty = new SimpleDoubleProperty(500);

    public double getWorldSize() { return worldSizeProperty.get(); }
    public void setWorldSize(double s) { worldSizeProperty.set(s); }
    public SimpleDoubleProperty worldSizeProperty() { return worldSizeProperty; }
}