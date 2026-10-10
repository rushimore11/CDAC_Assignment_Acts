package Day3.ads.java.Q3;
public class QueueTester {
    public static void main(String[] args) {
        System.out.println("=== Creating a Linked List Backed Queue ===");
        Queue<String> lineQueue = new LinkedQueueImp<>();

        System.out.println("\n--- Testing Enqueue Operations ---");
        lineQueue.add("Alice");
        lineQueue.add("Bob");
        lineQueue.add("Charlie");
        lineQueue.display();

        System.out.println("\n--- Testing Dequeue Operation ---");
        String removed = lineQueue.remove();
        System.out.println("Dequeued Element: " + removed);
        lineQueue.display();

        System.out.println("\n--- Testing Edge Clear Down ---");
        System.out.println("Dequeued Element: " + lineQueue.remove()); 
        System.out.println("Dequeued Element: " + lineQueue.remove());
        lineQueue.display();
    }
}
