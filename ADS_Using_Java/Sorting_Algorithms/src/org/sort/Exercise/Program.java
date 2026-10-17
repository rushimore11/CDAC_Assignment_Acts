package org.sort.Exercise;

import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
	
		// Test Bubble Sort
		int[] bubbleSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Bubble sort before sorting: " + Arrays.toString(bubbleSortArr));
		BubblesSort.bubbleSort(bubbleSortArr);
		System.out.println("Bubble sort after sorting:  " + Arrays.toString(bubbleSortArr));
		System.out.println("----------------------------------------");

		// Test Insertion Sort
		int[] insertionSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Insertion sort before sorting: " + Arrays.toString(insertionSortArr));
		InsertionSort.insertionSort(insertionSortArr);
		System.out.println("Insertion sort after sorting:  " + Arrays.toString(insertionSortArr));
		System.out.println("----------------------------------------");

		// Test Quick Sort
		int[] quickSortArr = {5, 1, 9, 3, 7, 2};
		System.out.println("Quick sort before sorting: " + Arrays.toString(quickSortArr));
		QuickSort.quickSort(quickSortArr);
		System.out.println("Quick sort after sorting:  " + Arrays.toString(quickSortArr));
	}
}