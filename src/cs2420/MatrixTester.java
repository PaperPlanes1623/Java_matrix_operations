package cs2420;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Skeleton to test your matrix implementation. Some test cases are provided.
 * You need to add many more.
 * 
 * @author Swaroop Joshi
 *
 */
public class MatrixTester {
	public static void main(String[] args) {
		SimpleWriter out = new SimpleWriter1L();

		/*
		 * Test case 1: constructing a matrix from an empty array should throw an
		 * IllegalArgumentException.
		 */
		int[][] d = new int[0][0];
		boolean caughtRightException = false;
		@SuppressWarnings("unused")
		Matrix m;
		try {
			m = new Matrix(d);
		} catch (IllegalArgumentException e) {
			out.println("Success: constructing a matrix from an empty array");
			caughtRightException = true;
		}
		if (!caughtRightException) {
			out.print("Fail: constructing a matrix from an empty array");
			caughtRightException = false; // reset for next such test case
		}

		/*
		 * Test case 2: a valid matrix multiplication
		 */
		Matrix m1 = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } });
		/*
		 * Testing toString
		 */
		String m1StrExp = "1 2 3 \n2 5 6 \n";
		String m1StrActual = m1.toString();
		if (!m1StrExp.equals(m1StrActual)) {
			out.println("toString Error.\nGot:\n" + m1StrActual + "\nExpected:\n" + m1StrExp);
		}

		/*
		 * Testing equals
		 */
		Matrix m1Expected = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } });
		if (!m1Expected.equals(m1)) {
			out.println("Equals error: m1 and m1Expected not equal\nGot:" + m1 + "\nexpected:" + m1Expected + ")");
		}

		/*
		 * Testing times (!! Pun unintended !!)
		 */
		Matrix m2 = new Matrix(new int[][] { { 4, 5 }, { 3, 2 }, { 1, 1 } });
		Matrix actualProduct = m1.times(m2);
		Matrix expectedProduct = new Matrix(new int[][] { { 13, 12 }, { 29, 26 } }); // we know this from math
		if (!expectedProduct.equals(actualProduct)) {
			out.println("equals error (m1 * m2 not equal to expected result)");
		}
		else {
			out.println("Success: m1 * m2 equal to expected result");
		}

		/*
		 * Testing plus
		 */
		Matrix m3 = new Matrix(new int[][] {{1, 2, 3}, {1, 1, 2}});
		Matrix actualSum = m1.plus(m3);
		Matrix expectedSum = new Matrix(new int[][] {{2, 4, 6}, {3, 6, 8}});
		if(!expectedSum.equals(actualSum)) {
			out.println("equals error (m1 + m3 not equal to expected result)");
		}
		else {
			out.println("Success: m1 + m3 equal to expected result");
		}
		
		/*
		 * Testing plus illegalArgumentException for invalid dimensions
		 */
		Matrix m4 = new Matrix(new int[][] {{1}, {1}});
		boolean caughtPlusException = true;
		
		try {
			m4.plus(m1);
		}
		catch(IllegalArgumentException e) {
			out.println("Success: Exception Caught when matrices are not same size");
			caughtPlusException = true;
		}
		if(!caughtPlusException) {
			out.println("Fail: Exception Not Caught When matrices are not same size");
			caughtPlusException = false;
		}
		
		/*
		 * Testing equals for invalid dimensions
		 */
		if(m4.equals(m3)) {
			out.println("equals error: m4 and m3 are not equal");
		}
		else {
			out.println("Success: equals is successful");
		}

		/*
		 * Finally close the output stream
		 */
		out.close();
	}
}
