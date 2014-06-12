package dataStructures.tree;

/**
 * Binary search tree (BST) is a binary tree where every node is bigger than its left sub-tree,
 * and smaller than its right sub-tree
 * <p/>
 * Created by xi on 6/11/14.
 */
public class BST<E extends Comparable<E>> {
    TreeNode<E> root;

    // Searching for an element in a BST - similar to binary search
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) { // less than the current node
                current = current.left;
            } else if (e.compareTo(current.element) > 0) { // Greater than the current node
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // Inserting an element into a BST
    public boolean insert(E e) {
        // TODO
        return true;
    }
}
