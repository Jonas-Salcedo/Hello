package Working;
//Best case Comparison 2N(log(N)
//Worst case comparison 3N(log(N)

public class HeapSort{
	//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
	static long[] threeVals = {0, 0, 0};
	//Keeps track of the time when 
	static long st = System.nanoTime();
public static long[] HeapSort(int[] list) {
		 //Call to method to sort heap 
		heapSort(list);
		//Keeps track of the time when the sorting ended
	    	long et = System.nanoTime();
	    	//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
	    	threeVals[2] = et - st;
	    	//Returns comparisons, movements, and total time in that order;
	    	return threeVals;
	    }
//Method to sort	
public static void heapSort(int[] list) {
	
			
	  // Create a Heap of integers
	  Heap<Integer> heap = new Heap<Integer>();

	  // Add elements to the heap
	  for (int i = 0; i < list.length; i++)
	   heap.add(list[i]);

	  // Remove elements from the heap
	  for (int i = list.length - 1; i >= 0; i--)
	   list[i] = heap.remove();
	
	 }
     //Method to Heap Numbers
	 static class Heap<E extends Comparable<E>> {
	  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

	  /** Create a default heap */
	  public Heap() {
	  }

	  /** Create a heap from an array of objects */
	  public Heap(E[] objects) {
	   for (int i = 0; i < objects.length; i++)
	    add(objects[i]);
	  }

	  /** Add a new object into the heap */
	  public void add(E newObject) {
	   list.add(newObject); // Append to the heap
	   threeVals[1]++;
	   int currentIndex = list.size() - 1; 				// The index of the last node 
       
	   //While loop runs until there 
	   //are no more elements 
	   //then sent from add Heap elements for loop
	   while (currentIndex > 0) { 						//currentIndex = list.size()-1;
		 int parentIndex = (currentIndex - 1) / 2; 		//On first pass Parent Index is middle of heap
	    
	    
	    threeVals[0]++; //Below 'if' statement is a comparison that will happen with each while loop
	    // Swap if the current object is greater than its parent
	    if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
	     E temp = list.get(currentIndex);				//Temp receives currentIndex to become new parent
	     list.set(currentIndex, list.get(parentIndex)); //Current Index takes old parent index value
	     list.set(parentIndex, temp); 					//Parent Index is set with new value 
	     //Since current index thus become parent and the parent Index became current index
	     threeVals[1]+=2;
	    } else
	     break; 										// The tree is a heap now

	    currentIndex = parentIndex; //CurrentIndex updated each 
	    threeVals[1]++;             //while loop equals movement
	   }
	  }

	  /** Remove the root from the heap */
	  public E remove() {
	   if (list.size() == 0)
	    return null;

	   E removedObject = list.get(0);
	   list.set(0, list.get(list.size() - 1));
	   list.remove(list.size() - 1);

	   int currentIndex = 0;
	   while (currentIndex < list.size()) {
	    int leftChildIndex = 2 * currentIndex + 1;  //Positions 1,3,5,7,9...
	    int rightChildIndex = 2 * currentIndex + 2; //Positions 2,4,6,8,..
	    
	    // Find the maximum between two children
	    if (leftChildIndex >= list.size()) 		 	//Checks for end of Heap
	     break; 									//The tree is a heap
	    int maxIndex = leftChildIndex; 				//Max Index starts at position 1
	    
	    if (rightChildIndex < list.size()) { 		//Checks for end of Heap      
	    threeVals[0]++; 							//The below is comparison
	    //1st check is left child is less than right child
	     if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) { 
	      maxIndex = rightChildIndex; 				//Right child becomes max
	      threeVals[1]++;						    //One movement occurs
	     }
	    }
	    threeVals[0]++;
	    // Swap if the current node is less than the maximum
	    //On first pass position '0' checks if it is larger than position 1 and position 2
	    if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
	     E temp = list.get(maxIndex); //New current index prep
	     list.set(maxIndex, list.get(currentIndex)); //New max index
	     list.set(currentIndex, temp); //New current index
	     currentIndex = maxIndex; //Current index position updated to Max index
	     threeVals[1]+=2;       //Two movements
	    } else
	     break; // The tree is a heap
	   }

	   return removedObject;
	  }

	  /** Get the number of nodes in the tree */
	  public int getSize() {
	   return list.size();
	  }
	
		  
	  }
	  
	 }

