package org.exception.linkedlist;

public class NullListException extends RuntimeException{
    public NullListException(){
        super("LinkedList is null");
    }
}
