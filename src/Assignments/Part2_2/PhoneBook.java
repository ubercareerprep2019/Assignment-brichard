package Assignments.Part2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

    class BinarySearchTree {

        public class Entry {
            private String name;
            private Long number;
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
}
