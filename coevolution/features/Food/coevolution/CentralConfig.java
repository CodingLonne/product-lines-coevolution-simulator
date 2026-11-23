import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CentralConfig {
    private DoubleProperty fullEnergyProperty;
    private DoubleProperty creatureDensityProperty;
    private IntegerProperty foodEnergyValueProperty;
    private IntegerProperty foodRequiredForSurvivalProperty;
    private IntegerProperty foodRequiredPerReproductionProperty;
    private DoubleProperty foodSpawnChancePerTickProperty;
    private IntegerProperty maxFoodSpawnedProperty;

    public CentralConfig() {
        this.fullEnergyProperty = new SimpleDoubleProperty(2000);
        this.creatureDensityProperty = new SimpleDoubleProperty(0.0001);
        this.foodEnergyValueProperty = new SimpleIntegerProperty(100);
        this.foodRequiredForSurvivalProperty = new SimpleIntegerProperty(1);
        this.foodRequiredPerReproductionProperty = new SimpleIntegerProperty(1);
        this.foodSpawnChancePerTickProperty = new SimpleDoubleProperty(0.02);
        this.maxFoodSpawnedProperty = new SimpleIntegerProperty(50);
    }

    public double getFullEnergy() {
        return fullEnergyProperty.get();
    }

    public void setFullEnergy(double startEnergy) {
    	fullEnergyProperty.set(startEnergy);
    }

    public DoubleProperty fullEnergyProperty() {
        return fullEnergyProperty;
    }

    public double getCreatureDensity() {
        return creatureDensityProperty.get();
    }

    public void setCreatureDensity(double creatureDensity) {
        creatureDensityProperty.set(creatureDensity);
    }

    public DoubleProperty creatureDensityProperty() {
        return creatureDensityProperty;
    }

    public int getFoodEnergyValue() {
        return foodEnergyValueProperty.get();
    }

    public void setFoodEnergyValue(int foodEnergyValue) {
        foodEnergyValueProperty.set(foodEnergyValue);
    }

    public IntegerProperty foodEnergyValueProperty() {
        return foodEnergyValueProperty;
    }
    
    public int getFoodRequiredForSurvival() {
        return foodRequiredForSurvivalProperty.get();
    }

    public void setFoodRequiredForSurvival(int foodRequiredForSurvival) {
        foodRequiredForSurvivalProperty.set(foodRequiredForSurvival);
    }

    public IntegerProperty foodRequiredForSurvivalProperty() {
        return foodRequiredForSurvivalProperty;
    }

    public int getFoodRequiredPerReproduction() {
        return foodRequiredPerReproductionProperty.get();
    }

    public void setFoodRequiredPerReproduction(int foodRequiredPerReproduction) {
        foodRequiredPerReproductionProperty.set(foodRequiredPerReproduction);
    }

    public IntegerProperty foodRequiredPerReproductionProperty() {
        return foodRequiredPerReproductionProperty;
    }

    public double getFoodSpawnChancePerTick() {
        return foodSpawnChancePerTickProperty.get();
    }

    public void setFoodSpawnChancePerTick(double foodSpawnChancePerTick) {
        foodSpawnChancePerTickProperty.set(foodSpawnChancePerTick);
    }

    public DoubleProperty foodSpawnChancePerTickProperty() {
        return foodSpawnChancePerTickProperty;
    }

    public int getMaxFoodSpawned() {
        return maxFoodSpawnedProperty.get();
    }

    public void setMaxFoodSpawned(int maxFoodSpawned) {
        maxFoodSpawnedProperty.set(maxFoodSpawned);
    }

    public IntegerProperty maxFoodSpawnedProperty() {
        return maxFoodSpawnedProperty;
    }
}
