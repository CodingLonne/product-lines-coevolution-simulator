package coevolution.life;

import coevolution.environment.Entity;
import coevolution.environment.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Perception {
	// Food feature
    private ArrayList<Food> seenFoods = new ArrayList<Food>();
    
    // getter, adder, filterer, get closets
    public void addFoods(List<Food> foods) {
    	this.seenFoods.addAll(filterPerceivedFoods(foods.stream()).toList());
    }
    
    private Stream<Food> filterPerceivedFoods(Stream<Food> foodStream) {
    	return filterPerceivedAnythings(foodStream);
    }
    
    private List<Food> getSeenFoods() {
    	return seenFoods;
    }
    
    private Food getClosestFood() {
    	return this.seenFoods.stream().sorted(byDistance).findFirst().orElse(null);
    }
    
    // clasify foods as desires
    public List<Entity> getDesires() {
    	List<Entity> desires = original();
    	desires.addAll(seenFoods);
    	return desires;
    }
}
