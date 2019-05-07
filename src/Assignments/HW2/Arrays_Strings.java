package Assignments.HW2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Arrays_Strings {
    /**
     * Implement the function: Boolean isStringPermutation(String s1, String s2)
     * This function takes two strings and returns true if one string is a permutation of the other, false otherwise.
     *
     * ex: isStringPermutation(abs, bsa) -> true , asb, bas,sab,sba are also true
     *
     *
     * Implement the function: Array<Pair<int>> pairsThatEqualSum(Array<int> inputArray, int targetSum)
     * ○This function takes an array of integers and a target integer to which the array elements must sum.
     * It returns an array of all pairs of integers from the input array whose sum equals the target.
     * */

    public static boolean isStringPermutation(String s1, String s2) {
        if (s1 != null && s2 != null & s1.length() == s2.length()) {
            HashMap<Character, Integer> s1_map = new HashMap<>();
            HashMap<Character, Integer> s2_map = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                s1_map.put(s1.charAt(i), s1_map.getOrDefault(s1.charAt(i),0) + 1);
                s2_map.put(s2.charAt(i), s2_map.getOrDefault(s2.charAt(i), 0) + 1);
            }

            return s1_map.equals(s2_map);
        }

        return false;
    }

    public static boolean isStringPermutationIter1(String s1, String s2) {
        if (s1 != null && s2 != null & s1.length() == s2.length()) {
            int i = 0;
            List<Character> s1_list = new ArrayList<>();

            for (Character letter : s1.toCharArray()) {
                s1_list.add(letter);
            }

            while (i < s2.length()) {
                if (s1_list.contains(s2.charAt(i))) {
                    s1_list.remove(Character.valueOf(s2.charAt(i)));
                }
                i++;
            }

            return s1_list.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {

        boolean ans = isStringPermutationIter1("abs", "cda");
        System.out.println(ans);

        boolean ans1 = isStringPermutation("abs", "sba");
        System.out.println(ans1);
    }
}
