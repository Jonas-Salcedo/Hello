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
		
		insertionSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Insertion Sort");
		      }
		});
		
		SelectionSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Selection Sort");
		      }
		});
		
		QuickSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Quick Sort");
		      }
		});
		
		HeapSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Heap Sort");
		      }
		});
		
		MergeSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Merge Sort");
		      }
		});
		
		RadixSort.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  algorithm.setText("Radix Sort");
		      }
		});
		
		GenerateList.setOnAction(new EventHandler<ActionEvent>() {
			
		      public void handle(ActionEvent e)
		      {
		    	  //Selection Sort
		    	  if(algorithm.getText().equals("Selection Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							SelectionSort s = new SelectionSort();
							 long trival[] = s.selectionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Selection Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							SelectionSort s = new SelectionSort();
							 long trival[] = s.selectionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Selection Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							SelectionSort s = new SelectionSort();
							 long trival[] = s.selectionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Selection Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							SelectionSort s = new SelectionSort();
							 long trival[] = s.selectionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Selection Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
		    	  //Insertion Sort
		    	  else if(algorithm.getText().equals("Insertion Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							InsertionSort s = new InsertionSort();
							long trival[] = s.insertionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Insertion Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							InsertionSort s = new InsertionSort();
							long trival[] = s.insertionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Insertion Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							InsertionSort s = new InsertionSort();
							long trival[] = s.insertionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("ReverseOrder");
							 sort.setText("Insertion Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							InsertionSort s = new InsertionSort();
							long trival[] = s.insertionSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Insertion Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
		    	  //Quicksort
		    	  else if(algorithm.getText().equals("Quick Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							QuickSort s = new QuickSort();
							long trival[] = s.quickSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Quick Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							QuickSort s = new QuickSort();
							long trival[] = s.quickSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Quick Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							QuickSort s = new QuickSort();
							long trival[] = s.quickSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("ReverseOrder");
							 sort.setText("Quick Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							QuickSort s = new QuickSort(); 
							long trival[] = s.quickSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Quick Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
		    	  //Merge Sort
		    	  else if(algorithm.getText().equals("Merge Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							MergeSort s = new MergeSort();
							long trival[] = s.mergeSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Merge Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							MergeSort s = new MergeSort();
							long trival[] = s.mergeSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Merge Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							MergeSort s = new MergeSort();
							long trival[] = s.mergeSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("ReverseOrder");
							 sort.setText("Merge Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							MergeSort s = new MergeSort();
							long trival[] = s.mergeSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Merge Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
		    	  //Heap Sort
		    	  else if(algorithm.getText().equals("Heap Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							HeapSort s = new HeapSort();
							long trival[] = s.HeapSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Heap Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							HeapSort s = new HeapSort();
							long trival[] = s.HeapSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Heap Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							HeapSort s = new HeapSort();
							long trival[] = s.HeapSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("ReverseOrder");
							 sort.setText("Heap Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							HeapSort s = new HeapSort();
							long trival[] = s.HeapSort(list);
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Heap Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
		    	  //Radix Sort
		    	  else if(algorithm.getText().equals("Radix Sort"))
		    	  {
		    		  if(InOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'i');
							Radix s = new Radix();
						    long trival[] = s.radixsort(list, (int)arrSize.getValue());
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("InOrder");
							 sort.setText("Radix Sort");
							comparisons.setText(trival[0]+"");
							movements.setText(trival[1]+"");
							totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(AlmostOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'a');
							Radix s = new Radix();
							long trival[] = s.radixsort(list, (int)arrSize.getValue());
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("AlmostOrder");
							 sort.setText("Radix Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(ReverseOrder.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'r');
							Radix s = new Radix();
							long trival[] = s.radixsort(list,(int)arrSize.getValue());
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("ReverseOrder");
							 sort.setText("Radix Sort");
							comparisons.setText(trival[0]+"");
						    movements.setText(trival[1]+"");
							totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    		  else if(Random.isSelected())
		    		  {
		    			  try {
							int[] list = generateList((int)arrSize.getValue(),'d');
							Radix s = new Radix();
							 long trival[] = s.radixsort(list, (int)arrSize.getValue());
							 System.out.println();
							 printList(list);
							 System.out.println("Comparisons: " + trival[0]);
							 System.out.println("Movements: " + trival[1]);
							 System.out.println("Total Time: " + trival[2]);
							 sze2.setText(arrSize.getValue() + "");
							 datatype.setText("RandomOrder");
							 sort.setText("Radix Sort");
							 comparisons.setText(trival[0]+"");
							 movements.setText(trival[1]+"");
							 totaltime.setText(trival[2]+"");
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		  }
		    	  }
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
    	
    	Application.launch(args);
		/*int[] list = generateList(60,'i');
		printList(list);
		Radix s = new Radix();
		 long trival[] = s.radixsort(list, 60);
		 System.out.println();
		 printList(list);
		 System.out.println("Comparisons: " + trival[0]);
		 System.out.println("Movements: " + trival[1]);
		 System.out.println("Total Time: " + trival[2]);*/

		
		
    	
    }
}
