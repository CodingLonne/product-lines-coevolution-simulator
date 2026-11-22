package coevolution.life;

import coevolution.environment.Entity;
import coevolution.environment.World;
import coevolution.life.Creature;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Perception {
    private Creature owner;
    private World world;
    private ArrayList<Creature> seenCreatures = new ArrayList<Creature>();
    private Comparator<Entity> byDistance = new Comparator<Entity>() {
        @Override
        public int compare(Entity e1, Entity e2) {
            return Double.compare(owner.distanceTo(e1), owner.distanceTo(e2));
        }
    };
    
    //constructor
    public Perception(Creature from, World inWorld) {
        this.owner = from;
        this.world = inWorld;
    }
    
    // simplify all information into desires and threats, features extend this as needed
    public List<Entity> getDesires() {
    	return new ArrayList<Entity>();
    }
    
    public List<Entity> getThreats() {
    	return new ArrayList<Entity>();
    }
    
    public Entity getClosestDesire() {
    	return getDesires().stream().sorted(byDistance).findFirst().orElse(null);
    }
    
    public Entity getClosestThreat() {
    	return getThreats().stream().sorted(byDistance).findFirst().orElse(null);
    }
    
    // creature methods
    public void addCreatures(List<Creature> creatures) {
    	this.seenCreatures.addAll(filterPerceivedCreatures(creatures.stream()).toList());
    }
    
    public Creature getClosestCreature() {
    	return seenCreatures.stream().sorted(byDistance).findFirst().orElse(null);
    }
    
    public List<Creature> getSeenCreatures() {
    	return seenCreatures;
    }
    
    //filtering
    private <T extends Entity> Stream<T> filterPerceivedAnythings(Stream<T> anythingStream) {
        return anythingStream;
    }
    
    private Stream<Creature> filterPerceivedCreatures(Stream<Creature> creatureStream) {
    	return filterPerceivedAnythings(creatureStream).filter(excludeSelf);
    }
    
    private Predicate<Creature> excludeSelf = new Predicate<Creature>() {
        @Override
        public boolean test(Creature c) {
            return c != owner;
        }
    };
    
    //getters and setters
    public Creature getOwner() {
        return owner;
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    
}