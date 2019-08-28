package cs2420;

/**
 * Represents a 2-d integer matrix as a 2-d int array.
 * 
 * @author Swaroop Joshi
 *
 */
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

		/*
		 * TODO: replace the below return statement with the correct code, you must
		 * return the correct value after determining if this matrix is equal to the
		 * input matrix
		 */
//		if(!m.equals(o)) {
//			return false;// placeholder
//		}
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
		/*
		 * TODO: implement the method to match the description
		 */
		return null; // placeholder; don't use explicit nulls otherwise
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
		
		if(m == null) {
			throw new IllegalArgumentException("m cannot be null");
		}
		return null; // placeholder; don't use explicit nulls otherwise
	}
}
