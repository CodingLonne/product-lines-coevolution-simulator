package coevolution;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CentralConfig {
    private DoubleProperty sleepEnergyRecoveryPerTick;

    public CentralConfig() {
        this.sleepEnergyRecoveryPerTick = new SimpleDoubleProperty(2);
    }

    public double getSleepEnergyRecoveryPerTick() {
        return sleepEnergyRecoveryPerTick.get();
    }

    public void setSleepEnergyRecoveryPerTick(double startEnergy) {
    	sleepEnergyRecoveryPerTick.set(startEnergy);
    }

    public DoubleProperty sleepEnergyRecoveryPerTickProperty() {
        return sleepEnergyRecoveryPerTick;
    }
}
