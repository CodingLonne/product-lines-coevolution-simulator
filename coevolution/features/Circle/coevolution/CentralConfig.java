import javafx.beans.property.SimpleDoubleProperty;

public class CentralConfig {
    private SimpleDoubleProperty worldSizeProperty;

    public CentralConfig() {
        this.worldSizeProperty = new SimpleDoubleProperty(0);
    }

    public double getWorldSize() {
        return worldSizeProperty.get();
    }

    public void setWorldSize(double worldSize) {
        worldSizeProperty.set(worldSize);
    }

    public SimpleDoubleProperty worldSizeProperty() {
        return worldSizeProperty;
    }
}
