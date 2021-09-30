package C01_arrays_strings_1;
/*
2 Sum Problem: Given a sorted array of integers, find two numbers in the array that
sum to a given integer target.
For example, if a = [1,2,3,5,6,7] and target = 11, the answer will be 5 and 6
 */

import java.util.Arrays;

public class Problem03 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7};
        int target = 11;
        int[] result = twoSum(arr, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[] {arr[start], arr[end]};
            }
        }

        return new int[]{};
    }
}
