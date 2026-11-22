package coevolution.life;

import coevolution.environment.Food;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import java.util.ArrayList;
import java.util.List;

public class Creature {
	private DoubleProperty energyProperty = new SimpleDoubleProperty(0);

	public void step() {
		original();
		eatTouchingFood();
	}

	// eat every piece of food this creature is currently overlapping
	private void eatTouchingFood() {
		// collect first, remove after: removing from a list while looping over it throws an exception
		List<Food> eaten = new ArrayList<Food>();
		for (Food food : getWorld().getFoods()) {
			if (this.touches(food)) {
				eaten.add(food);
			}
		}
		for (Food food : eaten) {
			eat(food);
		}
	}

	public void eat(Food food) {
		setEnergy(getEnergy() + food.getEnergy());
		getWorld().removeFood(food);
	}

	public double getEnergy() {
		return energyProperty.get();
	}

	public void setEnergy(double energy) {
		energyProperty.set(energy);
	}

	public DoubleProperty energyProperty() {
		return energyProperty;
	}
}
