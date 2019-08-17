/**
 * Author:		Annie Wu
 * Project:		1
 * 
 * Class:		CS 331 – Design and Analysis of Algorithms
 * Date:		4 May 2018
 * 
 * Purpose:		This program calculates the elapsed time for exchange sort, merge sort,
 * 			and quick sort to sort a list of n elements.
 * 
 */

public class Sorting {

	/**
	 * This is the function for exchange sort.
	 * @param array array of numbers
	 */
	public static void exchangeSort(int array[]) {
		//i will be from the left number to the right number in the array
		for (int i=0; i<array.length -1; i++) {
			//j will be from the second number to the right number in the array
			for (int j=i+1; j<array.length; j++) {
				//if i > j, swap those two numbers in the array
				if (array[i] > array[j]) {
					//store value of index i in temp
					int temp = array[i];
					//value of index i will be value of index j
					array[i] = array[j];
					//value of index j will be value that was put in temp
					array[j] = temp;
				}
			}
		}
	}
	
	/**
	 * This is the function for merge sort.
	 * @param array array of numbers
	 * @param left left index
	 * @param right right index
	 */
	public static void mergeSort(int array[], int left, int right) {
		if (left < right) {
			//middle number is half of the sum of left and right
			int mid = (left + right)/2;
			//recursively sort the left half of the array
			mergeSort(array, left, mid);
			//recursively sort the second half of the array
			mergeSort(array, mid+1, right);
			//merge the sorted halves
			mergeSortHelper(array, left, mid, right);
		}
	}
	
	/**
	 * This is the function for merging the arrays in merge sort.
	 * @param array array of numbers
	 * @param left left index
	 * @param mid middle
	 * @param right right index
	 */
	public static void mergeSortHelper(int array[], int left, int mid, int right) {
		//size of left half of the array
		int half1 = mid - left +1;
		//size of second half of the array
		int half2 = right - mid;
		
		//create left array
		int L[] = new int[half1];
		//create right array
		int R[] = new int[half2];
		//copy left half of original array into left array
		for (int i=0; i<half1; i++) {
			//left element plus index i
			L[i] = array[left+i];
		}
		//copy right half of original array into right array
		for (int j=0; j<half2; j++) {
			//right element (one more than the middle element) plus index j
			R[j] = array[mid+1 + j];
		}
		//index of left array
		int i = 0;
		//index of right array
		int j = 0;
		//index of the merged array is initialized to 1
		int k = 1;
		
		//while the index of the left array < size of the left array
		//and the index of the right array < size of the right array
		while (i < half1 && j < half2) {
			//if number in index i in the left array <= number in index j in the right array
			if (L[i] <= R[j]) {
				//number in index k in merged array will be number in index i in the left array 
				array[k] = L[i];
				//increment i
				i++;
			}
			else {
				//number in index k in merged array will be number in index j in the right array 
				array[k] = R[j];
				//increment j
				j++;
			}
			//increment k
			k++;
		}
	}
	
	/**
	 * This is the function for quick sort.
	 * @param array array of numbers
	 * @param start start index
	 * @param end end index
	 */
	public static void quickSort(int array[], int start, int end) {
		//if the left index is less than the right index
		if (start < end) {
			//create pivot index
			int pivot = partition(array, start, end);
			//recursively sort elements before the pivot
			quickSort(array, start, pivot);
			//recursively sort elements after the pivot
			quickSort(array, pivot +1, end);
		}
	}
	
	/**
	 * This is the function to partition for quick sort.
	 * @param array array of numbers
	 * @param start start index
	 * @param end end index
	 * @return sorted array
	 */
	public static int partition(int array[], int start, int end) {
		//set left to start
		int left = start;
		//set right to end
		int right = end;
		//pivot will be the right element in the array
		int pivot = array[left];
		
		//while the left index is less than or equal to right index
		while (true) {
			//move to the right once
			do {
				left++;
			}
			//while the left pointer is less than the end and the element is less than the pivot
			while (left < end && array[left] < pivot);
			
			//move to the left once
			do {
				right--;
			}
			//while the right pointer is greater than the start and the element is greater than the pivot
			while (right > start && array[left] > pivot);
			
			//if left index is less than right index
			if (left < right) {
				/*
				 * swap the elements
				 */
				//temp is left index
				int temp = array[left];
				//left index +1 is right index
				array[left++] = array[right];
				//right index is temp
				array[right--] = temp;
			}
			else {
				//return the right index
				return right;
			}
		}
	}
}

