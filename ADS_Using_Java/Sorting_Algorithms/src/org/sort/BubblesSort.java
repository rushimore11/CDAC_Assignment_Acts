package org.sort;

public class BubblesSort {
	public static void bubbleSort(int[] arr) {
		int count = 0;
		int n = arr.length;
		while (n > 1) {
			int left = 0;
			int swapCount = 0;
			while (left < (n - 1)) {
				count = count + 1;
				
				if (arr[left] < arr[left + 1]) {
					swapCount = swapCount + 1;
					int t = arr[left];
					arr[left] = arr[left + 1];
					arr[left + 1] = t;
				}
				left = left + 1;
			}
			if (swapCount == 0) {
				break;
			}
			n = n - 1;
		}
		System.out.println("Count = " + count);
	}
}
