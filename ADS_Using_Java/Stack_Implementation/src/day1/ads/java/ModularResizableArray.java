package day1.ads.java;

import java.util.Arrays;

public class ModularResizableArray implements CustomArrayOperations {
    private int[] dataArray;
    private int logicalSize; 
    private int physicalCapacity;

    public ModularResizableArray(int initialCapacity) {
        this.physicalCapacity = initialCapacity > 0 ? initialCapacity : 4;
        this.dataArray = new int[this.physicalCapacity];
        this.logicalSize = 0;
    }

    @Override
    public void resize() {
        this.physicalCapacity = this.physicalCapacity * 2;
        int[] expandedArray = new int[this.physicalCapacity];
        

        System.arraycopy(this.dataArray, 0, expandedArray, 0, this.logicalSize);
        this.dataArray = expandedArray;
        System.out.println("   [Resize Module Triggered] Expanded Capacity to: " + this.physicalCapacity);
    }

    @Override
    public void insert(int index, int value) {
       
        if (index < 0 || index > logicalSize) {
            throw new IndexOutOfBoundsException("Index " + index + " out of valid logical size limits.");
        }        
        if (this.logicalSize == this.physicalCapacity) {
            resize();
        }

        for (int i = this.logicalSize; i > index; i--) {
            this.dataArray[i] = this.dataArray[i - 1];
        }
        this.dataArray[index] = value;
        this.logicalSize++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= logicalSize) {
            throw new IndexOutOfBoundsException("Index " + index + " contains no valid active elements.");
        }
        for (int i = index; i < this.logicalSize - 1; i++) {
            this.dataArray[i] = this.dataArray[i + 1];
        }
        this.dataArray[this.logicalSize - 1] = 0;

        this.logicalSize--;
    }

    @Override
    public void display() {
        int[] logicalSnapshot = Arrays.copyOf(this.dataArray, this.logicalSize);
        System.out.println("   Elements: " + Arrays.toString(logicalSnapshot) + 
                           " | Logical Size: " + this.logicalSize + 
                           " | Physical Capacity: " + this.physicalCapacity);
    }

    @Override
    public int getLogicalSize() {
        return this.logicalSize;
    }
}
