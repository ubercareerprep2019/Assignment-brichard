package Assignments.Part4;

import java.util.HashSet;


public class LinkedList<T> {

    /** Singly Linked List class */

    private Node head;
    private Node tail;
    private int size = 0;

    /**
     * This method returns the length of the list.
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Adds a single node containing data to the end of the list
     * @param data - value
     */
    public void pushBack(T data) {
        Node newNode = new Node(data,null);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        size++;
        tail = newNode;
    }

    /**
     * This method implements pushBack in a way that enables cycles to be formed.
     * @param node - next node
     */
    public void pushBackHelper(Node node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
    }

    /**
     * Removes a single node from the end of the list
     * @return data
     */
    public T popBack() {
         size--;
         T result = (T) tail.getData();
         tail = null;
         return result;
    }

    /**
     *  Adds a single node containing data to a chosen location in the list. If the index is above the size
     *  of the list, does nothing.
     * @param index -  location where the node would be inserted
     * @param data - value
     */
    public void insert(int index, T data) {
        if (index < size + 1 && index > 0 || index == 0) {
            size++;
            Node newNode = new Node(data,getElementAt(index));

            if (index == 0) {
                head = newNode;
            } else {
                getElementAt(index - 1).setNext(newNode);
            }
        }
    }

    /**
     * Erases a single node at the index location in the list.
     * @param index - location in the list
     */
    public void erase(int index) {
        if (index > 0 && index < size || index == 0) {
            size--;

            if (index == 0) {
                head = getElementAt(index).getNext();
            } else {
                getElementAt(index - 1).setNext(getElementAt(index).getNext());
            }
        }
    }

    /**
     * Returns a single node at the index location in the list.
     * @param index - location in the list
     * @return node at that index
     */
    public Node elementAt(int index) {
        return getElementAt(index);
    }

    /**
     * This helper method returns a node at the specified location
     * @param index - location in list
     * @return node
     */
    public Node getElementAt(int index) {
        int count = 0;
        Node current = head;

        while (index < size && index >= 0) {
            if (count == index) {
                return current;
            } else {
                current = current.getNext();
                count++;
            }
        }
        return null;
    }

    /**
     * Cycles can happen if a given node references an earlier node for the “next” reference.
     * Using your LinkedList class, implement a function to detect cycles in the list.
     * @return bool
     */
    public boolean hasCycle() {
        HashSet<Node> set = new HashSet<>();
        int i = 0;
        Node current = head;

        while (i < size) {
            set.add(current);
            if (set.contains(current.getNext())) {
                return true;
            }
            current = current.getNext();
            i++;
        }

        return false;
    }

    /**
     * In the node that there is a variable called visited. Using the result of this variable a cycle can be detected
     * @return bool
     */
    public boolean hasCycleEngancedNodes() {
        Node current = head;

        while (current.getNext() != null) {
            if (current.getVisited()) {
                return true;
            } else {
                current.setVisited();
                current = current.getNext();
            }
        }
        return false;
    }

    /**
     * This functions returns T/F if the data in the list reads the same forwards as backwards
     * @return bool
     */
    public boolean isPalindrome() {
        // assuming this is considering the data instead of the actual nodes
        String data = "";
        Node current = head;

        if (!hasCycle()) {
            while (current != null) {
                data = data + String.valueOf(current.getData());
                current = current.getNext();
            }
        }

        String reversed = new StringBuilder(data).reverse().toString();
        return data.equals(reversed);
    }

}
