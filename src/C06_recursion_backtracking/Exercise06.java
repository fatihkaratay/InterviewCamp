package C06_recursion_backtracking;
/*
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise06 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = permutationDuplicates(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> permutationDuplicates(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> memo = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtract(nums, result, memo, used);

        return result;
    }

    private static void backtract(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, boolean[] used) {
        if (memo.size() == nums.length) {
            result.add(new ArrayList<>(memo));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                memo.add(nums[i]);
                backtract(nums, result, memo, used);
                used[i] = false;
                memo.remove(memo.size() - 1);
            }
        }
    }
}
