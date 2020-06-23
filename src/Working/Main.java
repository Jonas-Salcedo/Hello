package Working;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Main extends Application {
	//Declares all the buttons
	Button insertionSort = new Button("Insertion Sort");
	Button SelectionSort = new Button("Selection Sort");
	Button QuickSort = new Button("Quick Sort");
	Button MergeSort = new Button("Merge Sort");
	Button HeapRadixSort = new Button("Heap Radix Sort");
	Label winningalgorithm = new Label("Winning Algorithm");
	Label listProperties = new Label("List Properties");
	Label results = new Label("Experimental Results");
	Label n = new Label("N:");
	Label DataType = new Label("DataType:");
	Label Sort = new Label("Sort:");
	Label Comparisons = new Label("Comparisons:");
	Label Movements = new Label("Movements:");
	Label TotalTime = new Label("Total Time:");
	TextField algorithm = new TextField();
	TextField sze = new TextField();
	TextField sze2 = new TextField();
	TextField datatype = new TextField();
	TextField sort = new TextField();
	TextField comparisons = new TextField();
	TextField movements = new TextField();
	TextField totaltime = new TextField();
	RadioButton InOrder = new RadioButton("InOrder");
	RadioButton ReverseOrder = new RadioButton("ReverseOrder");
	RadioButton AlmostOrder = new RadioButton("AlmostOrder");
	RadioButton Random = new RadioButton("Random");
	

	Slider arrSize = new Slider(0,30000,0);
	
	public void start(Stage stage)
	{
		ToggleGroup sortingoptions = new ToggleGroup();
		InOrder.setToggleGroup(sortingoptions);
		ReverseOrder.setToggleGroup(sortingoptions);
		AlmostOrder.setToggleGroup(sortingoptions);
		Random.setToggleGroup(sortingoptions);
		
		
		
		
		GridPane g = new GridPane();
		g.setHgap(5);
		g.setVgap(5);
		g.add(insertionSort, 0, 0);
		g.add(SelectionSort, 0, 1);
		g.add(QuickSort, 0, 2);
		g.add(MergeSort, 0, 3);
		g.add(HeapRadixSort, 0, 4);
		g.add(winningalgorithm, 1,0);
		g.add(algorithm, 2, 0);
		g.add(listProperties, 1, 1);
		g.add(InOrder, 2, 1);
		g.add(AlmostOrder, 2, 2);
		g.add(ReverseOrder, 3, 1);
		g.add(Random , 3, 2);
		g.add(arrSize, 2, 3);
		g.add(sze, 3, 3);
		g.add(results, 1, 5);
		g.add(n, 2, 6);
		g.add(DataType, 2, 7);
		g.add(Sort, 2, 8);
		g.add(Comparisons, 2, 9);
		g.add(Movements, 2, 10);
		g.add(TotalTime, 2, 11);
	
		g.add(sze2, 3, 6);
		g.add(datatype, 3, 7);
		g.add(sort, 3, 8);
		g.add(comparisons, 3, 9);
		g.add(movements, 3, 10);
		g.add(totaltime, 3, 11);
		
		arrSize.valueProperty().addListener(ov -> sze.setText(((int)arrSize.getValue()) + ""));
		arrSize.valueProperty().addListener(ov -> System.out.println(Double.parseDouble(sze.getText())));
		sze.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				arrSize.valueProperty().setValue(Double.parseDouble(sze.getText()));
				}
				});
		
		
		Scene scene = new Scene(g, 600, 600);
		stage.setTitle("Sorting Project");
		stage.setScene(scene);
		stage.show();
	}

	
	
	public static void main(String args[])
    {
    	
    	Application.launch(args);
		
    	
    }
}
