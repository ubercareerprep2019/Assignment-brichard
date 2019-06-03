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

    int size() {
        return size;
    }

     void pushback(T data) {
        Node current = head;
        size++;

        while (current != null) {
            if (current.getNext() == null) {
                current.setNext(data,current,null);
                tail = current.getNext();
                return;
            }
            current = current.getNext();
        }
        head = new Node(data,null,tail);
    }

    T popBack() {
         size--;
         T dataToReturn = (T) tail.getData();
         tail = null;
         return dataToReturn;
    }

    void insert(int index, T data) {
        int currentIndex = 0;
        Node currentNode = head;

         while (index < size) {
             if (index == currentIndex) {
                 if (index == 0) {
                     head = new Node(data,null,currentNode);
                     return;
                 } else {
                     currentNode.getPrevious().setNext(data,currentNode.getPrevious(),currentNode);
                     return;
                 }
             } else {
                 currentIndex++;
             }
         }
    }

    void erase(int index) {
        if (index == 0) {
            head = getElementAt(index).getNext();
        } else {
            getElementAt(index).getPrevious().setNext(getElementAt(index).getNext());
        }
        getElementAt(index).setPrevious(null,null);
    }

    T elementAt(int index) {
        return (T) getElementAt(index).getData();
    }

    Node getElementAt(int index) {
        int count = 0;
        Node current = head;

        while (index < size) {
            if (count == index) {
                return current;
            } else {
                count++;
            }
        }
        return null;
    }

    //int count = 0;
    //        Node current = head;
    //
    //        while (index < size) {
    //            if (count == index) {
    //                current.getPrevious().setNext(current.getNext());
    //                return current;
    //            } else {
    //                count++;
    //            }
    //        }



}
