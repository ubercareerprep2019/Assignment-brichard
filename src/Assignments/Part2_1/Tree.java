package Assignments.Part2_1;

public class Tree {

    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Exercise 1
     * <p>
     * 1
     * 7      17
     * 6    3
     * <p>
     * Implement a method called print() to print the values of the data in all the TreeNodes in a Tree above.
     * For example, running print() on the Tree above should produce one of the three values below:
     * <p>
     * 7 6 3 17 1
     */

    private void print() {
        printHelper(root);
    }

    private void printHelper(TreeNode node) {
        if (node.left != null) {
            printHelper(node.left);
        }
        if (node.right != null) {
            printHelper(node.right);
            System.out.print(String.valueOf(node.data) + " ");
        } else {
            System.out.print(String.valueOf(node.data) + " ");
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(6, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(17, leftChild, rightChild);
        TreeNode root = new TreeNode(1, left, right);
        Tree tree = new Tree(root);
        tree.print();
    }
}
