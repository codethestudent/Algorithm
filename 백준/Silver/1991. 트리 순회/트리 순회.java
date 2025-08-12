import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                String[] arr = br.readLine().split(" ");
                String root = arr[0];
                String left = arr[1];
                String right = arr[2];

                Node rootNode = null;
                if (!".".equals(root) && nodes.get(root) == null) {
                    rootNode = new Node(root);
                    nodes.put(root, rootNode);
                } else {
                    rootNode = nodes.get(root);
                }

                Node leftNode = null;
                if (!".".equals(left) && nodes.get(left) == null) {
                    leftNode = new Node(left);
                    nodes.put(left, leftNode);
                } else {
                    leftNode = nodes.get(left);
                }

                Node rightNode = null;
                if (!".".equals(right) && nodes.get(right) == null) {
                    rightNode = new Node(right);
                    nodes.put(right, rightNode);
                } else {
                    rightNode = nodes.get(right);
                }

                if (rootNode != null && leftNode != null) {
                    leftNode.parent = rootNode;
                    rootNode.left = leftNode;
                }

                if (rootNode != null && rightNode != null) {
                    rightNode.parent = rootNode;
                    rootNode.right = rightNode;
                }

            }
        }

        // for (Map.Entry<String, Node> entry : nodes.entrySet()) {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }

        preOrder(nodes.get("A"));
        System.out.println(preSb);
        inOrder(nodes.get("A"));
        System.out.println(inSb);
        postOrder(nodes.get("A"));
        System.out.println(postSb);
    }

    private static StringBuilder preSb = new StringBuilder();
    private static StringBuilder inSb = new StringBuilder();
    private static StringBuilder postSb = new StringBuilder();

    // root -> left -> right
    private static void preOrder(Node node) {
        preSb.append(node.id);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    // left -> root -> right
    private static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        inSb.append(node.id);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    // left -> right -> root
    private static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }

        postSb.append(node.id);
    }

    public static class Node {
        String id;
        Node parent;
        Node left;
        Node right;

        public Node(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "id: " + id
                    + " parent : " + (parent == null ? null : parent.id)
                    + " left : " + (left == null ? null : left.id)
                    + ", right : " + (right == null ? null : right.id);
        }
    }
}
