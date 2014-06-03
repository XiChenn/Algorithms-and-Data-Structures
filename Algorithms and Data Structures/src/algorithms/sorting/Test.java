package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Test {
	public static final int NUM = 100000;

	// Worked!
	public static void swap(int[] a, int[] b) {
		int temp = a[0];
		a[0] = b[0];
		b[0] = temp;
	}

	// Won't work!
	// Although Java manipulates objects 'by reference',
	// Java pass references to methods 'by value';
	// Also, Integer is immutable
	// Refer to
	// http://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html
	public static void swap(Integer a, Integer b) {
		Integer temp = a;
		a = b;
		b = temp;
	}

	// Verify the correctness of quickSort() implementation
	public static void testQuickSort() {
		Integer[] unsort1 = new Integer[NUM];
		Integer[] unsort2 = new Integer[NUM];
		for (int i = 0; i < NUM; i++) {
			unsort1[i] = new Random().nextInt(NUM);
			unsort2[i] = unsort1[i];
		}
		QuickSort.quickSort(unsort1);
		Arrays.sort(unsort2);

		for (int i = 0; i < NUM; i++) {
			if (unsort1[i].intValue() != unsort2[i].intValue()) {
				System.out.println(unsort1[i]);
				System.out.println(unsort2[i]);
				System.out.println("Wrong!!!");
				System.out.println("i = " + i);
				return;
			}
		}
		System.out.println("Passed!");
	}

	// Verify the correctness of quickSort() implementation
	public static void testQuickSort2() {
		Double[] unsort1 = new Double[NUM];
		Double[] unsort2 = new Double[NUM];
		for (int i = 0; i < NUM; i++) {
			unsort1[i] = NUM * new Random().nextDouble();
			unsort2[i] = unsort1[i];
		}
		QuickSort.quickSort(unsort1);
		Arrays.sort(unsort2);

		for (int i = 0; i < NUM; i++) {
			if ((unsort1[i].doubleValue() - unsort2[i].doubleValue()) > 10e-6) {
				System.out.println(unsort1[i]);
				System.out.println(unsort2[i]);
				System.out.println("Wrong!!!");
				System.out.println("i = " + i);
				return;
			}
		}
		System.out.println("Passed!");
	}

	public static void main(String[] args) {
		testQuickSort();
		testQuickSort2();
	}

}
