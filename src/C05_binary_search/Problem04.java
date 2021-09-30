package C05_binary_search;

/*
Given an array that is cyclically sorted, find the minimum element.
A cyclically sorted array is a sorted array rotated by some number of elements.
Assume all elements are unique.
For example:A = [4,5,1,2,3], which is just [1,2,3,4,5] rotated by 2
Result = index 2
 */

public class Problem04 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        System.out.println(getMinCycledArray(arr));
    }

    public static int getMinCycledArray(int[] arr) {
        if (arr == null) return -1;

        int start = 0, end = arr.length - 1, right = arr[arr.length - 1];

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] <= right && (mid == 0 || arr[mid-1] > arr[mid])) {
                return mid;
            } else if (arr[mid] > right) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
