package ADS.Q3;

public class Deque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Deque(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void addFront(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot add " + data + " at front.");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } 
        else if (front == 0) {
            front = capacity - 1;
        } 
       
        else {
            front--;
        }

        arr[front] = data;
        size++;
        System.out.println("Added to front: " + data);
    }
    public void addEnd(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot add " + data + " at end.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } 
        else if (rear == capacity - 1) {
            rear = 0;
        } 
        else {
            rear++;
        }

        arr[rear] = data;
        size++;
        System.out.println("Added to end: " + data);
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot delete from front.");
            return;
        }

        int removed = arr[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } 
        else if (front == capacity - 1) {
            front = 0;
        } 
        else {
            front++;
        }

        size--;
        System.out.println("Deleted from front: " + removed);
    }

    
    public void deleteEnd() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot delete from end.");
            return;
        }

        int removed = arr[rear];

        if (front == rear) {
            front = -1;
            rear = -1;
        } 
        else if (rear == 0) {
            rear = capacity - 1;
        } 
        else {
            rear--;
        }

        size--;
        System.out.println("Deleted from end: " + removed);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Current Deque: ");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
