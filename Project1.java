/**
 * Author:		Annie Wu
 * Project:		1
 * 
 * Class:		CS 331 – Design and Analysis of Algorithms
 * Date:		4 May 2018
 * 
 * Purpose:		This program contains all the user interaction for
 * 			choosing which task to run.
 * 
 */

import java.util.Scanner;

public class Project1 {
	
	//string for which task to run
	private static String whichTask = "\n\nWhich task do you want to run? Enter a number."
					+ "\n 1. Task 1 - Sorting Algorithms"
					+ "\n 2. Task 2 - Matrix Multiplication"
					+ "\n 3. Exit\n";
	//string for how many elements n
	private static String howManyElements = "\nHow many elements for the array to be sorted? ";
	//string for size of matrix n x n
	private static String whatSizeMatrix = "\nWhat base for the squared matrices? ";
	
	//string for time for sorting algorithms
	private static String timeSort = "\nThe time for %s with n = %d is ";		
	//string for time for matrix multiplication
	private static String matrixTime = "\nThe time for %s with a %sx%s matrix is ";
	
	//string for time in miliiseconds
	private static String milli = "%d milliseconds.";
	//string for when the time is longer than ten minutes
	private static String longerThanTen = "longer than 10 minutes.";
	
	//string for when it is the wrong number inputed
	private static String invalidInput = "Invalid Input! Please enter a number.";
	//string for when it the inputed size of the matrix is not a power of 2
	private static String invalidMatrixBase = "Invalid Input! Please enter a power of two.";
	//string for exiting program
	private static String exit = "\nExiting the program!";
	
	public static void main(String args[]) {
		
		//create a scanner for keyboard input
		Scanner kb = new Scanner(System.in);
		//run = true, while loop and the program is running
		boolean run = true;
		
		//while the program is running
		while (run) {
			//which task to run
			System.out.print(whichTask);
			//next integer will be number of the task to run
			int task = kb.nextInt();
			//switch case for which task to run
			switch (task) {
				/*
				 * task 1 - sorting algorithms
				 */
				case 1:	
					//how many n elements for the array
					System.out.print(howManyElements);
					//next integer will be n elements
					int n = kb.nextInt();
					//create an array with the random numbers of size n
					int[] array = new int[n];
					//fill the array with random numbers
					for (int i=0; i<n; i++) {
						//random numbers into the array
						array[i] = (int) Math.random() * 1000000;
					}
					
					//set start time
					long startTime = 0;
					//set total time
					long totalTime = 0;
					//set absolute end time to 10 minutes after start time
					long END = 10*60*1000;
					
					/*
					 * exchange sort
					 */
					//start time for running exchange sort
					startTime = System.currentTimeMillis();
					//run exchange sort
					Sorting.exchangeSort(array);
					//if it runs longer than 10 min
					if (System.currentTimeMillis() - startTime > END) {
						//print error message
						System.out.printf(timeSort + longerThanTen, "exchange sort", n);
					}
					else {
						//total time for running exchange sort
						totalTime = System.currentTimeMillis() - startTime;
						//print elapsed time for exchange sort
						System.out.printf(timeSort + milli, "exchange sort", n, totalTime);
					}
					
					/*
					 * merge sort
					 */ 
					//start time for running merge sort
					startTime = System.currentTimeMillis();
					//run merge sort
					Sorting.mergeSort(array, 0, n-1);
					//if it runs longer than 10 min
					if (System.currentTimeMillis() - startTime > END) {
						//print error message
						System.out.printf(timeSort + longerThanTen, "merge sort", n);
					}
					else {
						//total time for running merge sort
						totalTime = System.currentTimeMillis() - startTime;
						//print elapsed time for merge sort
						System.out.printf(timeSort + milli, "merge sort", n, totalTime);
					}
					
					/*
					 * quick sort
					 */
					//start time for running quick sort
					startTime = System.currentTimeMillis();
					//run quick sort
					Sorting.quickSort(array, 0, n-1);
					//if it runs longer than 10 min
					if (System.currentTimeMillis() - startTime > END) {
						//print error message
						System.out.printf(timeSort + longerThanTen, "quick sort", n);
					}
					else {
						//total time for running quick sort
						totalTime = System.currentTimeMillis() - startTime;
						//print elapsed time for quick sort
						System.out.printf(timeSort + milli, "quick sort", n, totalTime);
					}
					break;
	
				/*
				 * task 2 - matrix multiplication
				 */
				case 2:
					//set start time
					startTime = 0;
					//set total time
					totalTime = 0;
					//set absolute end time to 10 minutes after start time
					END = 10*60*1000;
					
					//what size matrix, n x n
					System.out.print(whatSizeMatrix);
					//next integer is the base for the squared matrices
					n = kb.nextInt();
					
					//check to see if it is a power of 2 for the matrix size
					if ((n & (n - 1)) != 0) {
						//print error message
						System.out.println(invalidMatrixBase);
						break;
					}
					
					/*
					 * classical matrix multiplication
					 */
					//start time for running classical
					startTime = System.currentTimeMillis();
					//run classical
					Matrix.classical(n);
					//if it runs longer than 10 min
					if (System.currentTimeMillis() - startTime > END) {
						//print error message
						System.out.printf(matrixTime + longerThanTen, "classical", n, n);
					}
					else {
						//total time for running classical
						totalTime = System.currentTimeMillis() - startTime;
						//print elapsed time for running classical
						System.out.printf(matrixTime + milli, "classical", n, n, totalTime);
					}
					
					/*
					 * Strassen's matrix multiplication
					 */
					//start time for running strassens
					startTime = System.currentTimeMillis();
					//run strassens
					Matrix.strassen(n);
					//if it runs longer than 10 min
					if (System.currentTimeMillis() - startTime > END) {
						//print error message
						System.out.printf(matrixTime + longerThanTen, "Strassen's", n, n);
					}
					else {
						//total time for running strassens
						totalTime = System.currentTimeMillis() - startTime;
						//print elapsed time for strassens
						System.out.printf(matrixTime + milli, "Strassen's", n, n, totalTime);
					}
					break;
					
				//exit
				case 3:
					//print exit message
					System.out.println(exit);
					//set run to false to exit the while loop and the program
					run = false;
					break;
				default:
					//print message for invalid input
					System.out.println(invalidInput);
			}
		}
		//close keyboard scanner
		kb.close();
	}
}

