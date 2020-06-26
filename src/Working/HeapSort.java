package Working; 
//Max number of comparisons: WorstCaste O(3Nlog(N)) Best O(2Nlog(N))

//Max number of movements: 2*(n-1) + n*(n-1)/2


public class HeapSort 
{
	static long[] threeVals = {0, 0, 0};
         //Method for sorting list
	public static long[] HeapSort(int[] list)
    {

        int size = list.length;
        //Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
      		
      	//Keeps track of the time when the sort began
      	long st = System.nanoTime();

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--) {
        	//Every time this program loops, a movement occurs for each element of list
    	    threeVals[1]++;
            heap(list, size, i);
            }

        //Extract Max from heap and replace it with the last element in the array
        for (int i=size-1; i>=0; i--) {
        	//Every time this program loops, a two movement occurs for each element of list
    	    threeVals[1]++;

            //arrA[0] is a root of the heap and is the max element in heap
            int x = list[0];
            list[0] = list[i];
            list[i] = x;

            // call maxheap on the reduced heap
            heap(list, i, 0);

        }
    	//Keeps track of the time when the sorting ended
    	long et = System.nanoTime();
    	//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
    	threeVals[2] = et - st;
    	//Returns comparisons, movements, and total time in that order;
    	return threeVals;

    }


    // Heap subtree with node i
    static void heap(int[] list, int heapSize, int i) {

        int largest = i; // Initialize largest as root
        int leftChildIdx  = 2*i + 1; // left = 2*i + 1
        int rightChildIdx  = 2*i + 2; // right = 2*i + 2
        
        //Every time is called two comparison are been completed
	    threeVals[0]++;
	    //Every time heap is called at least one movement occurs to largest
	    threeVals[1]++;
	 // If left child is larger than root
        if (leftChildIdx  < heapSize && list[leftChildIdx ] > list[largest]) 
            largest = leftChildIdx;         

        // If right child is larger than largest so far     
        if (rightChildIdx  < heapSize && list[rightChildIdx ] > list[largest])         	

            largest = rightChildIdx;      

        	// If root is not largest
            if (largest != i) {
            int swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;
            
            //every time the if statement evaluates to true two movements occur
            threeVals[1]+=2;

            // Recursive call to  heap the sub-tree
            heap(list, heapSize, largest);

        }
    }
}
