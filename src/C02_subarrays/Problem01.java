package C02_subarrays;
/*
(Level: Easy) Given an array of integers, find the contiguous subarray
(with at least 1 element) with the maximum sum.
The array can contain both negative and positive integers.
ex: A=[-2, -3, 4, -1, -2, 1, 5, -1]
 */

public class Problem01 {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 3, -2, 0};
        int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -1};
        System.out.println(maxSumSubarray(arr));
        System.out.println(maxSumSubarray(arr2));
    }

    public static int maxSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        int current_max = arr[0], global_max = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            current_max = Math.max(arr[i], current_max + arr[i]);
            global_max = Math.max(current_max, global_max);

        }

        return global_max;
    }
}
