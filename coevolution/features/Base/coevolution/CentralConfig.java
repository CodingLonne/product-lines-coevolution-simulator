package coevolution;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CentralConfig {
	private IntegerProperty fpsProperty = new SimpleIntegerProperty(50);
	private DoubleProperty defaultRadiusProperty = new SimpleDoubleProperty(15);
	private DoubleProperty defaultSpeedProperty = new SimpleDoubleProperty(1.4);
	
	public int getFps() {
		return fpsProperty.get();
	}

	public double getDefaultRadius() {
		return defaultRadiusProperty.get();
	}

	public void setDefaultRadius(double defaultRadius) {
		defaultRadiusProperty.set(defaultRadius);
	}

	public DoubleProperty defaultRadiusProperty() {
		return defaultRadiusProperty;
	}

	public double getDefaultSpeed() {
		return defaultSpeedProperty.get();
	}

	public void setDefaultSpeed(double defaultSpeed) {
		defaultSpeedProperty.set(defaultSpeed);
	}

	public DoubleProperty defaultSpeedProperty() {
		return defaultSpeedProperty;
	}
}
