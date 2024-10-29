public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        RedBlackTree rbt = new RedBlackTree();
        AVLTree avl = new AVLTree();

        // Testing Binary Search Tree (BST)
        System.out.println("Testing BST:");
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(25);
        bst.inorder();
        System.out.println("Query 10 in BST: " + bst.query(10));
        bst.delete(10);
        bst.inorder();

        // Testing Red-Black Tree (RBT)
        System.out.println("\nTesting Red-Black Tree:");
        rbt.insert(15);
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(25);
        rbt.inorder();
        System.out.println("Query 10 in RBT: " + rbt.query(10));

        rbt.delete(10);
        System.out.println("After deleting 10:");
        rbt.inorder();
        System.out.println("Query 10 in RBT after deletion: " + rbt.query(10));

        // Testing AVL Tree
        System.out.println("\nTesting AVL Tree:");
        avl.insert(15);
        avl.insert(10);
        avl.insert(20);
        avl.insert(25);
        avl.inorder();
        System.out.println("Query 10 in AVL: " + avl.query(10));
        avl.delete(10);
        System.out.println("After deleting 10:");
        avl.inorder();
    }
}
