package coevolution.visual;

import coevolution.environment.World;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;

public class WorldView extends Pane {
    public WorldView(World world) {
    	this.setBackground(new Background(new BackgroundFill(OurColors.worldOutsideColor, null, null)));
    	this.setPrefWidth(500);
    	this.setPrefHeight(500);
    	
    	// do shape specific configs
    	this.connectToWorld(world);
    }

    
}
