package com.peace.graph;

import java.util.*;

/*

        Given a binary tree root node
        Do a iterative dfs in-order, pre-order and post-order
*/

class RecursiveDFS {

    /*
        In order traverse the binary tree by going deepth to left
    */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /*
        Pre order walking
    */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
        Post order walking
    */
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        // declare and init input
        Node root = new Node(9);
        root.left = new Node(8);
        root.right = new Node(10);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(11);
        root.right.right = new Node(12);

        /*
         * 9 8 10 7 6 11 12
         */

        new RecursiveDFS().postOrder(root);
    }
}