package com.peace.graph;


import com.peace.graph.BinaryTreePrinter;

/*
A binary tree with the BFS property
All right children nodes must be bigger than parent
All left children nodes must be smaller or equal parent
*/
public class BFS {

    Node root = null;

    BFS() {

    }

    void add(int v) {
        if (root == null) {
            root = new Node(v);
        } else {
            Node node = new Node(v);

            // walk down
            Node walker = root;
            while (walker != null) {
                if (v > root.value) {
                    if (walker.right != null) {
                        walker = walker.right;
                    } else {
                        break;
                    }
                } else {
                    if (walker.left != null) {
                        walker = walker.left;
                    } else {
                        break;
                    }
                }
            }

            // check which branch insert
            if (v > walker.value) {
                walker.right = node;
            } else {
                walker.left = node;
            }
        }
    }

    void printTreeDir(Node root, StringBuilder buffer, String prefix, String acumulator) {
        if (root == null)
            return;

        buffer.append(prefix);
        buffer.append(root.value);
        buffer.append('\n');

        if (root.right == null) {
            printTreeDir(root.left, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        } else if (root.left == null) {
            printTreeDir(root.right, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        } else {
            printTreeDir(root.left, buffer, acumulator + "├──", acumulator + "│   "); // if has more kids
            printTreeDir(root.right, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        }
    }

    void printTreeDir() {
        StringBuilder sb = new StringBuilder(50);
        this.printTreeDir(this.root, sb, "", "");
        System.out.println(sb.toString());
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.add(50);
        bfs.add(25);
        bfs.add(75);
        bfs.add(65);
        bfs.add(64);
        bfs.add(66);
        
        BinaryTreePrinter.print(bfs.root);

        bfs.printInOrder(bfs.root);
    }
}