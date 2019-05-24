package AssignmentsTest;

import Assignments.Arrays_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HW2Tests {

    /******************** isStringPermutatuonTest ********************/

    /** AssertTrue test */

    @Test
    public void isStringPermutationTestEmptyString() {
        assertTrue(Arrays_Strings.isStringPermutation("",""));
    }

    @Test
    public void isStringPermutationTestWhiteSpace() {
        assertTrue(Arrays_Strings.isStringPermutation(" "," "));
    }

    @Test
    public void isStringPermutationTestCharacters() {
        assertTrue(Arrays_Strings.isStringPermutation(",.?","?,."));
    }

    @Test
    public void isStringPermutationTestInt() {
        assertTrue(Arrays_Strings.isStringPermutation(String.valueOf(0),String.valueOf(0)));
    }

    @Test
    public void isStringPermutationTestEmptyLongString() {
        assertTrue(Arrays_Strings.isStringPermutation("abcdefghijklmnopqrstuvwxyz","zaqwsxcderfvbgtyhnmjuiklop"));
    }

    @Test
    public void isStringPermutationTestShortString() {
        assertTrue(Arrays_Strings.isStringPermutation("uid","diu"));
    }

    @Test
    public void isStringPermutationTestStringChar() {
        assertTrue(Arrays_Strings.isStringPermutation("cq 2 ,mi","  2,miqc"));
    }

    @Test
    public void isStringPermutationTestTab() {
        assertTrue(Arrays_Strings.isStringPermutation(" "," "));
    }

    /** AssertFalse Tests */

    @Test
    public void isStringPermutationTestDifferentLength() {
        assertFalse(Arrays_Strings.isStringPermutation("bdg","dbgd"));
    }

    @Test
    public void isStringPermutationTestNull() {
        assertFalse(Arrays_Strings.isStringPermutation(null,null));
    }

    @Test
    public void isStringPermutationTestShortStringFalse() {
        assertFalse(Arrays_Strings.isStringPermutation("abc","bcq"));
    }

    @Test
    public void isStringPermutationTestIntFalse() {
        assertFalse(Arrays_Strings.isStringPermutation(String.valueOf(90),String.valueOf(10)));
    }

    @Test
    public void isStringPermutationTestLongStringFalse() {
        assertFalse(Arrays_Strings.isStringPermutation("qwertyuiop","asdfghjkl;"));
    }

    @Test
    public void isStringPermutationTestCharString() {
        assertFalse(Arrays_Strings.isStringPermutation("  -09",".,;ut"));
    }

    @Test
    public void isStringPermutationTestTabFalse() {
        assertFalse(Arrays_Strings.isStringPermutation("        "," "));
    }

    /******************** pairsThatEqualSumTests ********************/

    @Test
    public void pairsThatEqualSumTest2Pairs() {
        int[] test = new int[]{1,2,4,6,0};
        assertEquals(2,Arrays_Strings.pairsThatEqualSum(test,6).size());
    }

//    @Test
//    public void pairsThatEqualSumTestNull() {
//        assertNull(Arrays_Strings.pairsThatEqualSum(null,6));
//    }

    @Test
    public void pairsThatEqualSumTestNoPairs() {
        int[] test = new int[]{0,2,3,6,0};
        assertEquals(0,Arrays_Strings.pairsThatEqualSum(test,10).size());
    }

    @Test
    public void pairsThatEqualSumTestNegatives() {
        int[] test = new int[]{-1,-2,4,6,10};
        assertEquals(2,Arrays_Strings.pairsThatEqualSum(test,8).size());
    }

    @Test
    public void pairsThatEqualSumTestNegativeTarget() {
        int[] test = new int[]{-11,10,4,5,-12};
        assertEquals(1,Arrays_Strings.pairsThatEqualSum(test,-6).size());
    }

//    @Test
//    public void pairsThatEqualSumTestDuplicates() {
//        int[] test = new int[]{0,0,0,0,0};
//        assertEquals(2,Arrays_Strings.pairsThatEqualSum(test,0).size());
//    }

}
