package C05_binary_search;

/*
(Level: Easy) Given a sorted array that can contain duplicates,
find the first occurrence of a target element T.
For example, if A = [2,3,4,4,5,6] and T = 4, return index 2.
*/

public class Problem02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 5, 7, 8, 11};
        int target = 4;

        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid] || target == arr[mid] && mid >0 && arr[mid-1] == target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
