package prac1;
//
class HeapSorter {

	/*
	 * DATASTRUCTURES AND ALGORITHMS 2015-2016 Practical assignment 1 Deadline:
	 * Thursday September 17, 2015
	 * 
	 * Name(s) : Erik Baalhuis VUid(s) : ebs262
	 */

	/*
	 * - Every method must be declared static. - Please make sure you clean up
	 * your file before handing it in. E.g. remove insertionSort() (provided
	 * below as an example) as well as any debugging methods you may have
	 * written and used.
	 */

	// --------------------------Ternary HeapSort-----------------------------//

	static void siftDownT(int[] a, int start, int end) {
		/*
		 * siftDownT is carried out floor((a.length - 2) / 3) times during
		 * heapifyT and a.length-1 times called directly from ternaryHeapSort.
		 * The value of end-start is different between calls, but at most
		 * a.length.
		 */
		int root = start;
		/*
		 * This assignment is carried out a.length-1 + floor((a.length - 2) / 3)
		 * times.
		 */

		while (root * 3 + 1 <= end) {
			/*
			 * In the worst case, a swap has to be executed for each level of
			 * the heap beside the first. Because the heap is ternary, this is
			 * floor(log(end-start) / log(3)) times. So this while loop is
			 * carried out at most floor(log(end-start) / log(3)) * (a.length-1
			 * + floor((a.length - 2) / 2)) times.
			 */

			int child = root * 3 + 1;
			/*
			 * This assignment is carried out once per execution of the while
			 * loop around it.
			 */
			int swap = root;
			/*
			 * This assignment is carried out once per execution of the while
			 * loop around it.
			 */

			if (a[swap] < a[child]) {
				/*
				 * The test a[swap] < a[child] is executed once per execution of
				 * the while loop around it.
				 */
				swap = child;
			}

			if (child + 1 <= end && a[swap] < a[child + 1]) {
				/*
				 * The test child + 1 <= end && a[swap] < a[child + 1] is
				 * executed once per execution of the while loop around it.
				 */
				swap = child + 1;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}
			if (child + 2 <= end && a[swap] < a[child + 2]) {
				/*
				 * The test child + 2 <= end && a[swap] < a[child + 2] is
				 * executed once per execution of the while loop around it.
				 */
				swap = child + 2;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}

			if (swap == root) {
				/*
				 * The test swap == root is executed once per execution of the
				 * while loop around it.
				 */
				return;
			} else {
				swap(a, root, swap);
				/*
				 * This swap (3 assignments) is carried out at most once per
				 * execution of the while loop around it.
				 */
				root = swap;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}
		}
	}

	static void heapifyT(int[] a, int count) {
		/*
		 * heapifyT is carried out once.
		 */
		int start = (int) Math.floor((count - 2) / 3);
		/*
		 * This assignment is carried out once.
		 */

		while (start >= 0) {
			/*
			 * The initial value of start is floor((a.length - 2) / 3). So this
			 * while loop is carried out floor((a.length - 2) / 3) times.
			 */
			siftDownT(a, start, count - 1);
			/*
			 * Carried out floor((a.length - 2) / 3) times. Each time start is 1
			 * lower than the time before.
			 */
			start--;
			/*
			 * This assignment is carried out floor((a.length - 2) / 3) times.
			 */
		}
	}

	static int[] ternaryHeapSort(int[] a, int count) {
		heapifyT(a, count);
		/*
		 * Carried out once.
		 */

		int end = count - 1;
		/*
		 * Carried out once.
		 */

		while (end > 0) {
			/*
			 * end > 0 occurs a.length-1 times, so the body of this while- loop
			 * is executed a.length-1 times.
			 */
			swap(a, end, 0);
			/*
			 * swap is carried out a.length-1 times, and each instance does 3
			 * assignments.
			 */
			end--;
			/*
			 * This assignment is carried out a.length-1 times.
			 */
			siftDownT(a, 0, end);
			/*
			 * Carried out a.length-1 times.
			 */
		}

		return a;
	}

	/*
	 * The worst-case time complexity for the while loop in siftDownT is
	 * floor(log(a.length) / log(3)). siftDown is called a.length-1 +
	 * floor((a.length - 2) / 3) times, so the worst-case time complexity of the
	 * algorithm ternaryHeapSort is O(n log n). Note that there is no difference
	 * in the big-o time complexity of binaryHeapSort and ternaryHeapSort,
	 * because the only difference is the constant log(3).
	 */

	// --------------------------Binary HeapSort-----------------------------//

	static void siftDown(int[] a, int start, int end) {
		/*
		 * siftDown is carried out floor((a.length - 2) / 2) times during
		 * heapify and a.length-1 times called directly from binaryHeapSort. The
		 * value of end-start is different between calls, but at most a.length.
		 */
		int root = start;
		/*
		 * This assignment is carried out a.length-1 + floor((a.length - 2) / 2)
		 * times.
		 */

		while (root * 2 + 1 <= end) {
			/*
			 * In the worst case, a swap has to be executed for each level of
			 * the heap beside the first. Because the heap is binary, this is
			 * floor(log(end-start)) times. So this while loop is carried out at
			 * most floor(log(end-start)) * (a.length-1 + floor((a.length - 2) /
			 * 2)) times.
			 */

			int child = root * 2 + 1;
			/*
			 * This assignment is carried out once per execution of the while
			 * loop around it.
			 */
			int swap = root;
			/*
			 * This assignment is carried out once per execution of the while
			 * loop around it.
			 */

			if (a[swap] < a[child]) {
				/*
				 * The test a[swap] < a[child] is executed once per execution of
				 * the while loop around it.
				 */
				swap = child;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}

			if (child + 1 <= end && a[swap] < a[child + 1]) {
				/*
				 * The test child + 1 <= end && a[swap] < a[child + 1] is
				 * executed once per execution of the while loop around it.
				 */
				swap = child + 1;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}

			if (swap == root) {
				/*
				 * The test swap == root is executed once per execution of the
				 * while loop around it.
				 */
				return;
			} else {
				swap(a, root, swap);
				/*
				 * This swap (3 assignments) is carried out at most once per
				 * execution of the while loop around it.
				 */
				root = swap;
				/*
				 * This assignment is carried out at most once per execution of
				 * the while loop around it.
				 */
			}
		}
	}

	static void heapify(int[] a, int count) {
		/*
		 * heapify is carried out once.
		 */
		int start = (int) Math.floor((count - 2) / 2);
		/*
		 * This assignment is carried out once.
		 */

		while (start >= 0) {
			/*
			 * The initial value of start is floor((a.length - 2) / 2). So this
			 * while loop is carried out floor((a.length - 2) / 2) times.
			 */
			siftDown(a, start, count - 1);
			/*
			 * Carried out floor((a.length - 2) / 2) times. Each time start is 1
			 * lower than the time before.
			 */
			start--;
			/*
			 * This assignment is carried out floor((a.length - 2) / 2) times.
			 */
		}
	}

	static int[] binaryHeapSort(int[] a, int count) {
		heapify(a, count);
		/*
		 * Carried out once.
		 */

		int end = count - 1;
		/*
		 * Carried out once.
		 */

		while (end > 0) {
			/*
			 * end > 0 occurs a.length-1 times, so the body of this while- loop
			 * is executed a.length-1 times.
			 */
			swap(a, end, 0);
			/*
			 * swap is carried out a.length-1 times, and each instance does 3
			 * assignments.
			 */
			end--;
			/*
			 * This assignment is carried out a.length-1 times.
			 */
			siftDown(a, 0, end);
			/*
			 * Carried out a.length-1 times.
			 */
		}

		return a;
		/*
		 * Carried out once.
		 */
	}

	/*
	 * The worst-case time complexity for the while loop in siftDown is
	 * floor(log(a.length)). siftDown is called a.length-1 + floor((a.length -
	 * 2) / 2) times, so the worst-case time complexity of the algorithm
	 * binaryHeapSort is O(n log n).
	 */

	// -----------------------------------------------------------------------//

	static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}

	static int[] start(int[] toSort, boolean binaryHeap) {
		if (binaryHeap) {
			binaryHeapSort(toSort, toSort.length);
		} else { // ternary heap
			ternaryHeapSort(toSort, toSort.length);
		}

		return toSort;
	}
}