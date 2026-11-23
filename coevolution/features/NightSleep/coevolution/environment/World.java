package coevolution.environment;

import coevolution.life.Creature;
import java.util.function.Predicate;

public class World {
	
	public void step() {
		if (isEveryCreatureAsleep()) {
			night();
			for (Creature creature : this.getCreatures()) {
				creature.wakeUp();
			}
		}
		original();
	}
    
	private boolean isEveryCreatureAsleep() {
		Predicate<Creature> isSleeping = new Predicate<Creature>() {
			@Override
			public boolean test(Creature c) {
				return c.isSleeping();
			}
		};
		return this.getCreatures().stream().allMatch(isSleeping);
	}
	
	private void night() {
		for (Creature creature : this.getCreatures()) {
			creature.resetEnergy();
		}
	}
	
	
}
