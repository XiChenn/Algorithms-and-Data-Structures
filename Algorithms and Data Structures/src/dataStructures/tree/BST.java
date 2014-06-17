package dataStructures.tree;

/**
 * Binary search tree (BST) is a binary tree where every node is bigger than its left sub-tree,
 * and smaller than its right sub-tree and there is no duplicate nodes
 * <p/>
 * Created by xi on 6/11/14.
 */
public class BST<E extends Comparable<E>> {
    TreeNode<E> root; // The root of the BST
    int size; // The number of nodes in the BST

    // Searching for an element in a BST - similar to binary search
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) { // Less than the current node
                current = current.left;
            } else if (e.compareTo(current.element) > 0) { // Greater than the current node
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // Inserting an element into a BST - locate the parent of the new node
    public boolean insert(E e) {
        if (root == null) { // BST is empty
            root = new TreeNode<E>(e);
            return true;
        }

        TreeNode<E> parent = root, current = root;
        boolean isLess = true; // Is the new node less than the parent node
        while (current != null) {
            parent = current;
            if (isLess = e.compareTo(current.element) < 0) { // Less than the current node
                current = current.left;
            } else if (isLess = e.compareTo(current.element) > 0) { // Greater than the current node
                current = current.right;
            } else { // Duplicate node
                return false;
            }
        }

        // Attach the new node to the parent node
        if (isLess) {
            parent.left = new TreeNode<E>(e);
        } else {
            parent.right = new TreeNode<E>(e);
        }

        return true; // Element inserted
    }

    /*
     * Deleting an element from a BST - Consider the number of children (3
     * situations)
     */
    public boolean delete (E e) {
        TreeNode<E> deletePosistion = root;
        
        return false;
    }
    
}
