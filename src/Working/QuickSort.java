package Working;

public class QuickSort {



	public static long[] quickSort(int[] list){

		//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
		long[] threeVals = {0, 0, 0};
		//Time before sorting is completed
		long st = System.nanoTime();

		quickSort(list, 0, list.length - 1);

			long et = System.nanoTime();
		//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
		threeVals[2] = et - st;
		//Returns comparisons, movements, and total time in that order;
		return threeVals;
	}

	public static void quickSort(int[] list, int first, int last){
		if(last > first){
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex + 1, last);
		}
	}


	/** partition the list array **/
	public static int partition(int[] list, int first, int last){
		int pivot = list[first];
		int low = first +1;
		int high = last;

		while(high>low){

			while(low <= high && list[low] <= pivot)
				low++;

			while( low <= high && list[high]> pivot)
				high--;

			if(high > low){
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while(high > first && list[high] >= pivot)
			high--;

		if(pivot > list[high]){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else{
			return first;
		}
	}

}
