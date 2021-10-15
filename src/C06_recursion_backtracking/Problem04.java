package C06_recursion_backtracking;

/*
Level: Medium
Given an array of integers A, print all its subsets.
For example:
Input: [1, 2, 3]
Output:
[]
[1]
[2]
[3]
[1, 2]
[1, 3]
[2, 3]
[1, 2, 3]
 */

public class Problem04 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printCombos(arr);
    }
    public static void printCombos(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] buffer = new int[arr.length];
        backtrack(arr, buffer, 0, 0);
    }

    private static void backtrack(int[] arr, int[] buffer, int startIndex, int bufferIndex) {
        printArray(buffer, bufferIndex);

        if (bufferIndex == buffer.length) {
            return;
        }
        if (startIndex == arr.length) {
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            buffer[bufferIndex] = arr[i];
            backtrack(arr, buffer, i + 1, bufferIndex + 1);
        }
    }

    private static void printArray(int[] arr, int index) {
        for (int i = 0; i < index; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
