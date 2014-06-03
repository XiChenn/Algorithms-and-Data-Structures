package algorithms.sorting;

/**
 * This class implements the QuickSort algorithm using one randomly chosen
 * pivot. It runs in O(log (n)) time even the array contains all the same
 * elements.
 * 
 * When finding the position of pivot, two pointers (i.e. i and j) are used (one
 * at the beginning and one at the end) to "sandwich" the array. All the
 * elements at or in the left of position i is less than the pivot. All the
 * elements at or in the right of position j is greater than the pivot.
 * 
 * Then, two recursively calls are made to sort the left and right arrays.
 * 
 * @author Xi Chen
 * 
 */
public final class QuickSort {

	/**
	 * Prevent instantiation
	 */
	private QuickSort() {

	}

	/**
	 * Sort the specified array. The array must be comparable
	 * 
	 * @param a the array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		sort(a, 0, a.length - 1);
	}

	/**
	 * Sort the specified range array.
	 * 
	 * @param a the array to be sorted
	 * @param low low index of the array, inclusive, to be sorted
	 * @param high high index of the array, inclusive, to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] a, int low,
			int high) {
		if (low >= high) { // Base case - only 1 element
			return;
		}

		int i = low - 1; // All items at or in the left of i must < pivot
		int j = high; // All items at or in the right of j must > pivot

		int randomIdx = (int) ((high - low) * Math.random()) + low;
		swap(a, randomIdx, high);
		T pivot = a[high]; // pivot always choose the last index

		// Find the pivot position and assign it to i
		while (i < j) {
			do { // Increment i as long as a[i] < pivot
				i++;
			} while (a[i].compareTo(pivot) < 0);
			do { // Decrease j as long as a[j] > pivot
				j--;
			} while (a[j].compareTo(pivot) > 0 && j > i);
			if (i < j) { // Swap only if i is left to j
				swap(a, i, j);
			}
		}

		swap(a, i, high); // Swap pivot the the right position

		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}

	/**
	 * Swap two elements in an array based on the given two indices
	 * 
	 * @param idx1 the first index
	 * @param idx2 the second index
	 */
	public static <T extends Comparable<T>> void swap(T[] a, int idx1, int idx2) {
		T temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

}
