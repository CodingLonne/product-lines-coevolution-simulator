package coevolution.life;

public class Creature {
	// methods while sleeping
    private void sleep() {
    	setEnergy(getEnergy()+getWorld().getConfig().getSleepEnergyRecoveryPerTick());
    	if (getEnergy() >= getWorld().getConfig().getFullEnergy()) {
    		this.wakeUp();
    	}
    }
}
