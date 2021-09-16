package subarray;
/*
(Level: Medium) Given an array of integers,
find the contiguous subarray that sums to 0.
The array can contain both negative and positive integers.

For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr1 = {2,4,-2,1,-3,5,-3};
        int[] arr = {-1, 2, 1, -4, 2, 3, -1, 2};
        System.out.println(Arrays.toString(prefixSum(arr1)));
        System.out.println(Arrays.toString(prefixSum(arr)));
    }

    public static int[] prefixSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) return new int[] {0, i};
            if (map.containsKey(sum)) {
                return new int[] { map.get(sum) + 1, i};
            }
            map.put(sum, i);
        }

        return new int[] {};
    }


}
