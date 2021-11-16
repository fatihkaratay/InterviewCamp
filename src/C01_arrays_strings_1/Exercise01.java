package C01_arrays_strings_1;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise01 {
    public static void main(String[] args) {
        String s = "ac";
        String result = longestPalindrome(s);
//        List<String> result2 = longestPalindrome(s);

        System.out.println(result);
    }

//    public static List<String> longestPalindrome(String s) {
    public static String longestPalindrome(String s) {
        List<String> result = new ArrayList<>();
        int max = 0;
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    int size = temp.length();
                    map.put(size, temp);
                    max = Math.max(max, size);
                    result.add(temp);
                }

            }
        }

        System.out.println(result);
        System.out.println(max);
        return map.get(max);
    }
    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        return true;
    }
}
