package AssignmentsTest;

import Assignments.HW2.Arrays_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW2Tests {

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
}
