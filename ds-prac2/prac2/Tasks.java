package prac2;

public class Tasks {

	/*
	 * DATASTRUCTURES AND ALGORITHMS 2015-2016 Programming assignment 2
	 * Deadline: Thursday October 8, 2015, before or at 23:59
	 * 
	 * Name(s) : Erik Baalhuis VUid(s) : 2545727
	 */

	// --------------------------------------------------------
	// METHODS FOR TASK 1 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task1(int[] a) {
		int len = a.length - 1;
		return recursiveCutRod(a, len);
	}

	// Recursion solution to the rod cutting problem. Warning: O(2^n)!
	private static int recursiveCutRod(int[] a, int len) {
		if (len == 0) {
			// End condition: rod of length 0 has no value.
			return 0;
		} else { // Rod has length >0, so try every cut that can be made.
			int max = -1;
			for (int i = 1; i <= len; i++) {
				// Try cutting off the last i segments.
				max = Math.max(max, recursiveCutRod(a, len - i) + a[i]);
			}
			return max;
		}
	}

	// --------------------------------------------------------
	// METHODS FOR TASK 2 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task2(int[] a) {
		int len = a.length - 1;
		return dynamicCutRod(a, len);
	}

	// Dynamic programming solution to the rod cutting problem. O(n^2).
	private static int dynamicCutRod(int[] a, int len) {
		// Make an array for dynamic programming. Position i contains the
		// maximum value that can be gained from a rod of length i.
		int[] dp = new int[len + 1];

		// For each length, starting at 1, determine the max value.
		for (int i = 1; i <= len; i++) {
			int max = -1;
			for (int j = 1; j <= i; j++) {
				// Consider cutting j segments off the end.
				max = Math.max(max, dp[i - j] + a[j]);
			}
			// The max we found is the best value for length i.
			dp[i] = max;
		}
		// The solution is the best value for length len.
		return dp[len];
	}

	// --------------------------------------------------------
	// METHODS FOR TASK 3 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task3(int[][] m) { // m has size n x n (i.e. it is square)
		int len = m.length;
		return dynamicAdjacentSum(m, len);
	}
	
	// Dynamic programming solution to the problem from task 3. O(n^2).
	private static int dynamicAdjacentSum(int[][] m, int len) {
		return h(m, len) + v(m, len) + d(m, len) + c(m, len);
	}

	// Find the largest sum of horizontally adjacent entries.
	private static int h(int[][] m, int len) {
		int res = 0;
		// Try each row to get the overall maximum.
		for (int i = 0; i < len; i++) {
			res = Math.max(res, arrayMax(m[i], len));
		}
		return res;
	}

	// Find the largest sum of vertically adjacent entries.
	private static int v(int[][] m, int len) {
		int res = 0;
		// Try each column to get the overall maximum.
		for (int i = 0; i < len; i++) {
			// Build the column
			int[] col = new int[len];
			for (int j = 0; j < len; j++) {
				col[j] = m[j][i];
			}
			res = Math.max(res, arrayMax(col, len));
		}
		return res;
	}

	// Find the largest sum of diagonally adjacent entries.
	private static int d(int[][] m, int len) {
		int res = 0;
		// Try each diagonal to get the overall maximum. Diagonal 0 is the
		// bottom-left entry, diagonal n is the main diagonal, etc.
		for (int i = 0; i < 2 * len - 1; i++) {
			// Determine the length of the current diagonal and its first entry.
			int diagLen = len - Math.abs(len - (i + 1));
			int startRow = i > len - 2 ? 0 : len - 1 - i;
			int startCol = i < len ? 0 : -len + 1 + i;
			// Build the diagonal
			int[] diag = new int[diagLen];
			for (int j = 0; j < diag.length; j++) {
				diag[j] = m[startRow + j][startCol + j];
			}
			res = Math.max(res, arrayMax(diag, diagLen));
		}
		return res;
	}

	// Find the largest sum of anti-diagonally adjacent entries.
	private static int c(int[][] m, int len) {
		int res = 0;
		// Try each anti-diagonal to get the overall maximum. Anti-diagonal 0 is
		// the top-left entry, diagonal len-1 is the main anti-diagonal, etc.
		for (int i = 0; i < 2 * len - 1; i++) {
			// Determine the length of the current anti-diagonal and its first
			// entry.
			int diagLen = len - Math.abs(len - (i + 1));
			int startRow = i > len - 2 ? len - 1 : i;
			int startCol = i < len ? 0 : -len + 1 + i;
			// Build the anti-diagonal
			int[] diag = new int[diagLen];
			for (int j = 0; j < diag.length; j++) {
				diag[j] = m[startRow - j][startCol + j];
			}
			res = Math.max(res, arrayMax(diag, diagLen));
		}
		return res;
	}

	// Given an array a and its length len, return the maximal adjacent sum.
	private static int arrayMax(int[] a, int len) {
		// Initialize result at 0 (if all sums are negative, we take the empty
		// array).
		int res = 0;
		// Make a dynamic programming array. Position i contains the maximum
		// sum of adjacent entries ending at a[i].
		int[] dp = new int[len];
		dp[0] = a[0];
		res = Math.max(res, dp[0]);
		for (int i = 1; i < len; i++) {
			// Either start a new sum, or add this entry to the best sum
			// ending at a[i-1].
			dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
