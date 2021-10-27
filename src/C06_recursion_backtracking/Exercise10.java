package C06_recursion_backtracking;
/*
1415. The k-th Lexicographical String of All Happy Strings of Length n
consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and
strings "aa", "baa" and "ababbc" are not happy strings.
Given two integers n and k, consider a list of all happy strings of
length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are
less than k happy strings of length n.

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
Example 4:

Input: n = 2, k = 7
Output: ""
Example 5:

Input: n = 10, k = 100
Output: "abacbabacb"


Constraints:

1 <= n <= 10
1 <= k <= 100
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise10 {
    public static void main(String[] args) {
        int n = 3, k = 9;
        // There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
        String result = getHappyString(n, k);

        System.out.println(result);
    }

    public static String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        char[] letters = {'a', 'b', 'c'};
        backtrack(letters, list, new StringBuilder(), n, k);
        Collections.sort(list);

        System.out.println("result: " + list);
        System.out.println("result: " + list.size());

        if (list.size() < k)
            return "";
        else
            return list.get(k -1);
    }

    private static void backtrack(char[] letters, List<String> list, StringBuilder sb, int n, int k) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        } else {
            for (int i = 0; i < letters.length; i++) {
                if (sb.length() > 0 && letters[i] == sb.charAt(sb.length() - 1)) continue;
                sb.append(letters[i]);
                backtrack(letters, list, sb, n, k--);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
