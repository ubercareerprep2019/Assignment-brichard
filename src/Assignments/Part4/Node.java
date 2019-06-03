package Assignments.Part4;

public class Node<T> {

    private Node next;
    private T data;

    public Node(T data, Node next) {
        this.next = next;
        this.data = data;
    }

}
