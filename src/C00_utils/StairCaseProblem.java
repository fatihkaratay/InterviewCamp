package C00_utils;

import java.util.Arrays;

/**
 * You are given a number of steps. Compute the number of ways to get to the top
 * using only 1 or 3 or 5 steps at a time.
 */
public class StairCaseProblem {
    public static void main(String[] args) {
        int top = 8;
        System.out.println(stairProblem(top));
    }

    public static int stairProblem(int top) {
        int[] dp = new int[top + 1]; // 0, 1, 2, 3, 4, 5, 6, 7, 8
        dp[0] = 1;
        /*
         * dp[i+1] = dp[i+1] + d[[i]
         * dp[1+3] = dp[i+3] + d[[i]
         * dp[1+5] = dp[i+5] + d[[i]
         *
         * if (dp[i+1] > dp.length ==> dp[i + 1] = 0;
         * if (dp[i+3] > dp.length ==> dp[i + 3] = 0;
         * if (dp[i+5] > dp.length ==> dp[i + 5] = 0;
         */

        for (int i = 0; i < dp.length; i++) {
            if (i + 1 < dp.length)
                dp[i + 1] += dp[i];
            if (i + 3 < dp.length)
                dp[i + 3] += dp[i];
            if (i + 5 < dp.length)
                dp[i + 5] += dp[i];
        }

        return dp[top];
    }
}
