package dataStructures.tree;

/**
 * Created by xi on 6/11/14.
 */
public class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> parent; // Each node points to its parent node

    public TreeNode(E e) {
        element = e;
    }
}
