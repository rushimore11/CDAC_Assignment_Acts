package hashing;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void put(String key, int value) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; 
                return;
            }
            current = current.next;
        }
     
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
    }

    public Integer get(String key) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; 
    }

    public boolean remove(String key) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    head = current.next; 
                } else {
                    prev.next = current.next; 
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false; 
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.key + ": " + current.value + "] -> ");
            current = current.next;
        }
        System.out.print("null");
    }
}
