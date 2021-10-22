package C06_recursion_backtracking;
/*
Given an integer array nums that may contain duplicates,
return all possible subsets (the power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise04 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        List<List<Integer>> result = subset(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), 0);

        return result;
    }
    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, int start) {
        result.add(new ArrayList<>(memo));
        for (int i = start; i < nums.length; i++) {
            memo.add(nums[i]);
            if (i > start && nums[i] == nums[i-1]) continue;
            backtrack(nums, result, memo, i + 1);
            memo.remove(memo.size() - 1);
        }
    }
}
