package day3.ads.java.Q1;

public interface CircularQueueOperations {
    boolean enqueue(int value);
    int dequeue(); 
    int peek();
    boolean isFull();
    boolean isEmpty();
    void display();
}
