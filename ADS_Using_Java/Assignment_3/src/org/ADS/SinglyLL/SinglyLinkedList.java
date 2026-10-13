package org.ADS.SinglyLL;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

 
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

   
    public void delete(int element) {
        if (head == null) {
            return; 
        }

        if (head.data == element) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next; 
                return;
            }
            current = current.next;
        }
    }

    public void deleteAll(int element) {
        while (head != null && head.data == element) {
            head = head.next;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }
    }

    public boolean search(int element) {
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                return true; 
            }
            current = current.next;
        }
        return false; 
    }
}
