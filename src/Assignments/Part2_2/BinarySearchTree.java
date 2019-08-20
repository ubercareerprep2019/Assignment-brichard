package Assignments.Part2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to insert.
     */
    public void insert(int key) {
        Node current = getRoot();
        Node newNode = new Node(key);

        while (current != null) {
            if (key >= current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    current = current.right;
                }
            } else if (key <= current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    current = current.left;
                }
            }
        }
    }

    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to check for.
     * @return true if the key is present in this binary search tree, false otherwise.
     */
    public boolean find(int key) {
        Node current = getRoot();
        while (current != null) {
            if (key > current.key) {
                current = current.right;
            } else if (key < current.key) {
                current = current.left;
            } else if (key == current.key) {
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

    /**
     * Interface for a phone book.
     * Each entry in the phone book is made up of 2 components: a name (String) and a
     * phone number (long).
     *
     * For example, assume we have a phone book with the following data:
     *
     * {"name": "ABC", "phoneNumber": 1111111111}
     * {"name": "XYZ", "phoneNumber": 9999999999}
     * {"name": "DEF", "phoneNumber": 2222222222}
     *
     * then,
     * the size() method should return 3,
     * find("ABC") should return 1111111111,
     * find("XYZ") should return 9999999999,
     * find("PQR") should return -1.
     */
    public interface PhoneBook {
        /**
         * @return The number of entries in this phone book.
         */
        public int size();

        /**
         * Inserts an entry in this phone book.
         * @param name The name for the entry.
         * @param phoneNumber The phone number for the entry.
         */
        public void insert(String name, long phoneNumber);

        /**
         * Returns the phone number associated with a name in the phone book.
         * @param name The name to search for.
         * @return The phone number for the entry, or -1 if the name is not present in the phone book.
         */
        public long find(String name);
    }

    class LinkedPhoneBook implements PhoneBook {
        protected LinkedHashMap<String,Long> book = new LinkedHashMap<>();

        @Override
        public int size() {
            return book.size();
        }

        @Override
        public void insert(String name, long phoneNumber) {
            book.put(name,phoneNumber);
        }

        @Override
        public long find(String name) {
            for (String itemName : book.keySet()) {
               if (itemName.equals(name)) {
                   return book.get(itemName);
               }
            }
            return -1;
        }
    }

    class ListPhoneBook implements PhoneBook {
        protected ArrayList<HashMap<String,Long>> book = new ArrayList<>();

        @Override
        public int size() {
            return book.size();
        }

        @Override
        public void insert(String name, long phoneNumber) {
            HashMap<String,Long> item = new HashMap<>();
            item.put(name,phoneNumber);
            book.add(item);
        }

        @Override
        public long find(String name) {
            for (int i = 0; i < book.size(); i++) {
                HashMap<String,Long> item = book.get(i);
                if (item.containsKey(name)) {
                    return item.get(name);
                }
            }
            return -1;
        }
    }

    class BinarySearchTreePhoneBook implements PhoneBook {
        protected BinarySearchTree book = new BinarySearchTree();

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void insert(String name, long phoneNumber) {
        }

        @Override
        public long find(String name) {
            return -1;
        }
    }


    /**
     * For the first implementation, which we will call ListPhoneBook, please use a List (specifically an ArrayList)
     * as the underlying data structure to implement the methods.
     *
     *
     * For the second implementation, which we will call BinarySearchTreePhoneBook, please use a binary search tree
     * as the underlying data structure to implement the methods.
     *
     */

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

