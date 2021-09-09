package practice.partitioning;
/*
Question 3 (discussed in video below): (Level: Medium)
Dutch National Flag Problem: Given an array of integers A and a pivot,
rearrange A in the following order:

[Elements less than pivot, elements equal to pivot, elements greater than pivot]

For example, if A = [5,2,4,4,6,4,4,3] and pivot = 4 -> result = [3,2,4,4,4,4,6,5]
 */

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {5,2,4,4,6,4,4,3};
        int pivot = 4;
        partitionArray(arr, pivot);
        System.out.println(Arrays.toString(arr));
    }

    private static void partitionArray(int[] arr, int pivot) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int low = 0, high = arr.length - 1, i = 0;
        while (i <= high) {
            if (arr[i] < pivot) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
