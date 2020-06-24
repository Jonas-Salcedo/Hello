package Working;

import java.util.Arrays;

public class Radix {


public static long[] Radix(int[] list) {
	//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
	long[] threeVals = {0, 0, 0};
	//Keeps track of the time when the sort began
	long st = System.nanoTime();
	// Find the maximum number to know number of digits
		int mx = list[0];
	    for (int i = 1; i < list.length-1; i++) {
	    
	       if (list[i] > mx) 
	               mx = list[i];
	     //Every time the if statement is evaluated to true a movement has been completed
   	     	    threeVals[1]++;
	    }
	    for (int exp = 1; mx/exp > 0; exp *= 10) {
	    	int output[] = new int[list.length-1];
	    	int i1;
	    	int count[] = new int[60];
	    	Arrays.fill(count,0);
	    	for (i1 = 0; i1 < list.length-1; i1++) 
	    		count[ (list[i1]/exp)%10 ]++;
	    	    //counts as movement
	    		threeVals[1]++;
	    	// Change count[i] so that count[i] now contains
	    	// actual position of this digit in output[]
	    	for (i1 = 1; i1 < 10; i1++)
	    		count[i1] += count[i1 - 1];
	    	//counts as movement
    		threeVals[1]++;
	    	// Build the output array
	    	for (i1 = list.length-1; i1 >= 0; i1--) {
	    		output[count[ (list[i1]/exp)%10 ] - 1] = list[i1];
	    			count[ (list[i1]/exp)%10 ]--;
	    			//Every time this program loops, two movements have been completed
		   	    	threeVals[1]+=2;}
	    
	    	  for (i1 = 0; i1 < list.length-1; i1++) 
	    		  list[i1] = output[i1];
	    	  //Every time this program loops, a movement has been completed
	    	   	    threeVals[1]++;
	    		
	    		//Keeps track of the time when the sorting ended
	    		long et = System.nanoTime();
	    		//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
	    		threeVals[2] = et - st;
	    		//Returns comparisons, movements, and total time in that order;
	    		return threeVals;
	    	
	    }
		return threeVals;
	
	}
}

