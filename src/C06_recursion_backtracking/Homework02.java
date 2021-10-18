package C06_recursion_backtracking;
/*
(Level: Medium)

Coin Change Problem: Given a set of coin denominations,
print out the different ways you can make a target amount.
You can use as many coins of each denomination as you like.

For example: If coins are [1,2,5] and the target is 5, output will be:
[1,1,1,1,1]
[1,1,1,2]
[1,2,2]
[5]

Variant of this problem: If you had to print just the count
(instead of the actual combinations), there is a more efficient solution in the
Dynamic Programming Section.
This solution is also acceptable though.
 */

import java.util.Arrays;
import java.util.Stack;

public class Homework02 {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 10};
        int target = 15;

        printCoins(coins, target);
    }

    public static void printCoins(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target <= 0) {
            return;
        }

        int[] buffer = new int[coins.length];
        backtrack(coins, target, 0, new Stack<Integer>(), 0);
    }

    private static void backtrack(int[] coins, int target, int startIndex, Stack<Integer> buffer, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            printArray(buffer);
            return;
        }

        for (int i = startIndex; i < coins.length; i++) {
            buffer.push(coins[i]);
            backtrack(coins, target, i, buffer, coins[i] + sum);
            buffer.pop();
        }
    }

    private static void printArray(Stack<Integer> buffer) {
        System.out.println(Arrays.asList(buffer.toArray()));
    }
}
