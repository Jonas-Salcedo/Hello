//Number of comparisons in worst case: 0
//Number of movements in worst case: 2n
package Working;

import java.io.*;

import java.util.*;

class Radix {

	static long[] threeVals = {0,0,0};

 static int getMax(int arr[], int n){

	 

 int mx = arr[0];

 for (int i = 1; i < n; i++) 
	 //below counts as a comparison
	
 if (arr[i] > mx) {  //find the max 
 mx = arr[i]; //new max equals 1 movement
 threeVals[1]++;

 }
 return mx;
 
}
 
 
 static void countSort(int arr[], int n, int exp) {

 int output[] = new int[n];

 int i;

 int count[] = new int[10];

 Arrays.fill(count,0);
 //Store the count of "keys" or digits in count[]
 for (i = 0; i < n; i++)

 count[ (arr[i]/exp)%10 ]++;

 // Change count[i] so that count[i] now contains
 // actual position of this digit in output[]

 
 for (i = 1; i < 10; i++)
 count[i] += count[i - 1];
 //above is a movement for each loop
 threeVals[1]++;
 
 // Build the arr[]
 // arr[] contains sorted
 // numbers according to current digit place
 for (i = n - 1; i >= 0; i--){
  // Move to next digit place
 output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
//above is a movement for each loop
 threeVals[1]++;

 count[ (arr[i]/exp)%10 ]--;

 }
//pass array to output
 for (i = 0; i < n; i++) { 
 arr[i] = output[i];
//above is a movement for each loop
 threeVals[1]++;

 }

 }

 static long[] radixsort(int arr[], int n)

 { // Find the maximum number to know number of digits

 int m = getMax(arr, n);

 long st = System.nanoTime();



 for (int exp = 1; m/exp > 0; exp *= 10)

 countSort(arr, n, exp);

 

 long et = System.nanoTime();

 threeVals[2] = et - st;

 return threeVals;

 }

}
