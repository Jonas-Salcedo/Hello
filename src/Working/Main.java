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
public class Main extends Application {
	
	Button insertionSort = new Button("Insertion Sort");
	Button SelectionSort = new Button("Selection Sort");
	Button QuickSort = new Button("Quick Sort");
	Button MergeSort = new Button("Merge Sort");
	Button HeapRadixSort = new Button("Heap Radix Sort");
	public void start(Stage stage)
	{
		GridPane g = new GridPane();
		g.setHgap(5);
		g.setVgap(5);
		g.add(insertionSort, 0, 0);
		g.add(SelectionSort, 0, 1);
		g.add(QuickSort, 0, 2);
		g.add(MergeSort, 0, 3);
		g.add(HeapRadixSort, 0, 4);
		
		
		Scene scene = new Scene(g, 450, 250);
		stage.setTitle("Sorting Project");
		stage.setScene(scene);
		stage.show();
	}

	
	
	public static void main(String args[])
    {
    	
    	Application.launch(args);
    	
    }
}
