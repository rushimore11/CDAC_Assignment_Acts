package ADS.Q2;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();   
        
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        System.out.print("Original List: ");
        list.printList();
        list.pairwiseSwap();
        System.out.print("After Pairwise Swap: ");
        list.printList();
    }
}
