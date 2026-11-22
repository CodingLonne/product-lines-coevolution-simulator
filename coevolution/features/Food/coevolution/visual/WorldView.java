package coevolution.visual;

import coevolution.environment.Food;
import coevolution.environment.World;
import javafx.collections.ListChangeListener;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.HashMap;
import java.util.Map;
import coevolution.visual.OurColors;

public class WorldView {
    Map<Food, Circle> foodBodies = new HashMap<Food, Circle>();

    private void connectToWorld(World world) {
        original(world);
        world.getFoods().addListener(new ListChangeListener<Food>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Food> change) {
                while (change.next()) {
                    for (Food f : change.getAddedSubList()) {
                        Circle dot = new Circle();
                        dot.centerXProperty().bind(f.xProperty().add(centerXProperty()));
                        dot.centerYProperty().bind(f.yProperty().add(centerYProperty()));
                        dot.radiusProperty().bind(f.radiusProperty());
                        dot.setFill(OurColors.foodColor);
                        foodBodies.put(f, dot);
                        getChildren().add(dot);
                    }
                    for (Food f : change.getRemoved()) {
                        getChildren().remove(foodBodies.remove(f));
                    }
                }
            }
        });
    }
}