package subarray;
/*
(Level: Easy) Given an array of positive integers,
find the contiguous subarray that sums to a given number X.

For example, input = [1,2,3,5,2] and X=8, Result = [3,5]
 */

import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,2};
        int target = 8;
        int[] result = subarraySum(arr, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] subarraySum(int[] arr, int target) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();

        int i = 0, j = 0, sum = arr[0];
        while (i < arr.length) {
            if (i > j) {
                j = i;
                sum = arr[i];
            }
            if (sum < target){
                if (j == arr.length - 1) {
                    break;
                }
                j++;
                sum += arr[j];
            } else if (sum > target){
                sum -= arr[i];
                i++;
            } else {
                return new int[] {i, j};
            }

        }
        return new int[]{};
    }
}
