package org.bst.operations;
import java.util.Arrays;
public class ArrayOperations {

    public boolean findUsingLinearSearch(int[] arr, int element) {
        if (arr == null) {
            return false;
        }

        for (int num : arr) {
            if (num == element) {
                return true; 
            }
        } 
        
        return false; 
    } 

    public boolean findUsingBinarySearch(int[] arr, int element) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedArr[mid] == element) {
                return true; 
            } else if (sortedArr[mid] < element) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        } 

        return false; 
    } 

} 

