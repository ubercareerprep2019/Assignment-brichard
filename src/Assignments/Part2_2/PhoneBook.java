package Assignments.Part2_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface PhoneBook {
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

    /**
     * @return The number of entries in this phone book.
     */
    public int size();

    /**
     * Inserts an entry in this phone book.
     *
     * @param name        The name for the entry.
     * @param phoneNumber The phone number for the entry.
     */
    public void insert(String name, long phoneNumber);

    /**
     * Returns the phone number associated with a name in the phone book.
     *
     * @param name The name to search for.
     * @return The phone number for the entry, or -1 if the name is not present in the phone book.
     */
    public long find(String name);


    class LinkedPhoneBook implements PhoneBook {
        private LinkedHashMap<String, Long> book = new LinkedHashMap<>();

        @Override
        public int size() {
            return book.size();
        }

        @Override
        public void insert(String name, long phoneNumber) {
            book.put(name, phoneNumber);
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
        private ArrayList<HashMap<String, Long>> book = new ArrayList<>();

        @Override
        public int size() {
            return book.size();
        }

        @Override
        public void insert(String name, long phoneNumber) {
            HashMap<String, Long> entry = new HashMap<>();
            entry.put(name, phoneNumber);
            book.add(entry);
        }

        @Override
        public long find(String name) {
            for (HashMap<String, Long> entry : book) {
                if (entry.containsKey(name)) {
                    return entry.get(name);
                }
            }
            return -1;
        }
    }

    class BinarySearchTree {
        private Node root;

        private static class Node {
            Node(String name, Long number) {
                this.name = name;
                this.number = number;
            }

            public String name;
            public Long number;
            public Node left;
            public Node right;
        }

    }

    class BinarySearchTreePhoneBook implements PhoneBook {
        private BinarySearchTree book = new BinarySearchTree();

        @Override
        public int size() {
            return size(book.root);
        }

        private int size(BinarySearchTree.Node currentNode) {
            if (currentNode == null) {
                return 0;
            } else {
                return (size(currentNode.left) + 1 + size(currentNode.right));
            }
        }

        @Override
        public void insert(String name, long phoneNumber) {
            BinarySearchTree.Node newNode = new BinarySearchTree.Node(name, phoneNumber);
            if (book.root == null) {
                book.root = newNode;
                return;
            }

            BinarySearchTree.Node currentNode = book.root;
            insertHelper(currentNode, newNode);

            // > means the string on the left is longer
            // < means the string on the left is shorter
        }

        //            while (currentNode != null) {
        //                if (currentNode.name.compareTo(name) >= 0) {
        //                    if (currentNode.left == null) {
        //                        currentNode.left = newNode;
        //                    } else {
        //                        currentNode = currentNode.left;
        //                    }
        //
        //                } else if (currentNode.name.compareTo(name) <= 0) {
        //                    if (currentNode.right == null) {
        //                        currentNode.right = newNode;
        //                    } else {
        //                        currentNode = currentNode.right;
        //                    }
        //                }
        //            }

        private BinarySearchTree.Node insertHelper(BinarySearchTree.Node current, BinarySearchTree.Node toInsert) {
            if (current == null) {
                return toInsert;
            }

            if (current.name.compareTo(toInsert.name) >= 0) {
                current.left = insertHelper(current.left, toInsert);
            } else if (current.name.compareTo(toInsert.name) <= 0) {
                current.right = insertHelper(current.right, toInsert);
            }

            return current;
        }

        @Override
        public long find(String name) {
            if (book.root != null) {
                BinarySearchTree.Node currentNode = book.root;

                while (currentNode != null) {
                    if (currentNode.name.equals(name)) {
                        return currentNode.number;
                    } else if (currentNode.name.compareTo(name) >= 0) {
                        currentNode = currentNode.left;
                    } else if (currentNode.name.compareTo(name) <= 0) {
                        currentNode = currentNode.right;
                    }
                }
            }

            return -1;
        }
    }

    /**
     * For the first implementation, which we will call ListPhoneBook, please use a List (specifically an ArrayList)
     * as the underlying data structure to implement the methods.
     * <p>
     * <p>
     * For the second implementation, which we will call BinarySearchTreePhoneBook, please use a binary search tree
     * as the underlying data structure to implement the methods.
     */

    class PhoneBookImplementation {

        private void callInsert(PhoneBook phoneBook) throws IOException {
            Long start = System.currentTimeMillis();
            BufferedReader reader = new BufferedReader(new FileReader("src/res/data.csv"));

            while (reader.lines() != null) {
                String line = reader.readLine();
                if (line == null) { break; }

                String[] currentLine = line.split(",");
                phoneBook.insert(currentLine[0], Long.valueOf(currentLine[1]));
            }

            Long end = System.currentTimeMillis();
            System.out.println("Insert took " + (end - start) + " milliseconds.");
        }

        private void callSize(PhoneBook phoneBook) throws Exception {
            if (phoneBook.size() != 1000000) {
                throw new Exception("Phone book is not right size");
            } else {
                System.out.println("The size of the PhoneBook is " + phoneBook.size());
            }
        }

        private void callFind(PhoneBook phoneBook) throws Exception {
            Long startSearch = System.currentTimeMillis();
            BufferedReader reader = new BufferedReader(new FileReader("src/res/search.txt"));
            int count = 0;

            while (reader.lines() != null) {
                String currentLine = reader.readLine();
                if (currentLine == null) { break; }
                if (phoneBook.find(currentLine) == -1) {
                    throw new Exception("An entry could not be found");
                }
                count++;
            }

            Long endSearch = System.currentTimeMillis();
            System.out.println("find() was called " + count + " times.");
            System.out.println("Search took " + (endSearch - startSearch) + " milliseconds.");
        }

        private void createListPhoneBook() throws Exception {
            ListPhoneBook listPhoneBook = new ListPhoneBook();
            callInsert(listPhoneBook);
            callSize(listPhoneBook);
            callFind(listPhoneBook);
        }

        private void createBSTPhoneBook() throws Exception {
            BinarySearchTreePhoneBook binarySearchTreePhoneBook = new BinarySearchTreePhoneBook();
            callInsert(binarySearchTreePhoneBook);
            callSize(binarySearchTreePhoneBook);
            callFind(binarySearchTreePhoneBook);
        }
    }

    public static void main(String[] args) {
        ListPhoneBook listPhoneBook = new ListPhoneBook();
        listPhoneBook.insert("ABC", 1111111111);
        listPhoneBook.insert("XYZ", 9999999999L);
        listPhoneBook.insert("DEF", 2222222222L);

        BinarySearchTreePhoneBook binarySearchTreePhoneBook = new BinarySearchTreePhoneBook();
        binarySearchTreePhoneBook.insert("ABC", 1111111111);
        binarySearchTreePhoneBook.insert("XYZ", 9999999999L);
        binarySearchTreePhoneBook.insert("DEF", 2222222222L);

        System.out.println(listPhoneBook.size());
        System.out.println(listPhoneBook.find("ABC"));
        System.out.println(listPhoneBook.find("XYZ"));
        System.out.println(listPhoneBook.find("PQR"));

        System.out.println(binarySearchTreePhoneBook.size());
        System.out.println(binarySearchTreePhoneBook.find("ABC"));
        System.out.println(binarySearchTreePhoneBook.find("XYZ"));
        System.out.println(binarySearchTreePhoneBook.find("PQR"));

        PhoneBookImplementation implementation = new PhoneBookImplementation();
        System.out.println();

        try {
            implementation.createListPhoneBook();
            System.out.println();
            implementation.createBSTPhoneBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * The output of my program when I used ListPhoneBook was:
 *
 * Insert took 1104 milliseconds.
 * The size of the PhoneBook is 1000000
 * find() was called 1000 times.
 * Search took 10770 milliseconds.
 *
 * The output of my program when I used BinarySearchTreePhoneBook was:
 *
 * Insert took 2401 milliseconds.
 * The size of the PhoneBook is 1000000
 * find() was called 1000 times.
 * Search took 3 milliseconds.
 *
 * The bst has faster search time because of its structure we are able to skip about half of the tree. This narrows
 * down what parts actually need to be searched through and therefore decrease the amount of time it takes to search.
 */

