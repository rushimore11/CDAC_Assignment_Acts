package org.ADS.DoublyLL;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(7);
        list.insert(14);
        list.insert(7);
        list.insert(7);
        list.insert(21);
        list.insert(7);

        System.out.print("Initial Doubly Linked List: ");
        list.displayForward(); 
        System.out.println("\n--- Testing Search -");
        System.out.println("Is 21 present? " + list.search(21)); 
        System.out.println("Is 99 present? " + list.search(99)); 

  
        System.out.println("\n- Testing delete(7) [Removes first occurrence] --");
        list.delete(7);
        list.displayForward(); 

        System.out.println("\n- Testing deleteAll(7) [Removes all occurrences] --");
        list.deleteAll(7);
        list.displayForward(); 
    }
}
