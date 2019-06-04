package AssignmentsTest;

import Assignments.Part4.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part4Tests {

    @Test
    public void pushBackTest() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        test.pushBack(3);

        int[] ans = new int[] {4,3};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    @Test
    public void popBackTest() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        test.pushBack(3);

        assertEquals(test.popBack(),3);
    }


    @Test
    public void insertTest() {
        LinkedList test = new LinkedList();
        test.insert(2,8);
        test.insert(0,7);
        test.insert(1,10);
        test.insert(0,9);

        int[] ans = new int[] {9,7,10};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    @Test
    public void eraseTest() {
        LinkedList test = new LinkedList();
        test.erase(9);
        test.insert(0,10);
        test.insert(1,5);
        test.erase(0);

        int[] ans = new int[] {5};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    @Test
    public void elementAtTest() {
        LinkedList test = new LinkedList();
        test.insert(0,10);
        test.pushBack(11);
        test.insert(1,5);

        assertEquals(test.elementAt(2),11);
    }

    @Test
    public void sizeTest() {
        LinkedList test = new LinkedList();
        test.erase(9);
        test.insert(0, 10);
        test.insert(1, 5);
        test.erase(0);
        test.erase(1);

        assertEquals(test.size(), 1);
    }
}
