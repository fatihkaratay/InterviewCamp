package C06_recursion_backtracking;

import java.util.HashMap;

/*
Level: Very Easy
Find the nth number in the Fibonacci series.
Fibonacci series is as follows:1, 1, 2, 3, 5, 8, 13, 21, .
 */
public class Problem01 {
    public static void main(String[] args) {
        int n = 7;

        System.out.println("Recursive: " + fibRec(n));
        System.out.println("Memoization: " + fibMemo(n));
    }

    public static int fibRec(int n) {
        if (n == 1 || n == 2) return 1;

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fibMemo(int n) {
        return fibMemo(n, new HashMap<Integer, Integer>());
    }
    private static int fibMemo(int n, HashMap<Integer, Integer> memo) {
        if (n == 1 || n == 2) return 1;

        if (memo.containsKey(n)) return memo.get(n);
        int result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, result);

        return result;
    }
}
