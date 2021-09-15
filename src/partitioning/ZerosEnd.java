package partitioning;
/*
    Question 2 (discussed in the video below):
    Now, given an array, move all zeroes to the end of the array.
    For example, [4,2,0,1,0,3,0] -> [4,1,2,3,0,0,0]
 */

import java.util.Arrays;

public class ZerosEnd {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 1, 0, 3, 0};
        moveZerosEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosEnd(int[] arr) {
        int boundary = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                swap(i, boundary, arr);
                boundary--;
            }
        }
    }
    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
