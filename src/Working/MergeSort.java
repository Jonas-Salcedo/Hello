package Working;

public class MergeSort {

	public static void mergeSort(int[] list){
		if(list.length>1){

 			//merge sort first half
 			int[] firsthalf = new int[list.length / 2];
 			System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
 			MergeSort(firsthalf);

 			//merge sort the second half
 			int secondHalfLength = list.length - list.length / 2;
 			int[] secondHalf = new int[secondHalfLength];
 			System.arraycopy(list, list.length / 2,
 				secondHalf, 0, secondHalfLength);
 			merge(secondHalf);

 			//merge firstHalf with secondHalf into list
 			merge(firsthalf, secondHalf, list);
 		}
	}

	/**Merge two sorted lists **/
	public static void merge(int[] list1, int[] list2, int[] temp){
		int current1 = 0; //current index in list1
		int current2 = 0; //current index in list2
		int current3 = 0; //current index in temp

		while(current1< list1.length && current2 < list2.length){
			if(list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list.length)
			temp[current3++] = list1[current1++];

		while(current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
}
