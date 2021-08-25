package practice.partitioning;

/*
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in the list. One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 * Example:
 *
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Explanation: The missing number from 1 to 8 is 5
 */

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(getMissingNumber(arr));
    }

    public static int getMissingNumber(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = getMax(arr);
        int total = ((max) * (max + 1)) / 2;
        int totalArr = 0;
        for (int num : arr)
            totalArr += num;

        return total - totalArr;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        return max;
    }
}
