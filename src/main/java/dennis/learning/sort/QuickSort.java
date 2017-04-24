package dennis.learning.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String args[]) {
		QuickSort quickSort = new QuickSort();
		Integer[] arrayToSort = { 0, 5, 1, 2, 4, 3, 9, 8, 6, 7, 2 };
		quickSort.quickSort(arrayToSort, 0, arrayToSort.length - 1);
		System.out.println(Arrays.asList(arrayToSort));
		arrayToSort = new Integer[] {0,1,2,3,4,6,7,8,9};
		quickSort.quickSort(arrayToSort, 0, arrayToSort.length - 1);
		System.out.println(Arrays.asList(arrayToSort));
		arrayToSort = new Integer[] {9,8,7,6,5,4,3,2,1,0};
		quickSort.quickSort(arrayToSort, 0, arrayToSort.length - 1);
		System.out.println(Arrays.asList(arrayToSort));
	}

	public void quickSort(Integer[] arrayToSort, int low, int high) {
		int left = low;
		int right = high;
		int mid = low + (high - low) / 2;
		while (left <= right) {
			while (arrayToSort[left] < arrayToSort[mid]) {
				left++;
			}
			while (arrayToSort[right] > arrayToSort[mid]) {
				right--;
			}
			if (left <= right) {
				int temp = arrayToSort[left];
				arrayToSort[left] = arrayToSort[right];
				arrayToSort[right] = temp;
				left++;
				right--;
			}
			if (right >= low) {
				quickSort(arrayToSort, low, right);
			}
			if (left <= high) {
				quickSort(arrayToSort, left, high);
			}

		}
	}
}
