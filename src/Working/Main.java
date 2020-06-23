package Working;
import java.util.Random;
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
	Button HeapSort = new Button("Heap Sort");
	Button RadixSort = new Button("Radix Sort");
	Button GenerateList = new Button("Generate List");
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
		g.add(HeapSort, 0, 4);
		g.add(RadixSort, 0, 5);
		g.add(GenerateList, 0, 6);
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
	
	
	
	
    //Generates a list with the number of elements and list properties specified.
	public static int[] generateList(int numElements, char type) throws InterruptedException {
		//Generates inorder list
		int[] list = new int[numElements];
		if(type == 'i')
	    {
			for(int x = 1; x<=numElements;x++)
			{
				list[x-1] = x;
			}
	    }
		//Generates reverseorder list
		else if(type == 'r')
	    {
			for(int x = 1; x<=numElements;x++)
			{
				list[numElements-x] = x;
			}
	    }
		//Generates almostorderlist
		else if(type == 'a')
		{
			//Generates inorder list
			for(int x = 1; x<=numElements;x++)
			{
				list[x-1] = x;
			}
			//Generates random number between 2 and 8
			Random ran = new Random();
			//int r = 2 + (int)(System.currentTimeMillis()%((8-2) + 1));
			int r = ran.nextInt(7) + 2;
			//Divides random number by 2 because 2 elements will be switched. a number between 4 and 1 is generated
			int counter = r/2;
			System.out.println(counter);
			for(int x = 0; x<counter; x++)
			{   
				//r = 0 + (int)(System.currentTimeMillis()%(((numElements-1)-0) + 1));
				ran = new Random();
				r = ran.nextInt(numElements) + 0;
				int s = r;
				//Makes sure s is not equal to r ever
			    while(s == r) {
			    	//s = 0 + (int)(System.currentTimeMillis()%(((numElements-1)-0) + 1));
			    	ran = new Random();
			    	s = ran.nextInt(numElements) + 0;
			    }
			    //Swaps element at s with element at r 
			    int el = list[s];
			    list[s] = list[r];
			    list[r] = el;
			}
		}
		//Generates randomorder list
		else if(type == 'd')
		{
			for(int x = 0; x<numElements; x++)
			{
				//Generates random number between 1 and n to add to the array
				//int r = 1 + (int)(System.currentTimeMillis()%(((numElements)-1) + 1));
				Random ran = new Random();
				int r = ran.nextInt(numElements) + 0;
				list[x] = r;
				//Thread.sleep((r%2)+2);
			}
		}
		return list;
	}
	


	
	
	
	//Main Method
	public static void printList(int[] list)
	{
		for(int i: list)
		{
			System.out.println(i);
			//System.out.print(",");
		}
	}
	public static void main(String args[]) throws InterruptedException
    {
    	
    	//Application.launch(args);
		
		//Testing List Methods
		int listSize = 60;
		int[] list = generateList(listSize,'r');
		//Creates objects with sorting method classes
		SelectionSort selsor = new SelectionSort();
		InsertionSort insor = new InsertionSort();
		//Print list before it is sorted
		printList(list);
		//System.out.println("\n\n\n\n");
		//Call object from sorting method.
	    //long trival[] = insor.insertionSort(list);
		long trival[] = selsor.selectionSort(list);
		//System.out.println();
		 printList(list);
		 System.out.println("Comparisons: " + trival[0]);
		 System.out.println("Movements: " + trival[1]);
		 System.out.println("Total Time: " + trival[2]);
		
		
    	
    }
}
