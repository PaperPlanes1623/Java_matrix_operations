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

		/*
		 * Testing plus
		 */
		Matrix m3 = new Matrix(new int[][] {{1, 2}, {1, 1}});
		Matrix actualSum = m1.plus(m3);
		Matrix expectedSum = new Matrix(new int[][] {{1, 1}, {1, 1}});
		if(!expectedSum.equals(actualSum)) {
			out.println("equals error (m1 + m3 not equal to expected result)");
		}

		/*
		 * Finally close the output stream
		 */
		out.close();
	}
}
