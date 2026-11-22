package coevolution.environment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class World {
    private final ObservableList<Food> foods = FXCollections.observableArrayList();

    public ObservableList<Food> getFoods() { return foods; }

    public void spawnFood() {
        double[] p = getRandomPosition();
        foods.add(new Food(this, p[0], p[1], 10));
    }

    public void step() {
        original();
        if (foods.size() < 50 && Math.random() < 0.1) spawnFood();
    }
}