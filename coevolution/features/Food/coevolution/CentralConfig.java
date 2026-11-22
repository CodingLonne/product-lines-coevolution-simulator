import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CentralConfig {
    private DoubleProperty startEnergyProperty;
    private DoubleProperty creatureDensityProperty;
    private IntegerProperty foodEnergyValueProperty;
    private IntegerProperty foodRequiredForSurvivalProperty;
    private IntegerProperty foodRequiredPerReproductionProperty;

    public CentralConfig() {
        this.startEnergyProperty = new SimpleDoubleProperty(2000);
        this.creatureDensityProperty = new SimpleDoubleProperty(0.0001);
        this.foodEnergyValueProperty = new SimpleIntegerProperty(200);
        this.foodRequiredForSurvivalProperty = new SimpleIntegerProperty(1);
        this.foodRequiredPerReproductionProperty = new SimpleIntegerProperty(1);
    }

    public double getStartEnergy() {
        return startEnergyProperty.get();
    }

    public void setStartEnergy(double startEnergy) {
        startEnergyProperty.set(startEnergy);
    }

    public DoubleProperty startEnergyProperty() {
        return startEnergyProperty;
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
}
