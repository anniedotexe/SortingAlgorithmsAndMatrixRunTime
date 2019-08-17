# Comparing Sorting and Matrix Algorithms Run Times

The user can choose to:
<li>Compare sorting algorithm runtimes</li>
<li>Compare matrix multiplication runtimes</li>
<li>Exit the program</li>

## Sorting Algorithms
The user is prompted to enter the number of elements in the array. <br>

The program will print the runtimes for exchange sort, merge sort, and quick sort. <br>

## Matrix Multiplication Algorithms
The user is prompted to enter the base of the matrix, which must be a multiple of 2. <br>

The program will print the runtimes for classical matrix multiplcation and Strassen's matrix multiplication. <br>


#### Sample Output

```
Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
1

How many elements for the array to be sorted? 5930

The time for exchange sort with n = 5930 is 14 milliseconds.
The time for merge sort with n = 5930 is 1 milliseconds.
The time for quick sort with n = 5930 is 1 milliseconds.

Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
1

How many elements for the array to be sorted? 586729

The time for exchange sort with n = 586729 is 35891 milliseconds.
The time for merge sort with n = 586729 is 44 milliseconds.
The time for quick sort with n = 586729 is 15 milliseconds.

Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
2

What base for the squared matrices? 256

The time for classical with a 256x256 matrix is 47 milliseconds.
The time for Strassen's with a 256x256 matrix is 4445 milliseconds.

Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
2

What base for the squared matrices? 64

The time for classical with a 64x64 matrix is 2 milliseconds.
The time for Strassen's with a 64x64 matrix is 118 milliseconds.

Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
2

What base for the squared matrices? 457
Invalid Input! Please enter a power of two.


Which task do you want to run? Enter a number.
 1. Task 1 - Sorting Algorithms
 2. Task 2 - Matrix Multiplication
 3. Exit
3

Exiting the program!
```