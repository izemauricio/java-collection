package com.peace.graph;

public class IsBinaryTree {

    /**
     * Go down from root checking if substree is BST Tree is BST if all left nodes
     * are less than root And all right nodes are bigger than root
     */
    public boolean check(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return check(root.left, min, root.value) && check(root.right, root.value, max);
    }

    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(150);
        root.left.left = new Node(25);
        root.left.right = new Node(75); // 75 is left 
        root.right.left = new Node(125);
        root.right.right = new Node(175);

        boolean b = new IsBinaryTree().check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(b);
    }
}