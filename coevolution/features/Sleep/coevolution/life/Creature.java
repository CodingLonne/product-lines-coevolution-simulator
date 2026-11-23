package coevolution.life;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class Creature {
    BooleanProperty isSleeping = new SimpleBooleanProperty(false);
    
    // falling asleep and waking up
    public void fallAsleep() {
    	isSleeping.set(true);
    }
    
    public void wakeUp() {
    	isSleeping.set(false);
    }
    
    private boolean isSafeSleepPlace() {
    	// the edge is a safe place to sleep
    	return !getWorld().isInWorld(this);
    }
    
    // methods while sleeping
    private void sleep() {
    }
    
    // sleep related getters/properties
    public boolean isSleeping() {
    	return isSleeping.get();
    }
    
    public ReadOnlyBooleanProperty isSleepingProperty() {
    	return isSleeping;
    }
}
