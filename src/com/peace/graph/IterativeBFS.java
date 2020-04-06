package com.peace.graph;

import java.io.IOException;
import java.util.*;

class IterativeBFS {

    public void printBfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Node node = queue.poll();
                size--;

                System.out.println(node.value);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);

            }
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

        new IterativeBFS().printBfs(root);
    }
}