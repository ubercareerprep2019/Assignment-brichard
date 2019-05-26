package AssignmentsTest;

import Assignments.Part3.Queue;
import Assignments.Part3.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part3Tests {

    /******************** StackTests ********************/

    @Test
    public void stackPushTest() {
        Stack testStack = new Stack();
        testStack.push(7);
        testStack.push(89);
        assertFalse(testStack.isEmpty());
    }

    @Test
    public void stackTopTest() {
        Stack testStack = new Stack();
        testStack.push(30);
        testStack.push(0);
        testStack.pop();
        assertTrue(testStack.top() == 30);
    }

    @Test
    public void stackPopTest() {
        Stack testStack = new Stack();
        testStack.push(30);
        testStack.push(0);
        testStack.pop();
        testStack.pop();
        testStack.pop();
        assertTrue(testStack.isEmpty());
    }

    @Test
    public void stackMinTest() {
        Stack testStack = new Stack();
        testStack.push(30);
        testStack.push(0);
        testStack.push(-1);
        assertTrue(testStack.min() == -1);
    }

    @Test
    public void stackEmptyTest() {
        Stack testStack = new Stack();
        testStack.push(30);
        testStack.push(0);
        testStack.pop();
        assertFalse(testStack.isEmpty());
    }

    /******************** QueueTests ********************/

    @Test
    public void queueEnqueueTest() {
        Queue testQueue = new Queue();
        testQueue.enqueue(8);
        testQueue.enqueue(-11);
        Queue test2 = new Queue();
        test2.enqueue(-11);
        test2.enqueue(8);
        assertNotEquals(testQueue,test2);

    }

    @Test
    public void queueDequeueTest() {
        Queue testQueue = new Queue();
        testQueue.enqueue(8);
        testQueue.dequeue();
        testQueue.dequeue();
        Queue test2 = new Queue();
        test2.enqueue(-11);
        assertNotEquals(testQueue,test2);
    }

}
