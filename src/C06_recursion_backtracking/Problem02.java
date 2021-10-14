package C06_recursion_backtracking;

/*
Given an array of integers, print all combinations of size X.
(Level: Medium) Print all combinations of length 3.
No duplication.
 */

public class Problem02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 3;

        printCombos(arr, 4);
    }

    public static void printCombos(int[] arr, int x) {
        if (arr == null || arr.length == 0 || x > arr.length)
            return;

        int[] buffer = new int[x];

        printCombosHelper(arr, buffer, 0, 0);
    }

    private static void printCombosHelper(int[] arr, int[] buffer, int startIndex, int bufferIndex) {
        // termination cases
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }
        if (startIndex == arr.length) {
            return;
        }

        // implementing the backtracking
        for (int i = startIndex; i < arr.length; i++) {
            buffer[bufferIndex] = arr[i];

            printCombosHelper(arr, buffer, i + 1, bufferIndex + 1);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
