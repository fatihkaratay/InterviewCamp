package C06_recursion_backtracking;
/*
Given an array nums of distinct integers,
return all the possible permutations.
You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise05 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutation(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());

        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo) {
        if (memo.size() == nums.length) {
            result.add(new ArrayList<>(memo));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (memo.contains(nums[i])) continue;
                memo.add(nums[i]);
                backtrack(nums, result, memo);
                memo.remove(memo.size() - 1);
            }
        }
    }
}
