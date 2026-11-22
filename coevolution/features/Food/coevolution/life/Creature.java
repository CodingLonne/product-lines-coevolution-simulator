package coevolution.life;

import coevolution.environment.Food;
import coevolution.environment.World;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Creature {
	private DoubleProperty energyProperty;
	private DoubleProperty densityPerRadiusCubed;
	private int foodEatenToday = 0;
	public Creature(World world, double x, double y, double radius, double speed, double lookingAt) {
		this.energyProperty = new SimpleDoubleProperty(world.getConfig().getStartEnergy());
		this.densityPerRadiusCubed = new SimpleDoubleProperty();
		// based on volume for sphere which is (4/3)*pi*r^3
		this.densityPerRadiusCubed.bind(world.getConfig().creatureDensityProperty().multiply(1.33*Math.PI));
	}
	

	public void step() {
		eatTouchingFood();
		
		if (getEnergy() > 0) {
			original();
		}
	}
	
	public void resetEnergy() {
		setEnergy(getWorld().getConfig().getStartEnergy());
	}
	
	@Override
	public void moveInDirection(double dir, double speed) {
		super.moveInDirection(dir, speed);
		double mass = getRadius()*getRadius()*getRadius()*densityPerRadiusCubed.get();
		// derived from kinetic formula: 0.5*m*v^2
		double energySpent = 0.5*mass*getSpeed()*getSpeed();
		setEnergy(getEnergy()-energySpent);
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
