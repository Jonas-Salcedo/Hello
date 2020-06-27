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
    		//A data movement occurs for every iteration in selection sort except for the first one. 
    		
    		
    		int currentMin = list[i];
    		threeVals[1]++;
    		int currentMinIndex = i;
    		
    		
    		for(int j = i+1; j < list.length; j++)
    		{
        		
    			if(currentMin > list[j])
    			{
    	    	
    	    	    
    				currentMin = list[j];
    				currentMinIndex = j;
    				//Data movement occurs every time this occurs
    				threeVals[1]++;
    	    		
    	    		
    			}
    			//Every time this if statement transpires, a comparison has been completed
	    	    threeVals[0]++;
    		}

			

    		if(currentMinIndex != i)
    		{
    			
    			list[currentMinIndex] = list[i];
    			list[i] = currentMin;
    			//Every time this if-statement is true, 2 movements have occured.
    			threeVals[1]+=2;
        		
    		}
    		
    		
    	}
    	//Keeps track of the time when the sorting ended
    	long et = System.nanoTime();
    	//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
    	threeVals[2] = et - st;
    	//Returns comparisons, movements, and total time in that order;
    	return threeVals;
    }
}

