package binary_search;
/*
(Level: Easy) Given a sorted array A and a target T, find the target.
If the target is not in the array, find the number closest to the target.

For example, if A = [2,3,5,8,9,11] and T = 7,
return index of 8, i.e. return 3.
*/

public class ClosestSearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,8,9,11};
        int target = 7;

        System.out.println(getClosest(arr, target));
    }

    public static int getClosest(int[] arr, int target) {
        if (arr == null) return -1;

        int start = 0, end = arr.length - 1, result = -1;

        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid = start + ((end - start) >> 1);
            result = record(arr, mid, result, target);
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return result;
    }

    private static int record(int[] arr, int mid, int result, int target) {
        if (result == -1) {
            return mid;
        } else if (Math.abs(arr[mid] - target) < Math.abs(arr[result] - target)) {
            return mid;
        }

        return result;
    }
}
