package day2.ads.java.Q4;

import day2.ads.java.Q3.EmptyQueueException;
import day2.ads.java.Q4.Queue;

public class QueueArrayImp <T>implements Queue <T>{

    private T[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Default constructor setting up a standard baseline size
    public QueueArrayImp() {
        this(5); 
    }

    // Overloaded constructor allowing explicit size declaration
    public QueueArrayImp(int capacity) {
        this.capacity = capacity;
        this.elements =  (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full! Cannot add element.");
        }
        
        // Circularly advance the rear index pointer
        rear = (rear + 1) % capacity;
        elements[rear] = element;
        size++;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            // Throwing your domain exception pattern explicitly
            throw new EmptyQueueException("Queue is empty! Cannot remove element.");
        }
        
        T removedElement = elements[front];
        elements[front] = null; // Prevent stale element memory reference leak
        
        // Circularly advance the front index pointer
        front = (front + 1) % capacity;
        size--;
        
        return removedElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty! Cannot peek.");
        }
        return elements[front];
    }

    @Override
    public boolean isContains(Object element) {
        if (isEmpty()) {
            return false;
        }

        // Iterate sequentially over active slots from Front up to the current count size
        for (int i = 0; i < size; i++) {
            int currentActualIndex = (front + i) % capacity;
            
            // Check null safety scenarios safely
            if (element == null) {
                if (elements[currentActualIndex] == null) {
                    return true;
                }
            } else if (element.equals(elements[currentActualIndex])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
