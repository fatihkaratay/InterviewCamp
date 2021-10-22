package C06_recursion_backtracking;
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise03 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        List<List<Integer>> result = subset(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);

        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, int start) {
        result.add(new ArrayList<>(memo));
        for (int i = start; i < nums.length; i++) {
            memo.add(nums[i]);
            backtrack(nums, result, memo, i+1);
            memo.remove(memo.size() - 1);
        }
    }
}
