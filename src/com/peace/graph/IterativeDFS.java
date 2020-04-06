package com.peace.graph;

import java.util.*;

/*

        Given a binary tree root node
        Do a iterative dfs in-order, pre-order and post-order
*/

class IterativeDFS {

    /*
        Post order using 2 stacks
    */
    public void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> out = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            out.push(node);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }

        while (!out.isEmpty()) {
            System.out.println(out.pop().value);
        }
    }

    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null)
                stack.push(node.left);

        }
    }

    /*
     * In order traverse the binary tree by going deepth to left,
     */
    public void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        // while stack has elements
        while (curr != null || stack.size() > 0) {
            // walk to the deep left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // pop last
            curr = stack.pop();
            System.out.println(curr.value);

            // walk to right if possible
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
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

        new IterativeDFS().postOrder(root);
    }
}