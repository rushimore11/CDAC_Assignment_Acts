package org.ADS.DoublyLL;
public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
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

  
    public void delete(int element) {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == element) {
               
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null; 
                    }
                } 
                
                else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } 
               
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return; 
            }
            current = current.next;
        }
    }

    public void deleteAll(int element) {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node nextNode = current.next; 

            if (current.data == element) {
               
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } 
               
                else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } 
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = nextNode;
        }
    }
}
