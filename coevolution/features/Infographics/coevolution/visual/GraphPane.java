package coevolution.visual;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;


public class GraphPane extends VBox{
	
	public GraphPane(){
		
		
		
		Button toHistogramViewButton = new Button("Histogram View");
		
		Button toGraphViewButton = new Button("Graph View");
		
		Button toEntityListButton = new Button("Entity List");
		
		HBox column = new HBox(toHistogramViewButton, toGraphViewButton, toEntityListButton);
		
		Rectangle rectangle = new Rectangle(450.0, 200.0, Color.MAROON);
		
		getChildren().addAll(column, rectangle);
		
		
    }
}



