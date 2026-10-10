package day3.ads.java.Q1;

public class Circular_Queue implements CircularQueueOperations {
    
    private final int[] queueArray;
    private int front;
    private int rear;
    private int size; 
    private final int capacity;

   
    public Circular_Queue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[this.capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override 
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("   [Queue Overflow] Cannot enqueue " + value + ". The queue is full.");
            return false;
        }

        
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        size++;
        return true;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("   [Queue Underflow] Cannot dequeue. The queue is empty.");
            return -1;
        }

        int removedValue = queueArray[front];
        
        
        queueArray[front] = 0; 

        
        front = (front + 1) % capacity;
        size--;
        return removedValue;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("   [Queue Empty] Nothing to peek.");
            return -1;
        }
        return queueArray[front];
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("   Queue: [Empty]");
            return;
        }

        System.out.print("   Queue Elements (Front -> Rear): [");
        for (int i = 0; i < size; i++) {
            
            int actualIndex = (front + i) % capacity;
            System.out.print(queueArray[actualIndex]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] | Size: " + size + " | Front Index: " + front + " | Rear Index: " + rear);
    }
}
