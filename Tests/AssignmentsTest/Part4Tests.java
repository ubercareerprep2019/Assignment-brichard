package AssignmentsTest;

import Assignments.Part1_4.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 Implement the following tests (should be self explanatory):
        ○ testPushBackAddsOneNode
        ○ testPopBackRemovesCorrectNode
        ○ testEraseRemovesCorrectNode
        ○ testEraseDoesNothingIfNoNode
        ○ testElementAtReturnNode
        ○ testElementAtReturnsNoNodeIfIndexDoesNotExist
        ○ testSizeReturnsCorrectSize
 */

public class Part4Tests {

    /*********************  PushBack Tests  *********************/

    @Test
    public void pushBackOneNode() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        assertTrue(test.size() == 1);
    }

    @Test
    public void pushBackTestInt() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        test.pushBack(3);

        int[] ans = new int[] {4,3};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    @Test
    public void pushBackTestChar() {
        LinkedList test = new LinkedList();
        test.pushBack('b');
        test.pushBack('a');

        char[] ans = new char[] {'b','a'};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    /*********************  PopBack Tests  *********************/

    @Test
    public void popBackTestInt() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        test.pushBack(3);

        assertEquals(test.popBack(),3);
    }

    @Test
    public void popBackTestString() {
        LinkedList test = new LinkedList();
        test.pushBack("nip");
        test.pushBack("tha");
        test.pushBack("great");

        assertEquals(test.popBack(),"great");
    }

    /*********************  Insert Tests  *********************/

    @Test
    public void insertTestInt() {
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
    public void insertTestChar() {
        LinkedList test = new LinkedList();
        test.insert(0,'i');
        test.insert(0,'n');
        test.insert(2,'p');

        char[] ans = new char[] {'n','i','p'};

        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.getElementAt(i).getData(),ans[i]);
        }
    }

    /*********************  Erase Tests  *********************/

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
     void testEraseRemovesCorrectNode() {
        LinkedList linkedList = new LinkedList();
        linkedList.pushBack(0);
        linkedList.pushBack(7);
        linkedList.erase(0);

        assertEquals(linkedList.getElementAt(0).getData(),7);
    }

    @Test
     void testEraseDoesNothingIfNoNode() {
        LinkedList linkedList = new LinkedList();
        linkedList.pushBack(7);
        linkedList.pushBack(70);
        linkedList.erase(5);

        assertEquals(linkedList.size(),2);
    }

    /*********************  ElementAt Tests  *********************/

    @Test
     void elementAtTest() {
        LinkedList test = new LinkedList();
        test.insert(0,10);
        test.pushBack(11);
        test.insert(1,5);

        assertEquals(test.elementAt(2).getData(),11);
    }

    @Test
    void elementAtTestChar() {
        LinkedList test = new LinkedList();
        test.insert(0,'0');

        assertEquals(test.elementAt(2),null);
    }

    /*********************  Size Tests  *********************/

    @Test
     void sizeTestInt() {
        LinkedList test = new LinkedList();
        test.erase(9);
        test.insert(0, 10);
        test.insert(1, 5);
        test.erase(0);
        test.erase(1);

        assertEquals(test.size(), 1);
    }

    @Test
    void sizeTestChar() {
        LinkedList linkedList = new LinkedList();
        linkedList.pushBack('9');
        linkedList.popBack();
        linkedList.insert(1,'0');

        assertEquals(linkedList.size(),0);
    }

    /*********************  Cycle Tests  *********************/

    @Test
     void cycleTest() {
        LinkedList list = new LinkedList();
        list.pushBack(2);
        list.pushBack(8);
        list.pushBack(5);
        list.pushBackHelper(list.getElementAt(1));

        assertTrue(list.hasCycle());
    }

    @Test
     void noCycleTest() {
        LinkedList test = new LinkedList();
        test.pushBack("k");
        test.pushBack("l");
        test.pushBack("m");

        assertFalse(test.hasCycle());
    }

    /*********************  Palindrome Tests  *********************/

    @Test
     void isPalindromeTrue() {
        LinkedList test = new LinkedList();
        test.pushBack(4);
        test.pushBack(3);
        test.pushBack(8);
        test.pushBack(3);
        test.pushBack(4);

        assertTrue(test.isPalindrome());
    }

    @Test
     void isPalindromeFalse() {
        LinkedList test = new LinkedList();
        test.pushBack('o');
        test.pushBack('p');
        test.pushBack('d');
        test.pushBack('p');

        assertFalse(test.isPalindrome());
    }
}
