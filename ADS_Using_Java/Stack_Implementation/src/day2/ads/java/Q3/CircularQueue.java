package day2.ads.java.Q3;

public class CircularQueue implements Queue {
    int front;
    int rear;
    int SIZE;
    int[] queue;

    public CircularQueue(int capacity) {
        SIZE = capacity;
        rear = -1;
        front = -1;
        queue = new int[SIZE];
    }

    @Override
    public void add(int element) {
        if (isFull()) {
            throw new QueueOutOfBoundsException();
        }
        
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % SIZE;
        queue[rear] = element;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        int temp = queue[front];
        

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("queue is empty");
        }
        return queue[front];
    }

    @Override
    public boolean isContains(int element) {
        if (isEmpty()) {
            return false;
        }
        
        int i = front;
        while (true) {
            if (queue[i] == element) {
                return true;
            }
            if (i == rear) {
                break;
            }
            i = (i + 1) % SIZE;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % SIZE == front;
    }
}
