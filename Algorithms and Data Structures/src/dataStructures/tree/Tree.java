package dataStructures.tree;

import java.util.Iterator;

public interface Tree<E extends Comparable<E>> {
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete (E e);
    
    public Iterator<E> iterator();
}
