package Assignments.Part4;

public class Node<T> {

    private Node next;
    private Node previous;
    private T data;

    public Node(T data, Node previous, Node next) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(T data, Node previous,Node next) {
        this.next = new Node(data,previous,next);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node pre, Node next) {
        previous = pre;
        this.next = next;

    }

}
