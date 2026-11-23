package coevolution.visual;

import coevolution.environment.World;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class WorldView extends Pane implements World.WorldListener{
    private Rectangle background;

    private void connectToWorld(World world) {
        this.prefWidthProperty().bind(world.halfSizeProperty().multiply(2 * 1.2));
        this.prefHeightProperty().bind(world.halfSizeProperty().multiply(2 * 1.2));
        centerXProperty().bind(prefWidthProperty().divide(2));
        centerYProperty().bind(prefHeightProperty().divide(2));
        background = new Rectangle();
        background.xProperty().bind(centerXProperty().subtract(world.halfSizeProperty()));
        background.yProperty().bind(centerYProperty().subtract(world.halfSizeProperty()));
        background.widthProperty().bind(world.halfSizeProperty().multiply(2));
        background.heightProperty().bind(world.halfSizeProperty().multiply(2));
        background.setFill(OurColors.worldInsideColor);
        getChildren().add(background);
        background.toBack();   // creatures are added before this runs, so keep the square behind them
    }
}