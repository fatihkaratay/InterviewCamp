package C06_recursion_backtracking;
/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of
the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to
target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise07 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(nums, target);

        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtract(nums, result, new ArrayList<>(), 0, target);

        return result;
    }

    private static void backtract(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, int start, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(memo));
        } else {
            for (int i = start; i < nums.length; i++) {
                memo.add(nums[i]);
                backtract(nums, result, memo, i, remain - nums[i]);
                memo.remove(memo.size() - 1);
            }
        }
    }
}
