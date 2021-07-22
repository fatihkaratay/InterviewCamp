package practice;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8};
        int target = 10;

        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] arr, int target) {
        if (arr == null)
            throw new IllegalArgumentException();
        if (arr.length == 0)
            return new int[]{};
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == target)
                return new int[] {start, end};
            else if (arr[start] + arr[end] > target)
                end--;
            else if (arr[start] + arr[end] < target)
                start++;
        }

        return arr;
    }
}
