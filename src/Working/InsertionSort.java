package Working;

public class InsertionSort {
	//Returns an array containing the comparisons, movements, and total time(3 elements)
//Method for sorting the numbers
	public static long[] insertionSort(int[] list) {
		
		//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
		long[] threeVals = {0, 0, 0};
		//Time before sorting is completed
		long st = System.nanoTime();
		for(int i = 1; i<list.length; i++)
		{
			//A comparison occurs with every iteration of this loop.
			threeVals[0]++;
            int currentElement = list[i];
            // Add to number of movements on account of the movement
            // that occured above
            threeVals[1]++;
            int k;
            for(k = i - 1; k>=0 && list[k] >currentElement; k--)
            {
    			//A comparison occurs with every iteration of this loop.
    			threeVals[0]++;
            	list[k+1] = list[k];
            	// Add to number of movements on account of the movement
                // that occured above
            	threeVals[1]++;
            	
            }
            //insert the current element into list[k+1]
            list[k + 1] = currentElement;
            // Add to number of movements on account of the movement
            // that occured above
            threeVals[1]++;
		}
		//Time after the sorting is completed
		long et = System.nanoTime();
		//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
		threeVals[2] = et - st;
		//Returns comparisons, movements, and total time in that order;
		return threeVals;
	}
}
