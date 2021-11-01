package C06_recursion_backtracking;
/*
Suppose you have n integers labeled 1 through n.
A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement
if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:

Input: n = 2
Output: 2
Explanation:
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
Example 2:

Input: n = 1
Output: 1


Constraints:

1 <= n <= 15
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise12 {
        static int count = 0;
        public static void main(String[] args) {
                int n = 3;
                List<List<Integer>> perm = perm(n);

                System.out.println(perm);
                System.out.println(perm.size());
                System.out.println("count: " + count);
        }

        public static List<List<Integer>> perm(int n) {
                List<List<Integer>> result = new ArrayList<>();
                boolean[] visited = new boolean[n+1];
                backtrack(n,result, visited, new ArrayList<>(), 1);

                return result;
        }

        private static void backtrack(int n, List<List<Integer>> result, boolean[] visited, ArrayList<Integer> memo, int start) {
                if (start > n) {
                        count++;
                        result.add(new ArrayList<>(memo));
                } else {
                        for (int i = 1; i <= n; i++) {
                                if (!visited[i] && (i % start == 0 || start % i == 0)) {
                                        memo.add(i);
                                        visited[i] = true;
                                        backtrack(n, result, visited, memo, start + 1);
                                        visited[i] = false;
                                        memo.remove(memo.size() - 1);
                                }
                        }
                }
        }
}
