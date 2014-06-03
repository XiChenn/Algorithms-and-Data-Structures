/**
 *
 */
package algorithms.sorting;

/**
 * A collection of sorting algorithms
 * 
 * @author Xi Chen
 * 
 */
public class QuickSort {

	/**
	 * QuickSort: in average, it runs in Theta(nlog n)
	 * 
	 * @param a
	 */
	public static <T extends Comparable<T>> void quickSort(T[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	/**
	 * 
	 * @param a
	 *            an Array
	 * @param low
	 *            low index of the array
	 * @param high
	 *            high index of the array
	 */
	public static <T extends Comparable<T>> void quickSort(T[] a, int low,
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
			if (i < j) {
				swap(a, i, j);
			}
		}
		
		swap(a, i, high);

		quickSort(a, low, i - 1);
		quickSort(a, i + 1, high);
	}

	/**
	 * Swap two elements in an array
	 * 
	 * @param a
	 *            is a reference to element a
	 * @param b
	 *            is a reference to element b
	 */
	public static <T extends Comparable<T>> void swap(T[] a, int idx1, int idx2) {
		T temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

}
