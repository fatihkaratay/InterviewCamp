package C01_arrays_strings_1;
/*
(Level: Easy) Reverse the order of elements in an array.
For example, A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
 */

import java.util.Arrays;

public class Problem02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        reverseOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();

        int start = 0, end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
