package Assignments.Part1_3;

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

    public int top() {
        return getQueue().top();
    }

    public boolean isEmpty() {
        return getQueue().isEmpty();
    }

}
