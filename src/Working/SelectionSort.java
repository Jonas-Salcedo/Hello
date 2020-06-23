package Working;

public class SelectionSort {
	//The method for sorting the numbers
    public static long[] selectionSort(int[] list)
    {
		//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
		long[] threeVals = {0, 0, 0};
		//Keeps track of the time when the sort began
		long st = System.nanoTime();
    	for(int i = 0; i<list.length-1;i++)
    	{
    		//Every time this program loops, a comparison has been completed
    	    threeVals[0]++;
    		//find the minimum in the list[i..list.length-1]
    		int currentMin = list[i];
    		int currentMinIndex = i;
    		//The two statements above both count as movements
    		threeVals[1]+=2;
    		
    		for(int j = i+1; j < list.length; j++)
    		{
        		//Every time this program loops, a comparison has been completed
        	    threeVals[0]++;
    			if(currentMin > list[j])
    			{
    	    	
    	    	    //DO not count the above statement as a movement.
    				currentMin = list[j];
    				currentMinIndex = j;
    	    		//The two statements above all count as movements
    	    		threeVals[1]+=2;
    			}
    			//Every time this if statement transpires, a comparison has been completed
	    	    threeVals[0]++;
    		}
    		//Swap list[i] with list[currentMinIndex] if necessary
			

    		if(currentMinIndex != i)
    		{

    			list[currentMinIndex] = list[i];
    			list[i] = currentMin;
        		//The two statements above both count as movements
        		threeVals[1]+=2;
    		}
    		//A comparison has just occured above
    		threeVals[0]+=1;
    		
    	}
    	//Keeps track of the time when the sorting ended
    	long et = System.nanoTime();
    	//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
    	threeVals[2] = et - st;
    	//Returns comparisons, movements, and total time in that order;
    	return threeVals;
    }
}
