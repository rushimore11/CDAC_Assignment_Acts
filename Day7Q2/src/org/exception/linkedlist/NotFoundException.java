
package org.exception.linkedlist;

public class NotFoundException extends LinkedListException {
    public NotFoundException() {
        super("Index not found in list");
    }
    public NotFoundException(String message) {
        super(message);
    }
}