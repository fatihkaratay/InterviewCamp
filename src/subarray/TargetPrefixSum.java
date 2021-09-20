package subarray;
/*
Given an array of integers, both -ve and +ve, find a contiguous subarray that sums to a numberX.
For example: [2,4,-2,1,-3,5,-3], X = 5 --> Result = [2,4,-2,1]
*/

import java.util.Arrays;
import java.util.HashMap;

public class TargetPrefixSum {
    public static void main(String[] args) {
        int[] arr = {2,4,-2,1,-3,5,-3};
        int target1 = 5;
        int target2 = -1;
        System.out.println(Arrays.toString(targetSumSubarray(arr, target1)));
        System.out.println(Arrays.toString(targetSumSubarray(arr, target2)));
    }

    private static int[] targetSumSubarray(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == target) return new int[] {0, i};

            if (map.containsKey(sum - target)) return new int[] {
                    map.get(sum - target) + 1, i
            };

            map.put(sum, i);
        }


        return null;
    }
}
