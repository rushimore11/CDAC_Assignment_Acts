package org.utility;

import java.io.Serializable;

public class Node<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.data = data;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Node<T> getNext() { return next; }
    public void setNext(Node<T> next) { this.next = next; }

    public Node<T> getPrevious() { return previous; }
    public void setPrevious(Node<T> previous) { this.previous = previous; }
}