package sorting;
public class HeapSorter {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
      
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int heapSize, int rootIdx) {
        int smallest = rootIdx;      
        int leftChild = 2 * rootIdx + 1;  
        int rightChild = 2 * rootIdx + 2; 
        if (leftChild < heapSize && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        if (smallest != rootIdx) {
            int swap = arr[rootIdx];
            arr[rootIdx] = arr[smallest];
            arr[smallest] = swap;

            heapify(arr, heapSize, smallest);
        }
    }
}
