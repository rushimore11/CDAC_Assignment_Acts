package org.ADS.SinglyLL;
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(5);
        list.insert(12);
        list.insert(5);
        list.insert(5);
        list.insert(23);
        list.insert(5);

        System.out.print("Initial List: ");
        list.display();
        System.out.println("\n Testing Search --");
        System.out.println("Is 23 in the list? " + list.search(23));
        System.out.println("Is 99 in the list? " + list.search(99)); 

        System.out.println("\n-Testing delete(5) [Removes first occurrence]---");
        list.delete(5);
        list.display();
        System.out.println("\n-- Testing deleteAll(5) [Removes all remaining] ---");
        list.deleteAll(5);
        list.display(); 
    }
}

