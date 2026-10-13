package org.ADS.CircularDoublyLL;

public class CircularDoublyLinkedList {
    private Node head;

    public CircularDoublyLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node tail = head.prev; 
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head: " + head.data + ")");
    }

  
    public boolean search(int element) {
        if (head == null) {
            return false;
        }

        Node current = head;
        do {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    public void delete(int element) {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            if (current.data == element) {
                
                if (current.next == head && current.prev == head) {
                    head = null;
                } 
              
                else {
                    if (current == head) {
                        head = head.next; 
                    }
                 
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

  
    public void deleteAll(int element) {
        if (head == null) {
            return;
        }

        Node current = head;
        Node tailMarker = head.prev; 
        boolean headChanged = false;

        do {
            Node nextNode = current.next;

            if (current.data == element) {
              
                if (current.next == head && current.prev == head) {
                    head = null;
                    return; 
                }

                if (current == head) {
                    head = head.next;
                    headChanged = true;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;
            }

            if (current == tailMarker) {
                break;
            }

            current = nextNode;
        } while (head != null && (headChanged || current != head));
    }
}
