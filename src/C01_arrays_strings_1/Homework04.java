package C01_arrays_strings_1;
/*
Given an array with n marbles colored Red, White or Blue,
sort them so that marbles of the same color are adjacent,
with the colors in the order Red, White and Blue.
Assume the colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
 */

import java.util.Arrays;

public class Homework04 {
    public static void main(String[] args) {
        int[] marbles = {1,0,2,1,2,1,0,1,2,0};
        int pivot = 1;
        sortMarbles(marbles, pivot);
        System.out.println(Arrays.toString(marbles));
    }

    private static void sortMarbles(int[] marbles, int pivot) {
        if (marbles == null || marbles.length == 0) throw new IllegalArgumentException();

        int low = 0, i = 0, high = marbles.length - 1;
        while (i <= high) {
            if (marbles[i] < pivot) {
                swap(marbles, i, low);
                low++;
                i++;
            } else if (marbles[i] > pivot) {
                swap(marbles, i, high);
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
