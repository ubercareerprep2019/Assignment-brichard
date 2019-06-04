package Assignments.Part4;

public class Node<T> {

    private Node next;
    private T data;

    public Node(T data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
