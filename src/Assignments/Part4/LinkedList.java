package Assignments.Part4;

public class LinkedList<T> {
    /**
     * Implement a Singly Linked List class. You will need to implement the following methods:
     * ○ void pushBack(<T> data)
     *      ■ Adds a single node containing data to the end of the list
     * ○ <T> popBack()
     *       ■ Removes a single node from the end of the list
     * ○ void insert(uint index,<T> data)
     *       ■ Adds a single node containing data to a chosen location in the list. If the
     * index is above the size of the list, do nothing.
     *
     * ○ void erase(uint index)
     *      ■ Erases a single node at the index location in the list.
     * ○ <T> elementAt(uint index)
     *       ■ Returns a single node at the index location in the list.
     * ○ uint size()
     *       ■ Returns the length of the list.
     * */

    Node head;
    Node tail;
    int size = 0;

    public int size() {
        return size;
    }

    public void pushBack(T data) {
        Node newNode = new Node(data,null);

        if (head == null) {
            head = newNode;
        } else {
            getElementAt(size - 1).setNext(newNode);
        }

        size++;
        tail = newNode;
    }

    public T popBack() {
         size--;
         T result = (T) tail.getData();
         tail = null;
         return result;
    }

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

    public T elementAt(int index) {
        return (T) getElementAt(index).getData();
    }

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
}
