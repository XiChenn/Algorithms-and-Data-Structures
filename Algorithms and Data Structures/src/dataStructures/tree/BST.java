package dataStructures.tree;

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
        TreeNode<E> deletePosistion = null, current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) { // Less than
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                deletePosistion = current;
            }
        }
        
        if (deletePosistion == null) { // Didn't find the right position to delete
            return false;
        }
        
        // deletePosistion is a leaf, delete directly
        if (deletePosistion.left == null && deletePosistion.right == null) {
            deletePosistion.parent = null;
        } else if (deletePosistion.left != null
                && deletePosistion.right != null) { // deletePosistion has two
                                                    // children
            TreeNode<E> leftBiggestNode = null;
            current = deletePosistion.left;
            while (current != null) {
                leftBiggestNode = current;
                current = current.right;
            }
            
            // Swap leftBiggestNode with deletePosistion
            leftBiggestNode.left = deletePosistion.left;
            deletePosistion.right = deletePosistion.right;
            // deletePosistion is the left child of parent
            if (deletePosistion.element
                    .compareTo(deletePosistion.parent.element) < 0) {
                deletePosistion.parent.left = leftBiggestNode;
            } else { // deletePosistion is the right child of parent
                deletePosistion.parent.right = leftBiggestNode;
            }
            deletePosistion.left = null;
            deletePosistion.right = null;
            
        } else { // deletePosistion has one child
            boolean isLeftChild = deletePosistion.left == null;
            
            // deletePosistion is the left child of parent
            if (deletePosistion.element
                    .compareTo(deletePosistion.parent.element) < 0) {
                if (isLeftChild) {
                    deletePosistion.parent.left = deletePosistion.left;
                } else {
                    deletePosistion.parent.left = deletePosistion.right;
                }
            } else { // deletePosistion is the right child of parent
                if (isLeftChild) {
                    deletePosistion.parent.right = deletePosistion.left;
                } else {
                    deletePosistion.parent.right = deletePosistion.right;
                }
            }
        }
          
        return true;
    }
    
}
