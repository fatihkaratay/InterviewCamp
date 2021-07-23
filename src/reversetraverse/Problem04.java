package reversetraverse;

import java.util.Arrays;

public class Problem04 {
    public static void main(String[] args) {
        int[] arr = {0,2,3,1,8,6,9}; //  result = [2,3,1,8,6] = [1,5]
        int[] result = shortestUnsortedSubarray(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shortestUnsortedSubarray(int[] arr) {
        if (arr == null)
            return null;
        int start, end;

        // find the first dip
        for (start = 0; start < arr.length; start++)
            if (arr[start + 1] < arr[start])
                break;

        // find the first bump
        for (end = arr.length - 1; end >= 0; end--)
            if (arr[end - 1] > arr[end])
                break; // 1, 2, 3, 4, 5, 6, 5, 4,

        // find the min and max in the arr[start, end]
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = start; k <= end; k++) {
            if (arr[k] > max)
                max = arr[k];
            if (arr[k] < min)
                min = arr[k];
        }

        // expand start and end outward
        while (start > 0 && arr[start - 1] > min)
            start--;
        while (end < (arr.length - 1) && arr[end + 1] < max)
            end++;

        return new int[]{start, end};
    }
}
