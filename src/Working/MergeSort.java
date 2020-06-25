package Working;

public class MergeSort {

 if(list.length>1){

 	//merge sort first half
 	int[] firsthalf = new int[list.length / 2];
 	System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
 	MergeSort(firsthalf);

 	//merge sort the second half
 	int secondHalfLength = list.length - list.length / 2;
 	int[] secondHalf = new int[secondHalfLength];
 }
}
