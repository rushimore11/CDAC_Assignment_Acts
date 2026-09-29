
package org.utility;

public interface ManipulateList<T> {
    void add(T data);
    void delete(int index);
    void clear();
}