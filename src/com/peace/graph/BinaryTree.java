package src.com.peace.graph;

class BinaryTree {
    class Node {
        int value;
        Node left = null;
        Node right = null;
    }

    void printTreeDir(Node root, StringBuilder buffer, String prefix, String acumulator) {
        if (root == null)
            return;

        buffer.append(prefix);
        buffer.append(root.value);
        buffer.append('\n');

        // since it is binary tree, or you have only left, or right, or both

        // node, buffer, next prefix, next acumulador
        if (root.right == null) {
            // print left with └──
            printTreeDir(root.left, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        } else if (root.left == null) {
            // print right with └──
            printTreeDir(root.right, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        } else {
            // print left with ├── and right with └──
            printTreeDir(root.left, buffer, acumulator + "├──", acumulator + "│   "); // if has more kids
            printTreeDir(root.right, buffer, acumulator + "└──", acumulator + "    "); // if node is the last kid
        }
    }

    void recursiveDfs(Node root) {
        if (root == null)
            return;

        // in order L N R
        recursiveDfs(root.left);
        System.out.print(root.value + ", ");
        recursiveDfs(root.right);
    }

    int getHeight(Node root) {
        if (root == null)
            return 0;

        int ls = getHeight(root.left);
        int rs = getHeight(root.right);

        return 1 + Math.max(ls, rs);
    }

    public static void main(String args[]) {
        /*
         * 100 200 300 400 500 600 700
         */
        BinaryTree bt = new BinaryTree();
        Node n1 = bt.new Node();
        Node n2 = bt.new Node();
        Node n3 = bt.new Node();
        Node n4 = bt.new Node();
        Node n5 = bt.new Node();
        Node n6 = bt.new Node();
        Node n7 = bt.new Node();
        Node n8 = bt.new Node();
        n1.value = 100;
        n2.value = 200;
        n3.value = 300;
        n4.value = 400;
        n5.value = 500;
        n6.value = 600;
        n7.value = 700;
        n8.value = 800;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        //n7.right = n8;

        bt.recursiveDfs(n1);

        StringBuilder sb = new StringBuilder(50);
        bt.printTreeDir(n1, sb, "", "");
        System.out.println(sb.toString());

        int h = bt.getHeight(n1);
        System.out.println("Deepth: " + h);
    }
}