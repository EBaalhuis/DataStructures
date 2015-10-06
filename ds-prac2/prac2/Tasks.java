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
		int n = a.length;
		return recursiveCutRod(a, n);
	}

	public static int recursiveCutRod(int[] a, int len) {
		if (len == 0) {
			// End condition: rod of length 0 has no value.
			return 0;
		} else { // Rod has length >0, so try every cut that can be made.
			int max = -1;
			for (int i = 0; i < len; i++) {
				// Try cutting off the last i segments.
				max = Math.max(max, recursiveCutRod(a, len - (i+1)) + a[i]);
			}
			return max;
		}
	}

	// --------------------------------------------------------
	// METHODS FOR TASK 2 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task2(int[] a) {

		return 0;
	}

	// --------------------------------------------------------
	// METHODS FOR TASK 3 BELOW THIS LINE
	// --------------------------------------------------------

	public static int task3(int[][] m) { // m has size n x n (i.e. it is square)

		return 0;
	}

}
