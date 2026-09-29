package org.utility;

public class LinkedList<T> {

    private Node<T> start;
    private Node<T> end;
    private Node<T> current;

    private int maxCount;


    // Constructor
    public LinkedList() {

        start = null;
        end = null;
        current = null;

        maxCount = 0;
    }




    public boolean addNode(T data) {

        if (data == null) {
            return false;
        }

        Node<T> newNode = new Node<>(data);

        // First node
        if (start == null) {

            start = newNode;
            end = newNode;
            current = newNode;

        }
        else {

            newNode.previous = end;
            end.next = newNode;

            end = newNode;
        }

        maxCount++;

        return true;
    }



    public T getFirst() {

        if (start == null) {
            return null;
        }

        current = start;

        return current.data;
    }




    public T getLast() {

        if (end == null) {
            return null;
        }

        current = end;

        return current.data;
    }




    public T getNext() {

        if (current == null) {
            return null;
        }

        if (current.next == null) {
            return null;
        }

        current = current.next;

        return current.data;
    }




    public T getPrevious() {

        if (current == null) {
            return null;
        }

        if (current.previous == null) {
            return null;
        }

        current = current.previous;

        return current.data;
    }




    public T getCurrent() {

        if (current == null) {
            return null;
        }

        return current.data;
    }


    public int size() {

        return maxCount;
    }




    public boolean isEmpty() {

        return start == null;
    }




    public boolean delete(int index) {

        if (start == null) {
            return false;
        }

        if (index < 0 || index >= maxCount) {
            return false;
        }

        Node<T> temp = start;

        // Move to required node
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }


        // Only one node
        if (start == end) {

            start = null;
            end = null;
            current = null;

        }

        // Delete first node
        else if (temp == start) {

            start = start.next;
            start.previous = null;

            current = start;
        }

        // Delete last node
        else if (temp == end) {

            end = end.previous;
            end.next = null;

            current = end;
        }

        // Delete middle node
        else {

            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;

            current = temp.next;
        }

        maxCount--;

        return true;
    }
}