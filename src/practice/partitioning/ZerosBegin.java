package practice.partitioning;
/*
  Question 1 (discussed in video): You are given an array of integers.
  Rearrange the array so that all zeroes are at the beginning of the array.
  For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
 */

import java.util.Arrays;

public class ZerosBegin {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 1, 0, 3, 0};
        moveZerosBegin(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosBegin(int[] arr) {
        int boundary = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(i, boundary, arr);
                boundary++;
            }
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
