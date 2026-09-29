
package org.utility;

public interface TraverseList<T> {
    T getFirst();
    T getLast();
    T getPrevious();
    T getCurrent();
    T getNext();
    boolean hasNext();
    boolean hasPrevious();
}