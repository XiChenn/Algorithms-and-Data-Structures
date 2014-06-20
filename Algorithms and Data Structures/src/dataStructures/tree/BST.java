package dataStructures.tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Binary search tree (BST) is a binary tree where every node is bigger than its left sub-tree,
 * and smaller than its right sub-tree and there is no duplicate nodes
 * <p/>
 * Created by xi on 6/11/14.
 */
public class BST<E extends Comparable<E>> implements Tree<E> {
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
            size++;
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

        size++;
        return true; // Element inserted
    }

    /*
     * Deleting an element from a BST; Return true if deleted successfully,
     * false if the element is not in the tree.
     * 
     * Case 1: the node to be deleted has no left child - attache the node's
     * right child (can be null) to its parent's right or left branch.
     * 
     * Case 2: the node to be deleted has left child - find the node with the
     * greatest value (either right-most in its left substree, or left child).
     * Replace the node to be deleted with the element with the greatest value,
     * then delete the greatest value node
     */
    public boolean delete (E e) {
        TreeNode<E> current = root; // Points to the node to be deleted
        TreeNode<E> parent = null;  // The parent node of "current"
        
        // Locate the position
        while (current != null) {
            if (e.compareTo(current.element) < 0) { // Less than
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else { // Find the right position
                break;
            }
        }
        
        if (current == null) { // Either an empty BST or the element not in BST
            return false;
        }
        
        // Case 1: current has no left child
        if (current.left == null) {
            if (parent == null) { // Current points to root, delete root node
                root = current.right;
            } else {
                if (current.element.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }           
        } else { // Case 2: current has a left child
            TreeNode<E> rightMost = current.left;  // Points to the greatest value
            TreeNode<E> rightMostParent = current; // Parent node
            while (rightMost.right != null) { // Find the rightMost node
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element; // Replace the value
            if (rightMost == current.left) { // No right node in the left subtree
                rightMostParent.left = rightMost.left; // Delete rightMost node
            } else {
                rightMostParent.right = rightMost.left; // Delete rightMost node
            }           
        }
         
        size--;
        return true;
    }

    public Iterator<E> iterator() {
        return new InorderIterator();
    }
    
    // Inner class - using inorder to traverse the BST
    public class InorderIterator implements Iterator<E> {
        // Store element in a list
        private ArrayList<E> list = new ArrayList<E>();
        private int current = 0; // Current index in the list
        
        public InorderIterator() {
            inorder(root);
        }
        
        public void inorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }           
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }
        
        public boolean hasNext() {
            return current < list.size();
        }

        public E next() {
            return list.get(current++);
        }

        public void remove() {
            delete(list.get(current)); // Remove the current element
            list.clear();
            inorder(root); // Reconstruct the list
        }
    }
}
