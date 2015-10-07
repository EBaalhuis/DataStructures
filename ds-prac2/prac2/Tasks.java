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
		int len = a.length;
		return recursiveCutRod(a, len);
	}

	private static int recursiveCutRod(int[] a, int len) {
		if (len == 0) {
			// End condition: rod of length 0 has no value.
			return 0;
		} else { // Rod has length >0, so try every cut that can be made.
			int max = -1;
			for (int i = 0; i < len; i++) {
				// Try cutting off the last i segments.
				max = Math.max(max, recursiveCutRod(a, len - i - 1) + a[i]);
			}
			return max;
		}
	}

	// --------------------------------------------------------
	// METHODS FOR TASK 2 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task2(int[] a) {
		int len = a.length;
		return dynamicCutRod(a, len);
	}

	private static int dynamicCutRod(int[] a, int len) {
		// Make an array for dynamic programming. Position i is the maximum
		// value that can be gained from a rod of length i.
		int[] dp = new int[len + 1];

		for (int i = 1; i <= len; i++) {
			// For each length, starting at 1, determine the max value.
			int max = -1;
			for (int j = 0; j < i; j++) {
				// Consider cutting to each length less than i. 
				max = Math.max(max, a[j] + dp[i - j - 1]);
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

		return 0;
	}

}
