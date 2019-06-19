package Assignments.Part3;

public class Queue {

    private Stack queue;

    public Queue() {
        queue = new Stack();
    }

    public Stack getQueue() {
        return queue;
    }

    public void enqueue(int num) {
        getQueue().setInsertFront(false);
        getQueue().push(num);
    }

    public int dequeue() {
        return getQueue().pop();
    }

}
