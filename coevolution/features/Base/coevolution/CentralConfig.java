package coevolution;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CentralConfig {
	private IntegerProperty fpsProperty = new SimpleIntegerProperty(50);
	
	public int getFps() {
		return fpsProperty.get();
	}
}
