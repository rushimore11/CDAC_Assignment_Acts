package org.sort;

public class ArrayCheck {
	public static boolean isArraySorted(int[] arr) {
		int left = 0;
		while (left < (arr.length - 1)) {
			if (arr[left] < arr[left + 1]) {
				return false;
			}
			left = left + 1;
		}
		return true;
	}
}