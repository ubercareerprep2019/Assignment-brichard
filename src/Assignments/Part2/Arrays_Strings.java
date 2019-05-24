package Assignments.Part2;

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
     * This function takes an array of integers and a target integer to which the array elements must sum.
     * It returns an array of all pairs of integers from the input array whose sum equals the target.
     * */

    public static boolean isStringPermutation(String s1, String s2) {
        if (s1 != null && s2 != null & (s1.length() == s2.length())) {
            HashMap<Character, Integer> s1_map = new HashMap<>();
            HashMap<Character, Integer> s2_map = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                s1_map.put(s1.charAt(i), s1_map.getOrDefault(s1.charAt(i),0) + 1);
                s2_map.put(s2.charAt(i), s2_map.getOrDefault(s2.charAt(i),0) + 1);
            }

            return s1_map.equals(s2_map);
        }

        return false;
    }

    public static boolean isStringPermutationIter1(String s1, String s2) {
        if (s1 != null && s2 != null & s1.length() == s2.length()) {
            List<Character> s1_list = new ArrayList<>();

            for (Character letter : s1.toCharArray()) {
                s1_list.add(letter);
            }

            for (Character character : s2.toCharArray()) {
                s1_list.remove(character);
            }

            return s1_list.size() == 0;
        }

        return false;
    }

    public static ArrayList<int[]> pairsThatEqualSum(int[] inputArray, int targetSum) {
        if (inputArray != null) {
            ArrayList<int[]> arrayToReturn = new ArrayList<>();

            for (Integer num : inputArray) {
                int targetIndex = Arrays.binarySearch(inputArray, targetSum - num);

                if (targetIndex > -1) {
                    arrayToReturn.add(new int[]{num, inputArray[targetIndex]});
                }
            }
            return arrayToReturn;
        }

        return null;
    }

    public static ArrayList<int[]> pairsThatEqualSum(ArrayList<Integer> inputArray, int targetSum) {
        if (inputArray != null) {
            ArrayList<int[]> arrayToReturn = new ArrayList<>();
            int i = 0;

            while (inputArray.size() > 0 & i < inputArray.size()) {
                int targetIndex = inputArray.indexOf(targetSum - inputArray.get(i));

                if (targetIndex > -1) {
                    arrayToReturn.add(new int[]{inputArray.get(i), inputArray.get(targetIndex)});
                    inputArray.remove(inputArray.get(targetIndex));
                    inputArray.remove(inputArray.get(i));
                } else {
                    i++;
                }
            }
            return arrayToReturn;
        }

        return null;
    }

    public static void main(String[] args) {

        int[] test = new int[] {1,2,3,4};
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);


        ArrayList<int[]> ans0 = pairsThatEqualSum(test1,5);
        for (int[] array : ans0) {
            System.out.println(Arrays.toString(array));
        }

        boolean ans = isStringPermutationIter1("abs", "asb");
        System.out.println(ans);

        boolean ans1 = isStringPermutation("abs", "sba");
        System.out.println(ans1);
    }
}

