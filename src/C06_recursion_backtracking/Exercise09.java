package C06_recursion_backtracking;
/*
Given n pairs of parentheses, write a function to generate
all combinations of well-formed parentheses.
Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise09 {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParan(n);
        System.out.println(result);
    }

    public static List<String> generateParan(int n) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(n, n, "", result);
        return result;
    }

    private static void backtrack(int open, int close, String paran, ArrayList<String> result) {
        if (open == 0 && close == 0) {
            result.add(paran);
            return;
        }

        if (open > 0)
            backtrack(open-1, close, paran + "(", result);
        if (open < close)
            backtrack(open, close-1, paran+")", result);
    }
}
