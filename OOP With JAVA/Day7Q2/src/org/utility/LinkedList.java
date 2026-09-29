
package org.utility;

import org.exception.linkedlist.NullDataException;
import org.exception.linkedlist.NullListException;
import org.exception.linkedlist.NullNodeException;

import java.io.Serializable;

import org.exception.linkedlist.NotFoundException;

public class LinkedList<T> implements ManipulateList<T>, TraverseList<T>, Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7786829353334541009L;
	private Node<T> start;
    private Node<T> end;
    private Node<T> current;
    private int maxCount;

    public LinkedList() {
        this.start = null;
        this.end = null;
        this.current = null;
        this.maxCount = 0;
    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new NullDataException();
        }

        Node<T> newNode = new Node<>(data);

        if (start == null) {
            start = newNode;
            end = newNode;
            current = newNode;
        } else {
            newNode.setPrevious(end);
            end.setNext(newNode);
            end = newNode;
        }

        maxCount++;
    }

    @Override
    public T getFirst() {
        if (start == null) {
            throw new NullListException();
        }
        current = start;
        return current.getData();
    }

    @Override
    public T getLast() {
        if (end == null) {
            throw new NullListException();
        }
        current = end;
        return current.getData();
    }

    @Override
    public T getNext() {
        if (current == null || current.getNext() == null) {
            throw new NullNodeException("No next element available");
        }
        current = current.getNext();
        return current.getData();
    }

    @Override
    public T getPrevious() {
        if (current == null || current.getPrevious() == null) {
            throw new NullNodeException("No previous element available");
        }
        current = current.getPrevious();
        return current.getData();
    }

    @Override
    public T getCurrent() {
        if (current == null) {
            throw new NullNodeException("No current element available");
        }
        return current.getData();
    }

    @Override
    public boolean hasNext() {
        return current != null && current.getNext() != null;
    }

    @Override
    public boolean hasPrevious() {
        return current != null && current.getPrevious() != null;
    }

    public int size() {
        return maxCount;
    }

    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public void clear() {
        start = null;
        end = null;
        current = null;
        maxCount = 0;
    }

    @Override
    public void delete(int index) {
        if (start == null) {
            throw new NullListException();
        }

        if (index < 0 || index >= maxCount) {
            throw new NotFoundException("Index: " + index + " is out of bounds");
        }

        Node<T> temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        if (start == end) {
            start = null;
            end = null;
            current = null;
        } else if (temp == start) {
            start = start.getNext();
            start.setPrevious(null);
            current = start;
        } else if (temp == end) {
            end = end.getPrevious();
            end.setNext(null);
            current = end;
        } else {
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
            current = temp.getNext();
        }

        maxCount--;
    }
    public void sort(boolean ascending) {
        if (start == null || start.getNext() == null) {
            return; // 0 or 1 element, already sorted
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = start;

            while (current.getNext() != null) {
                Node<T> nextNode = current.getNext();
                
                @SuppressWarnings("unchecked")
                Comparable<T> currentData = (Comparable<T>) current.getData();
                int comparison = currentData.compareTo(nextNode.getData());

                if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
                    // Swap data values
                    T temp = current.getData();
                    current.setData(nextNode.getData());
                    nextNode.setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
        
        // Reset navigation pointer
        this.current = start;
    }
}