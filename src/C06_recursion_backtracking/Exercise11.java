package C06_recursion_backtracking;
/*
create all possible permutations of a string.
Example: "ABC" = ABC, ACB, BAC, BCA, CAB, CBA
letters are distinct
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise11 {
    public static void main(String[] args) {
        String s = "AAB";

        List<String> result = getPermutation(s);

        System.out.println(result);
    }

    public static List<String> getPermutation(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(s, result, new StringBuilder(), used, 0);

        return result;
    }

    private static void backtrack(String s, List<String> result, StringBuilder sb, boolean[] used, int start) {
        if (s.length() == sb.length()) {
            System.out.println("start: " + start);
            result.add(sb.toString());
            return;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (used[i] ||  i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i-1]) continue;
                sb.append(s.charAt(i));
                if (result.contains(sb.toString())) continue;
                used[i] = true;
                backtrack(s, result, sb, used, i + 1);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
