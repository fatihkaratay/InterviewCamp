package C00_utils;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(fibRec(n));
        System.out.println(fibMemo(n));
    }

    public static int fibRec(int n) {
        if (n == 1 || n == 2) return 1;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fibMemo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int[] dp = new int[n]; // [1, 1, 2, 3, 5, 8];
        if (n == 1 || n == 2) return 1;
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
