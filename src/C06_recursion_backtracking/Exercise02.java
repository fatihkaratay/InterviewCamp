package C06_recursion_backtracking;
/*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    A palindrome string is a string that reads the same backward as forward.

    Example 1:

    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
    Example 2:

    Input: s = "a"
    Output: [["a"]]
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "a";

        List<List<String>> result1 = partitionPalindrome(s1);
        List<List<String>> result2 = partitionPalindrome(s2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static List<List<String>> partitionPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        List<String> memo = new ArrayList<>();
        if (backtrack(s, result, memo)) {
            return result;
        }

        return new ArrayList<>();
    }

    private static boolean backtrack(String s, List<List<String>> result, List<String> memo) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(memo));
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (isPalindrome(temp)) {
                memo.add(temp);
                if (backtrack(s.substring(i, s.length()), result, memo)) {
                    return true;
                } else {
                    memo.remove(memo.size() - 1);
                    return false;
                }

            }
        }

        return false;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                return true;
            }
            i++;
            j--;
        }
        return false;
    }
}
