/**
 * Author:		Annie Wu
 * Project:		1
 * 
 * Class:		CS 331 – Design and Analysis of Algorithms
 * Instructor:	Tannaz R.Damavandi
 * Date:		4 May 2018
 * 
 * Purpose:		This program calculate the elapsed time for classical matrix
 * 				multiplication and Strassen's matrix multiplication with
 * 				matrix size n x n.
 * 
 */

public class Matrix {

	/**
	 * This is the function for classical matrix multiplication.
	 */
	public static void classical(int n) {
		//create first matrix A with size n x n
		int[][] A = new int[n][n];
		//create second matrix B with size n x n
		int[][] B = new int[n][n];
		//create final matrix C for the product with size n x n
		int[][] C = new int[n][n];
				
		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//put random number into that spot in matrix A
				A[i][j] = (int) Math.random() * 1000000;
			}
		}
		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//put random number into that spot in matrix B
				B[i][j] = (int) Math.random() * 1000000;
			}
		}
		//row i
		for (int i = 0; i < n; i++) {
			//column j
			for (int j = 0; j < n; j++) {
				//initialize result to zero
				C[i][j] = 0;
				//certain row and column k
				for (int k = 0; k < n; k++) {
					//multiply matrix
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
	
	/**
	 * This is the function for strassen's matrix multiplication.
	 * It initializes the matrices.
	 */
	public static void strassen(int n) {
		
		//create first matrix A with size n x n
		int[][] A = new int[n][n];
		//create second matrix B with size n x n
		int[][] B = new int[n][n];

		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//fill up matrix A with random numbers
				A[i][j] = (int) Math.random() * 1000000;
			}
		}
		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//fill up matrix B with random numbers
				B[i][j] = (int) (int) Math.random() * 1000000;
			}
		}		
		mult(A, B);
	}
	
	/**
	 * This is the function for multiplying in 
	 * strassen's matrix multiplication.
	 */
	public static int[][] mult(int[][] A, int[][] B) {
		//set size of matrix to length of A
		int n = A.length;
		//result matrix C with size 2x2
		int[][] C = new int[n][n];

		//base case when n = 1
		if (n == 1) {
			//multiply A and B
			C[0][0] = A[0][0] * B[0][0];
		}
		else {
			//matrix A row 1 column 1
			int[][] A11 = new int[n/2][n/2];
			//matrix A row 1 column 2
			int[][] A12 = new int[n/2][n/2];
			//matrix A row 2 column 1
			int[][] A21 = new int[n/2][n/2];
			//matrix A row 2 column 2
			int[][] A22 = new int[n/2][n/2];
			//matrix B row 1 column 1
			int[][] B11 = new int[n/2][n/2];
			//matrix B row 1 column 2
			int[][] B12 = new int[n/2][n/2];
			//matrix B row 2 column 1
			int[][] B21 = new int[n/2][n/2];
			//matrix B row 2 column 2
			int[][] B22 = new int[n/2][n/2];
			
			/*
			 * divide matrix into 4 parts
			 */
			//row i
			for (int i=0; i<n/2; i++) {
				//column j
				for (int j=0; j<n/2; j++) {
					//top left, row 1 column 1
					A11[i][j] = A[i][j];
					//top right, row 1 column 2
	                A12[i][j] = A[i][j + n/2]; 
	                //bottom left, row 2 column 1
	                A21[i][j] = A[i + n/2][j];
	                //bottom right, row 2 column 2 
	                A22[i][j] = A[i + n/2][j + n/2];
	                //top left, row 1 column 1
	                B11[i][j] = B[i][j];
					//top right, row 1 column 2
	                B12[i][j] = B[i][j + n/2];
	                //bottom left, row 2 column 1
	                B21[i][j] = B[i + n/2][j];
	                //bottom right, row 2 column 2
	                B22[i][j] = B[i + n/2][j + n/2];
				}
			}

	        //product P = (A11 + A22) * (B11 + B22)
	        int[][] P = mult(add(A11, A22), add(B11, B22));
	        
			//product Q = (A21 + A22) * B11
			int[][] Q = mult(add(A21, A22), B11);
			
			//product R = A11 * (B12 - B22)
			int[][] R = mult(A11, subtract(B12, B22));
	
			//product S = A22 * (B21 - B11)
			int[][] S = mult(A22, subtract(B21, B11));
			
			//product T = (A11 + A12) * B22
			int[][] T = mult(add(A11, A12), B22);
			
			//product U = (A21 - A11) * (B11 + B12)
			int[][] U = mult(subtract(A21, A11), add(B11, B12));
			
			//product V = (A12 - A22) * (B21 + B22)
			int[][] V = mult(subtract(A12, A22), add(B21, B22));
			
			//C11 = P + S - T + V
			//first add P and S
			//then sub T
			//last add V
			int [][] C11 = add(subtract(add(P, S), T), V);
	        //C12 = R + T
			int [][] C12 = add(R, T);
	        //C21 = Q + S
			int [][] C21 = add(Q, S);
	        //C22 = P + R - Q + U
			//first add P and Q
			//then sub R
			//last add U
			int [][] C22 = add(subtract(add(P, R), Q), U);
			
			/*
			 * combine the matrices back into one
			 */
	        //row i
			for (int i = 0; i < n/2; i++) {
	            //column j
				for (int j = 0; j < n/2; j++) {
	            	//top left of the matrix
	                C[i][j] = C11[i][j];
	                //top right of the matrix	
	                C[i][j + n/2] = C12[i][j];
	                //bottom left of the matrix
	                C[i + n/2][j] = C21[i][j];
	                //bottom right of the matrix
	                C[i + n/2][j + n/2]	= C22[i][j];
	            }
	        }
		}
		//return final matrix C
		return C;
	}
		
	/**
	 * This is the function to add two matrices in 
	 * strassen's matrix multiplication.
	 */
	public static int[][] add(int[][] A, int[][] B) {
		//size n x n is the length of matrix A
		int n = A.length;
		//create a new matrix for the sum
		int[][] sum = new int[n][n];
		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//add the two matrices
				sum[i][j] = A[i][j] + B[i][j];
			}
		}
		//return the matrix with the sum of the two matrices
		return sum;
	}
	
	/**
	 * This is the function to subtract two matrices in 
	 * strassen's matrix multiplication.
	 */
	public static int[][] subtract(int[][] A, int[][] B) {
		//size n x n is the length of matrix A
		int n = A.length;
		//create a new matrix for the difference
		int[][] difference = new int[n][n];
		//row i
		for (int i=0; i<n; i++) {
			//column j
			for (int j=0; j<n; j++) {
				//subtract the two matrices
				difference[i][j] = A[i][j] - B[i][j];
			}
		}
		//return the matrix with the difference of the two matrices
		return difference;
	}
}
