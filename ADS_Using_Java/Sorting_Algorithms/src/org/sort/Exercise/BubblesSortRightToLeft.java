package org.sort.Exercise;

public class BubblesSortRightToLeft {
	public static void bubbleSort(int[] arr) {
		int count = 0;
		int n = arr.length;
		int bottom = 0;
		
		while (bottom < n - 1) {
			int right = n - 1;
			int swapCount = 0;
			
			while (right > bottom) {
				count = count + 1;
				if (arr[right] > arr[right - 1]) {
					swapCount = swapCount + 1;
					int t = arr[right];
					arr[right] = arr[right - 1];
					arr[right - 1] = t;
				}
				right = right - 1;
			}
			
			if (swapCount == 0) {
				break;
			}
			bottom = bottom + 1;
		}
		System.out.println("Count = " + count);
	}
}
