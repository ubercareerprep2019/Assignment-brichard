package Assignments.Part2_2;

public class BinarySearchTree {
    private Node root;

    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to insert.
     */
    private void insert(int key) {
        Node newNode = new Node(key);
        Node current = root;
        insert(current, newNode);
    }

    private Node insert(Node current, Node toInsert) {
        if (current == null) {
            return toInsert;
        }

        if (toInsert.key >= current.key) {
            current.right = insert(current.right, toInsert);
        } else if (toInsert.key <= current.key) {
            current.left = insert(current.left, toInsert);
        }

        return current;
    }

    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to check for.
     * @return true if the key is present in this binary search tree, false otherwise.
     */
    public boolean find(int key) {
        Node current = root;
        while (current != null) {
            if (key > current.key) {
                current = current.right;
            } else if (key < current.key) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        Node(int key) {
            this.key = key;
        }

        Node() {}

        public int key;
        public Node left;
        public Node right;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node rootNode = new Node(16);
        Node l1 = new Node(10);
        Node r1 = new Node(21);
        rootNode.left = l1;
        rootNode.right = r1;

        Node l2 = new Node(7);
        Node r2 = new Node(13);
        l1.left = l2;
        l1.right = r2;

        Node l3 = new Node(18);
        Node r3 = new Node(29);
        r1.left = l3;
        r1.right = r3;

        Node r4 = new Node(99);
        r3.right = r4;

        bst.root = rootNode;

        bst.insert(32);
        System.out.println(bst.find(32));
    }
}

