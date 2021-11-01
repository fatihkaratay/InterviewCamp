package C06_recursion_backtracking;

/*
Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence
of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple
times in the segmentation.


Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise13 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");

        boolean result = wordBreak(s, list);

        System.out.println("result: " + result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new Boolean[s.length()], 0);
    }

    private static boolean backtrack(String s, List<String> list, Boolean[] memo, int start) {
        if (start == s.length()) {
            return true;
        } else if (memo[start] != null) {
            return memo[start];
        } else {
            for (int i = start + 1; i <= s.length(); i++) {
                if (list.contains(s.substring(start, i)) && backtrack(s, list, memo, i)) {
                    return memo[start] = true;
                }
            }
        }

        return memo[start] = false;
    }
}
