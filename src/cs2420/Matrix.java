package cs2420;

import java.util.Arrays;

/**
 * Represents a 2-d integer matrix as a 2-d int array.
 * 
 * @author Swaroop Joshi
 *
 */
@SuppressWarnings("unused")
public class Matrix {
	/**
	 * Holds the number of rows of this matrix
	 */
	private int numRows;
	/**
	 * Holds the number of columns of this matrix
	 */
	private int numColumns;
	/**
	 * Holds the actual data of this matrix
	 */
	private int data[][];

	/**
	 * Constructor from a 2D array -- automatically determines the dimensions.
	 * 
	 * @param d 2D array to construct the matrix
	 * @throws IllegalArgumentException if {@code d} is empty or null
	 */
	public Matrix(int d[][]) throws IllegalArgumentException {
		if (d == null || d.length == 0) {
			throw new IllegalArgumentException();
		}
		this.numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		this.numColumns = d[0].length; // d[0] is the first 1D array

		// create a new matrix to hold the data
		this.data = new int[this.numRows][this.numColumns];
		// copy the data over
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numColumns; j++) {
				this.data[i][j] = d[i][j];
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false; // Why?
		}
		if (!(o instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix m = (Matrix) o; // if the above was not true, we know it's safe to treat 'o' as a Matrix

		//if dimensions do not match, return false
		if(this.numRows != m.numRows || this.numColumns != m.numColumns) {
			return false;
		}
		//if data does not match, return false
		for(int i=0; i<this.numRows; i++) {
			for(int j=0; j<this.numColumns; j++) {
				if(this.data[i][j] != m.data[i][j]) {
					return false;
				}
			}
		}
		//return true otherwise
		return true;
	}

	@Override
	public String toString() {
		
		String output = "";
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				output += data[i][j] + " ";
			}
			output +="\n";
		}
				
		
		
		return output; // placeholder; don't use explicit nulls otherwise
	}

	/**
	 * Multiplies {@code this} by {@code m} and returns the result as a new
	 * {@code Matrix}. If {@code m} does not have appropriate dimensions to multiply
	 * to {@code this}, it throws an {@code IllegalArgumentException}.
	 * 
	 * @param m matrix to multiply {@code this} with
	 * @return result of the product
	 * 
	 * @throws IllegalArgumentException if dimensions of the matrices are not
	 *                                  compatible
	 */
	public Matrix times(Matrix m) throws IllegalArgumentException {
		
		if(this.numColumns != m.numRows) {
			throw new IllegalArgumentException("Not Valid Multiplication Matrix");
		}
		
		Matrix resultMatrix = new Matrix(new int[this.numRows][m.numColumns]);
		int temp = 0;
		
		for(int i=0; i<this.numRows; i++) {
			for(int j=0; j<this.numColumns; j++) {
				//add entries of i row in first matrix and j column of second matrix
				for(int k=0; k< this.numColumns; k++) {
					temp += this.data[i][k] * m.data[k][j];
				}
				//assign temp holder to entry in matrix
				resultMatrix.data[i][j] = temp;
				temp = 0;
			}
		}
		return resultMatrix; // placeholder; don't use explicit nulls otherwise
	}

	/**
	 * Adds {@code m} to {@code this} and returns the result as a new
	 * {@code Matrix}. If {@code m} does not have the same dimensions as
	 * {@code this}, it throws an {@code IllegalArgumentException}.
	 * 
	 * @param m matrix to add to {@code this} with
	 * @return result of the addition
	 *
	 * @throws IllegalArgumentException if dimensions of the matrices are not
	 *                                  compatible
	 */
	public Matrix plus(Matrix m) throws IllegalArgumentException {
		Matrix resultMatrix = new Matrix(new int[this.numRows][this.numColumns]);
		
		if(!resultMatrix.equals(m)) {
			throw new IllegalArgumentException("matrices must be same size");
		}
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				 resultMatrix.data[i][j] = this.data[i][j] + m.data[i][j];
			}
		}
		
	return resultMatrix;
		
	}
}
