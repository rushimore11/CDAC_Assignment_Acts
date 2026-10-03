package com.assignment.points;

public class MyLinkedList {

    private static class Node {
        Point data;
        Node next;

        Node(Point data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(Point point) {
        Node newNode = new Node(point);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public Point removeFirst() {
        if (head == null) {
            return null;
        }

        Point removedPoint = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return removedPoint;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}