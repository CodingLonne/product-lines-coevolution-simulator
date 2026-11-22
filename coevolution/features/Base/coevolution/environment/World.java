package coevolution.environment;

import coevolution.CentralConfig;
import coevolution.life.Creature;
import java.util.ArrayList;
import java.util.List;

public class World {
	public interface WorldListener {
		void spawnCreature(Creature creature);
		void despawnCreature(Creature creature);
	}
	
	
	private CentralConfig config;
	private List<Creature> creatures = new ArrayList<Creature>();
	
	private List<WorldListener> listeners = new ArrayList<WorldListener>();
	
	public World(CentralConfig config) {
		this.config = config;
		
	}
	
	public void step() {
		for (Creature creature : creatures) {
			creature.step();
		}
	}
	
	public void spawnCreatureAt(double x, double y, double radius, double speed, double lookingAt) {
		Creature creature = new Creature(this, x, y, radius, speed, lookingAt);
		creatures.add(creature);
		for (WorldListener listener : listeners) {
			listener.spawnCreature(creature);
		}
	}
	
	public void despawnCreature(Creature creature) {
		creatures.remove(creature);
		for (WorldListener listener : listeners) {
			listener.despawnCreature(creature);
		}
	}
	
	public List<Creature> getCreatures() {
		return creatures;
	}
	
	public boolean isInWorld(Entity entity) {
    	throw new NotImplementedException("Feature Worldshape is circle or square should be enabled");
    }
    
    public double getDirectionToEdge(Entity entity) {
    	throw new NotImplementedException("Feature Worldshape is circle or square should be enabled");
    }
    
    public double getDirectionToCenter(Entity entity) {
    	throw new NotImplementedException("Feature Worldshape is circle or square should be enabled");
    }
	
	//listener handler
	public void addListener(WorldListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(WorldListener listener) {
		listeners.remove(listener);
	}
	
}
