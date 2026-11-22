package coevolution.life;

import coevolution.environment.World;
import coevolution.life.Creature;
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Perception {
    private Creature owner;
    private World world;
    private List<Creature> seenCreatures;
    
    public Perception(Creature from, World inWorld, List<Creature> otherCreatures) {
        this.owner = from;
        this.world = inWorld;
        this.seenCreatures = filterPerceivedCreatures(otherCreatures.stream()).toList();
    }
    
    private Stream<Creature> filterPerceivedCreatures(Stream<Creature> creatureStream) {
    	return creatureStream.filter(excludeSelf);
    }
    
    private Predicate<Creature> excludeSelf = new Predicate<Creature>() {
        @Override
        public boolean test(Creature c) {
            return c != owner;
        }
    };

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

    public List<Creature> getSeenCreatures() {
        return seenCreatures;
    }

    public void setSeenCreatures(List<Creature> seenCreatures) {
        this.seenCreatures = seenCreatures;
    }
    
}