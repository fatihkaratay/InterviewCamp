package C01_arrays_strings_1;

/*
Given an array of numbers, replace each even number with two of the same number.
e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].
Assume that the array has the exact amount of space to accommodate the result.
*/

import java.util.Arrays;

public class Problem01 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, -1, -1};
        int[] arr2 = {1, 2, 5, 6,8, -1, -1, -1, -1};
        int[] arr3 = {2, 4, 6, -1, -1, -1};
        int[] arr4 = {1, 3, 5};
        int[] arr5 = {};
        int[] arr6 = null;

        System.out.println(Arrays.toString(cloneEvenNumbers(arr1)));
        System.out.println(Arrays.toString(cloneEvenNumbers(arr2)));
        System.out.println(Arrays.toString(cloneEvenNumbers(arr3)));
        System.out.println(Arrays.toString(cloneEvenNumbers(arr4)));
        System.out.println(Arrays.toString(cloneEvenNumbers(arr5)));
        System.out.println(Arrays.toString(cloneEvenNumbers(arr6)));


    }

    private static int[] cloneEvenNumbers(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        int i = findLastValidIndex(arr), j = arr.length;

        while (i >= 0) {
            if (arr[i] % 2 == 0) {
                arr[--j] = arr[i];
                arr[--j] = arr[i];
            } else {
                arr[--j] = arr[i];
            }
            i--;
        }

        return arr;
    }

    private static int findLastValidIndex(int[] a) {
        int i = a.length - 1;
        while (i >= 0 ) {
            if (a[i] != -1){
                break;
            }
            i--;
        }
        return i;
    }

    private static int findLastValidIndex2(int[] a) {
        int i = a.length - 1;
        while (i >= 0 && a[i] == -1) {
            i--;
        }
        return i;
    }
}
