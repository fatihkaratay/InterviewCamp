package C00_utils;

public class StairProblem {
    public static void main(String[] args) {
        long n = 3;
        int m = 3;
        System.out.println("Number of ways = " + countWays(n, m));
    }

    static long countWaysUtil(long n, int m) {
        long res[] = new long[(int) n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[(int) (n - 1)];
    }

    // Returns number of ways to reach s'th stair
    static long countWays(long s, int m) {
        return countWaysUtil(s + 1, m);
    }
}
