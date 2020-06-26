package Working;

public class MergeSort {

	public static long[] mergeSort(int[] list){
		
		//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
		long[] threeVals = {0, 0, 0};
		//Time before sorting is completed
		long st = System.nanoTime();

		//temporary class to hold info from recursions
		long [] tempor = {0,0,0};

		//long to hold comparisons
		long comp = 0;

		if(list.length>1){

 			//merge sort first half
 			int[] firstHalf = new int[list.length / 2];
 			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
 			tempor= mergeSort(firstHalf);
 			//add amount of previous comparisons to threeVals
  			threeVals[0] = threeVals[0]+tempor[0];			


 			//merge sort the second half
 			int secondHalfLength = list.length - list.length / 2;
 			int[] secondHalf = new int[secondHalfLength];
 			System.arraycopy(list, list.length / 2,
 				secondHalf, 0, secondHalfLength);
 			tempor= mergeSort(secondHalf);
 			//add amount of previous comparisons to threeVals
  			threeVals[0] = threeVals[0]+tempor[0]; 			

 			//merge firstHalf with secondHalf into list
 			comp =merge(firstHalf, secondHalf, list);
 			//add comparisons from the merge to threeVals
 			threeVals[0] = threeVals[0]+comp;
 		}

		//Time after the sorting is completed
		long et = System.nanoTime();
		//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
		threeVals[2] = et - st;
		//Returns comparisons, movements, and total time in that order;
		return threeVals;

	}

	/**Merge two sorted lists **/
	public static long merge(int[] list1, int[] list2, int[] temp){
		int current1 = 0; //current index in list1
		int current2 = 0; //current index in list2
		int current3 = 0; //current index in temp

		long compar = 0 ;//holds comparisons
		while(current1< list1.length && current2 < list2.length){
			compar++;
			if(list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while(current2 < list2.length)
			temp[current3++] = list2[current2++];

		return compar;
	}
}
