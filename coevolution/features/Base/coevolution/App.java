package coevolution;

import coevolution.environment.World;
import coevolution.visual.WorldView;
import coevolution.visual.utils.ZoomableScrollPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;


public class App extends Application {
	private CentralConfig config;
	private Timeline timeline;
	private World world;
	
	public static Scene makeScene(HBox hbox) {
		return new Scene(hbox);
	}

	// ---------------------------------------------------------------
	// default methods needed for javafx application
	// ---------------------------------------------------------------
	@Override
	public void start(Stage primaryStage) throws Exception {
		startup();
		// make world view and place it in scrollpane
		WorldView worldView = new WorldView(world);
		ZoomableScrollPane scrollPane = new ZoomableScrollPane(worldView);
		scrollPane.setPrefWidth(500);
		scrollPane.setPrefHeight(500);
		scrollPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		// put worldview-scrollpane, (and info screen) in Hbox
		
		HBox hbox = new HBox(scrollPane);
		Scene scene = makeScene(hbox);
		primaryStage.setTitle("Co-evolution Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
		this.timeline.play();
		timeline.play();
	}
	


	public static void main(String[] args) {
		launch(args);
	}
	
	// ---------------------------------------------------------------
	// Startup methods
	// ---------------------------------------------------------------
	
	private void startup() {
		this.config = new CentralConfig();
		this.world = new World(config);
		this.timeline = new Timeline(new KeyFrame(new Duration(1000d/this.config.getFps()), step));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        world.spawnCreaturesOnEdge(10);
	}
	
	// ---------------------------------------------------------------
	// Step methods
	// ---------------------------------------------------------------
	
	private EventHandler<ActionEvent> step = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
        	world.step();
        }
    };
}
