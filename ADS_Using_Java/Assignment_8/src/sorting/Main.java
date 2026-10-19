package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       
        HeapSorter sorter = new HeapSorter();
       
        int[] data = {19, 3, 42, 12, 8, 0, 75, 5};
        
        System.out.println("Original Array:      " + Arrays.toString(data));
       
        sorter.heapSort(data);
        
        System.out.println("Sorted (Descending): " + Arrays.toString(data));
    }
}
