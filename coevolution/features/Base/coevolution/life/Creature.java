package coevolution.life;

import coevolution.life.MoveableEntity;
import coevolution.environment.World;

public class Creature extends MoveableEntity {
	
    public Creature(World world, double x, double y, double radius, double lookingAt) {
    	super(world, x, y, radius, lookingAt);
    }
    
    public void step() {
    	
    }
}
