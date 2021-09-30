package C01_arrays_strings_1;

/*
Given a sorted array in non-decreasing order,
return an array of squares of each number, also in non-decreasing order.
For example:

[-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]

How can you do it in O(n) time?
 */

import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) {
        int[] arr = {-4,-2,-1,0,3,5};
        int[] newArr = orderOfSquares(arr);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] orderOfSquares(int[] arr) {
        if (arr == null)
            return null;
        int start = 0, end = arr.length - 1;
        int[] result = new int[arr.length];
        int index = result.length - 1;

        while (start <= end) {
            int a = arr[start] * arr[start];
            int b = arr[end] * arr[end];

            if (a < b) {
                result[index] = b;
                end--;
            } else {
                result[index] = a;
                start++;
            }
            index--;
        }

        return result;
    }
}
