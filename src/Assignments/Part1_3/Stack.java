package Assignments.Part1_3;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    /**
     * Implement the Stack class from scratch. You will need the following methods.
     * ○ push()
     * ■ Pushes an integer on top of the stack.
     * ○ pop()
     * ■ Removes what is on the top of the stack, and returns that value to the
     * caller.
     * ○ top()
     * ■ Looks at the top value, and returns it. Does not manipulate the stack.
     * ○ isEmpty()
     * ■ Returns a True or False if the stack is Empty or not, respectively.
     */


    private List<Integer> stack = new ArrayList<>();
    private int minTracker;

    private boolean insertFront = true;

    public void setInsertFront(boolean b) {
        this.insertFront = b;
    }

    public List<Integer> getStack() {
        return stack;
    }

    public void push(int num) {
        if (insertFront) {
            getStack().add(0, num);
        } else {
            getStack().add(num);
        }
        setMin(num);
    }

    public void setMin(int num) {
        if (num < minTracker && getStack().size() > 1) {
            minTracker = num;
        } else if (getStack().size() == 1) {
            minTracker = num;
        }
    }


    public int pop() {
        try {
            return getStack().remove(0);
        } catch (Exception e) {
            System.out.println("Stack is empty can no longer remove items: -1 will be returned as a default");
        }
        

        return -1;
    }

    public int top() {
        return getStack().get(0);
    }

    public boolean isEmpty() {
        return getStack().size() == 0;
    }

    public int min() {
        return minTracker;
    }


    public static void main(String[] args) {

        Stack test = new Stack();
        test.push(8);
        test.push(22);
        System.out.println(test.top());
        test.push(70);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.isEmpty());

        Queue testQ = new Queue();
        testQ.enqueue(9);
        testQ.enqueue(2);
        testQ.enqueue(1);
        System.out.println(testQ.dequeue());

    }

}

