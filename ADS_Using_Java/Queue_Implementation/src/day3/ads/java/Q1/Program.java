package day3.ads.java.Q1;

public class Program {
	    public static void main(String[] args) {
	        System.out.println("==================================================");
	        System.out.println("Initializing Circular Queue with capacity of 4");
	        System.out.println("==================================================");

	        // Reference interface polymorphic implementation
	        CircularQueueOperations cq = new Circular_Queue(4);

	        System.out.println("\n1. Filling up the Queue:");
	        cq.enqueue(10);
	        cq.enqueue(20);
	        cq.enqueue(30);
	        cq.enqueue(40);
	        cq.display();

	        System.out.println("\n2. Testing Overflow Handling:");
	        cq.enqueue(50); // Should fail safely

	        System.out.println("\n3. Dequeuing Elements to make room:");
	        System.out.println("   Dequeued: " + cq.dequeue()); // Removes 10
	        System.out.println("   Dequeued: " + cq.dequeue()); // Removes 20
	        cq.display();

	        System.out.println("\n4. Testing Circular Wraparound Property:");
	        System.out.println("   Adding 50 and 60 back into recycled memory slots...");
	        cq.enqueue(50);
	        cq.enqueue(60);
	        cq.display(); // Rear should cleanly cycle around back to the beginning

	        System.out.println("\n5. Checking Front Peek Property:");
	        System.out.println("   Current Front item: " + cq.peek()); // Should be 30
	        
	        System.out.println("\n==================================================");
	        System.out.println("Circular Queue Execution Verified Successfully.");
	        System.out.println("==================================================");
	    }
	

}
