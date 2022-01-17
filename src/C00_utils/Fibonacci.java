package C00_utils;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(fibRec(n));
    }

    public static int fibRec(int n) {
        if (n == 1 || n == 2) return 1;
        return fibRec(n - 1) + fibRec(n - 2);
    }
}
