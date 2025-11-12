package Lab_4;

import java.util.LinkedList;
import java.util.Queue;

public class Symetric {
    static Node root;
    public static void main(String[] args) {

        Symetric tree = new Symetric();
        Integer[] values = { 1, 2,  2,3,null,null,3};
        Symetric.root = Symetric.buildTree(values);
        
        System.err.println(tree.isMirror(root.left, root.right));
    }

    public boolean isMirror(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        // if (left.left == null && left.right == null && right.left == null && right.right == null) {
        //     if (left.data != right.data) {
        //         return false;
        //     }
        //     return true;
        // }
        if ((left.left == null && right.right != null) || (left.right == null && right.left != null)
                || (left.left != null && right.right == null) || (left.right != null && right.left == null)) {
            return false;
        }
        if (left.data != right.data) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

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