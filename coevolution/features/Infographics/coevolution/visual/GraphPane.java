package coevolution.visual;
import coevolution.life.Creature;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import coevolution.environment.World;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import javafx.scene.control.ListCell;


public class GraphPane extends VBox{
	
	private BarChart<String, Number> barchart;
	
	private ListView<Creature> entityListView;
	
	private ObservableList<Creature> creatures;
	
	public class CreatureCellFactory implements Callback<ListView<Creature>, ListCell<Creature>> {
	    @Override
	    public ListCell<Creature> call(ListView<Creature> param) {
	        return new ListCell<Creature>(){
	            @Override
	            protected void updateItem(Creature creature, boolean empty) {
	                super.updateItem(creature, empty);
	                if (empty || creature == null) {
	                    setText(null);
	                } else {
	                    setText(String.format("Pos: [%.2f, %.2f], Speed: %.2f, Energy: %.2f", creature.getX(), creature.getY(), creature.getSpeed(), creature.getEnergy()));
	                }
	            }
	        };
	    }
	}
	
	public void update(World world) {
	    // keep list contents in sync with the world (births and deaths)
	    java.util.List<Creature> current = world.getCreatures();
	    if (!creatures.equals(current)) {
	        creatures.setAll(current);
	    }
	    // re-run updateItem on the visible cells so changed values show
	    entityListView.refresh();
	}
	
	
	public GraphPane(World world){
		
		creatures = FXCollections.observableArrayList(world.getCreatures());
		
		Button toHistogramViewButton = new Button("Histogram View");
		
		Button toGraphViewButton = new Button("Graph View");
		
		Button toEntityListButton = new Button("Entity List");
		
		HBox column = new HBox(toHistogramViewButton, toGraphViewButton, toEntityListButton);
		
		Rectangle rHist = new Rectangle(450.0, 200.0, Color.MAROON);
		
		Rectangle rGraph = new Rectangle(450.0, 200.0, Color.PINK);
		
		entityListView = new ListView<Creature>(creatures);
		entityListView.setCellFactory(new CreatureCellFactory());

		final World w = world;
		AnimationTimer timer = new AnimationTimer() {
		    private long last = 0;
		    @Override
		    public void handle(long now) {
		    	// Update list every 3 seconds
		        if (now - last > 3000000000L) {
		            last = now;
		            if (entityListView.getScene() != null) {
		                update(w);
		            }
		        }
		    }
		};
		timer.start();
		
		EventHandler<ActionEvent> colourMaroon = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				getChildren().set(getChildren().size()-1, rHist);
			}
		};
		
		toHistogramViewButton.setOnAction(colourMaroon);
		
		EventHandler<ActionEvent> colourMagenta = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				getChildren().set(getChildren().size()-1, rGraph);
			}
		};
		
		toGraphViewButton.setOnAction(colourMagenta);
		
		
		EventHandler<ActionEvent> colourBlue = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				getChildren().set(getChildren().size()-1, entityListView);
			}
		};
		
		toEntityListButton.setOnAction(colourBlue);
		
		getChildren().addAll(column, rHist);
		
		
		
		
    }
}



