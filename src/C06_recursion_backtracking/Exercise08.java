package C06_recursion_backtracking;
/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise08 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> result = combinationSum(nums, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> memo = new ArrayList<>();
        backtract(nums, result, memo, 0, target);

        return result;
    }
    private static void backtract(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, int start, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(memo));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                memo.add(nums[i]);
                backtract(nums, result, memo, i+1, remain-nums[i]);
                memo.remove(memo.size() - 1);
            }
        }
    }
}
