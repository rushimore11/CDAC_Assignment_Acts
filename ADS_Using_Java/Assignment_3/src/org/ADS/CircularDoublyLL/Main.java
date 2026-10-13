package org.ADS.CircularDoublyLL;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(9);
        list.insert(18);
        list.insert(9);
        list.insert(9);
        list.insert(27);
        list.insert(9);

        System.out.print("Initial Circular Doubly Linked List: ");
        list.display();
        System.out.println("\n--- Testing Search ---");
        System.out.println("Is 27 present? " + list.search(27)); 
        System.out.println("Is 99 present? " + list.search(99)); 

        System.out.println("\n--- Testing delete(9) [Removes first occurrence] ---");
        list.delete(9);
        list.display(); 
        
        System.out.println("\n--- Testing deleteAll(9) [Removes all occurrences] ---");
        list.deleteAll(9);
        list.display(); 
    }
}
