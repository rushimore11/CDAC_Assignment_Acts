
package org.exception.linkedlist;

public class NullDataException extends LinkedListException {
    public NullDataException() {
        super("Data cannot be null");
    }
    public NullDataException(String message) {
        super(message);
    }
}