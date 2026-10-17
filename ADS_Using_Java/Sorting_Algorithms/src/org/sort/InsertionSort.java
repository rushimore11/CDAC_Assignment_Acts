package org.sort;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int count = 0;
		int sortedSize = 1;
		while (sortedSize < arr.length) {
			int insertElement = arr[sortedSize];
			int i = sortedSize - 1;
			while (i >= 0) {
				count = count + 1;
				
				if (arr[i] < insertElement) {
					arr[i + 1] = arr[i];
				} else {
					break;
				}
				i = i - 1;
			}
			arr[i + 1] = insertElement;
			sortedSize = sortedSize + 1;
		}
		System.out.println("Count = " + count);
	}
}