package ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Build stack class atop of array
 * 
 * @author Xi Chen
 * 
 * @param <E>
 */

public class Stack<E> {
    // The actual array to store the elements of the stack
    private E[] element;
    
    // Initial size of the stack
    private static final int INIT_SIZE = 16;

    // Stack size
    private int size;
    
    /* 
     * push(E item) ensures the element array store always E type
     * Thus, it is safe to cast to E[] and ensure type safety
     * But the runtime type of the array will be always Object[] instead of E[]
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        element = (E[]) new Object[INIT_SIZE];
    }
    
    public void push(E item) {
        ensureCapacity();
        element[size++] = item;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E item = element[--size];
        element[size] = null; // Eliminate obsolete reference
        return item;
    }
    
    public int size() {
        return size;
    }
    
    private void ensureCapacity() {
        if (size == element.length) { // The array is full
            element = Arrays.copyOf(element, 2 * size + 1); // Double the array
        }
        
    }
}
