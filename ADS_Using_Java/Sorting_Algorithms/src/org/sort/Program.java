package org.sort;

import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
		
		int[] checkArr1 = {10, 8, 6, 4, 2, 0};
		int[] checkArr2 = {2, 10, 6, 8, 0, 4};
		System.out.println("Is checkArr1 sorted descending? " + ArrayCheck.isArraySorted(checkArr1));
		System.out.println("Is checkArr2 sorted descending? " + ArrayCheck.isArraySorted(checkArr2));
		System.out.println("----------------------------------------");

		
		int[] bubbleSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Bubble sort before sorting: " + Arrays.toString(bubbleSortArr));
		BubblesSort.bubbleSort(bubbleSortArr);
		System.out.println("Bubble sort after sorting:  " + Arrays.toString(bubbleSortArr));
		System.out.println("----------------------------------------");

		
		int[] insertionSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Insertion sort before sorting: " + Arrays.toString(insertionSortArr));
		InsertionSort.insertionSort(insertionSortArr);
		System.out.println("Insertion sort after sorting:  " + Arrays.toString(insertionSortArr));
		System.out.println("----------------------------------------");

	
		int[] quickSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Quick sort before sorting: " + Arrays.toString(quickSortArr));
		QuickSort.quickSort(quickSortArr);
		System.out.println("Quick sort after sorting:  " + Arrays.toString(quickSortArr));
	}
}