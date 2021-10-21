package C06_recursion_backtracking;
/*
Level: Medium
Word Break Problem : Given a String S, which contains letters and no spaces,
determine if you
can break it into valid words. Return one such combination of words.
You can assume that you are provided a dictionary of English words.

For example:
S = "ilikemangotango"

Output:
Return any one of these:
"i like mango tango"
"i like man go tan go"
"i like mango tan go"
"i like man go tango"
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Homework04 {
    public static void main(String[] args) {
        String s = "ilikemangotango";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("tango");
        dictionary.add("mango");
        dictionary.add("to");
        dictionary.add("tan");

        System.out.println("dictionary: " + dictionary);

        List<String> result = wordBreak(s, dictionary);

        System.out.println("result: " + result);
    }

    public static List<String> wordBreak(String s, HashSet<String> dictionary) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        State[] memo = new State[s.length()];
        Arrays.fill(memo, State.UNVISITED);

        List<String> result = new ArrayList<>();

        if (backtrack(s, 0, result, dictionary, memo)) {
            return result;
        }

        return null;
    }

    private static boolean backtrack(String s, int start, List<String> result, HashSet<String> dictionary, State[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] == State.NOT_FOUND) {
            return false;
        }

        for (int i = start; i < s.length(); i++) {
            String candidate = s.substring(start, i + 1);
            if (dictionary.contains(candidate)) {
                result.add(candidate);
                if (backtrack(s, i + 1, result, dictionary, memo)) {
                    return true;
                } else {
                    result.remove(result.size() - 1);
                    memo[i + 1] = State.NOT_FOUND;
                }
            }
        }

        return false;
    }

    public enum State {
        UNVISITED,
        NOT_FOUND
    }
}
