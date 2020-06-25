package Working;
//Max number of comparisons(the number that should show up when
//sorting a reverse order list):(n*n-n)/2
//Max number of movements: 3*(n-1)
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
    		//A data movement occurs for every iteration in selection sort. 
    		
    		
    		int currentMin = list[i];
    		int currentMinIndex = i;
    		if(i >= 1) {
    		threeVals[1]++;
    		}
    		
    		
    		for(int j = i+1; j < list.length; j++)
    		{
        		
    			if(currentMin > list[j])
    			{
    	    	
    	    	    
    				currentMin = list[j];
    				
    				currentMinIndex = j;
    	    		
    	    		
    			}
    			//Every time this if statement transpires, a comparison has been completed
	    	    threeVals[0]++;
    		}
    		threeVals[1]++;
			

    		if(currentMinIndex != i)
    		{
    			
    			list[currentMinIndex] = list[i];
    			list[i] = currentMin;
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

