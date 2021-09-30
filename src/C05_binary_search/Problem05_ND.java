package C05_binary_search;

/*
(Level: Medium) Given a sorted array whose length is not known,
perform binary search for a target T.
Do the search in O(log(n)) time.
 */

public class Problem05_ND {

    public int findWithUnknownLength(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int high = 1; // 1, 2, 4, 8, 16, 32...
        int lastIndex = -1;

        while (true) {
            try {
                int temp = arr[high];
            } catch (ArrayIndexOutOfBoundsException e) {
                lastIndex = binarySearchForLastIndex(arr, high/2, high);
                break;
            }
            high *= 2;
        }

        return binarySearchOverRange(arr, target, 0, lastIndex);
    }

    private int binarySearchForLastIndex(int[] arr, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            try {
                int temp = arr[mid];
            } catch (ArrayIndexOutOfBoundsException e) {
                // mid is out of bounds, go to lower half
                high = mid - 1;
                continue;
            }

            try {
                int temp = arr[mid+1];
            } catch (ArrayIndexOutOfBoundsException e) {
                // mid + 1 is out of bounds, mid is last index
                return mid;
            }

            // both mid and mid + 1 are inside array, mid is not last index.
            low = mid + 1;
        }

        return -1; // this subarray does not have end of the array
    }

    private static int binarySearchOverRange(int[] arr, int target, int low, int high)
    {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
