package C06_recursion_backtracking;
/*
(Level: Easy)

Power Function: Implement a function to calculate xn.
Both x and n can be positive/negative and overflow doesn't happen.
Try doing it in O(log(n)) time.
 */

public class Homework01 {
    public static void main(String[] args) {
        int x = 2;
        int n = 6;

        System.out.println(pow(x, n));
    }

    public static float pow(int x, int n) {
        if (x == 0 && n <= 0) throw new ArithmeticException(("Undefined"));

        float result = positivePower(Math.abs(x), Math.abs(n));

        if (x < 0 && n % 2 != 0) result = -1 * result;
        if (n < 0) result = 1 / result;

        return result;
    }

    private static float positivePower(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        float halfPower = positivePower(x, n / 2);

        if (n % 2 == 0)
            return halfPower * halfPower;
        else
            return halfPower * halfPower * halfPower;
    }
}
