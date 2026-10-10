package day3.ads.java.Q3;

	public class LinkedListQueue implements QueueOperations {
	    private static class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    private Node front; // Points to the first element of the queue
	    private Node rear;  // Points to the last element of the queue
	    private int size;   // Tracks the logical number of elements

	    // Constructor to initialize an empty queue
	    public LinkedListQueue() {
	        this.front = null;
	        this.rear = null;
	        this.size = 0;
	    }

	    @Override
	    public void enqueue(int value) {
	        Node newNode = new Node(value);
	        
	        if (isEmpty()) {
	            front = newNode;
	            rear = newNode;
	        } else {
	            
	            rear.next = newNode;
	            rear = newNode;
	        }
	        
	        size++;
	        System.out.println("   [Enqueue] Added " + value + " to the queue.");
	    }

	    @Override
	    public int dequeue() {
	        if (isEmpty()) {
	            throw new IllegalStateException("[Queue Underflow] Cannot dequeue from an empty queue.");
	        }
	        int dequeuedValue = front.data;
	        
	        front = front.next;
	        
	        if (front == null) {
	            rear = null;
	        }

	        size--;
	        return dequeuedValue;
	    }

	    @Override
	    public int peek() {
	        if (isEmpty()) {
	            throw new IllegalStateException("[Queue Empty] Nothing to peek.");
	        }
	        return front.data;
	    }

	    @Override
	    public boolean isEmpty() {
	        return front == null;
	    }

	    @Override
	    public void display() {
	        if (isEmpty()) {
	            System.out.println("   Queue: [Empty]");
	            return;
	        }

	        System.out.print("   Queue (Front -> Rear): ");
	        Node current = front;
	        while (current != null) {
	            System.out.print(current.data);
	            if (current.next != null) {
	                System.out.print(" -> ");
	            }
	            current = current.next;
	        }
	        System.out.println(" | Size: " + size);
	    }
}


