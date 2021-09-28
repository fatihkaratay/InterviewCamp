package binary_search;
/*
You are given a sorted array A and a target T.
Return the index where T would be placed if inserted in order.

For example,
A = [1,2,4,5,6,8] and T = 3, return index 2
A = [1,2,4,5,6,8] and T = 0, return index 0
A = [1,2,4,5,6,8] and T = 4, return index 3.
*/

public class Problem01 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8};
        int t1 = 3;
        int t2 = 0;
        int t3 = 4;

        System.out.println(getIndex(arr, t1));
        System.out.println(getIndex(arr, t2));
        System.out.println(getIndex(arr, t3));
    }

    public static int getIndex1(int[] arr, int t) {
        int i = 0;
        while (i <= arr.length - 1) {
            if (t > arr[i])
                i++;
            else if (arr[i] == t)
                i++;
            else if (t < arr[i])
                break;
        }

        return i;
    }

    public static int getIndex(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }

        if (arr.length == 0) {
            return 0;
        }

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                if (mid == arr.length -1) {
                    return arr.length;
                } else {
                    start = mid + 1;
                }
            } else {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
