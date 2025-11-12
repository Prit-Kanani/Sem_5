package Lab_5;

import java.util.LinkedList;
import java.util.Queue;

public class Max_len {

    static Node root;

    public static void main(String[] args) {

        Max_len tree = new Max_len();
        Integer[] values = { 3, 9, 20, null, null, 15, 7 };
        Max_len.root = Max_len.buildTree(values);
        int max = tree.len(Max_len.root, 0);
        System.err.println("The maximum depth is : " + max);

    }

    //Max depth and leaf Node
    public int len(Node node, int x) {
        if (node == null) {
            return x;
        }
        if (node.left == null && node.right == null) {
            System.err.println("The leaf node is : " + node.data + "\n");
        }
        return Math.max(
                len(node.left, x++), len(node.right, x++));
    }

    // Create a tree
    public static Node buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null)
            return null;

        root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            Node current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new Node(values[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new Node(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
