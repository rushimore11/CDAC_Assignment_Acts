package Day3.ads.java.Q3;



import java.util.NoSuchElementException;

import Day3.ads.java.Q2.SinglyLinkedList;

public class LinkedQueueImp<T> implements Queue<T> {
    
  
    private final SinglyLinkedList<T> internalList;

    public LinkedQueueImp() {
        this.internalList = new SinglyLinkedList<>();
    }

    @Override
    public void add(T element) {
       
        internalList.addEnd(element);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow! Cannot remove from an empty queue.");
        }
        
        return internalList.deleteFront();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public void display() {
        System.out.print("Queue State (Front -> Rear): ");
        internalList.display();
        System.out.println();
    }
}
