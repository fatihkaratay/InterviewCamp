package C06_recursion_backtracking;

/*
    Level: Medium
    Given an array A, print all permutations of size X.
    For example,
    Input:
    A = [1,2,3]
    X = 2
    Output:
    [1, 2]
    [1, 3]
    [2, 1]
    [2, 3]
    [3, 1]
    [3, 2]
 */

public class Problem05 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int x = 2;

        printPerms(arr, x);
    }

    public static void printPerms(int[] arr, int x) {
        if (arr == null || arr.length == 0 || x > arr.length) {
            return;
        }

        int[] buffer = new int[x];
        boolean[] isInBuffer = new boolean[arr.length];

        backtract(arr, buffer, 0, isInBuffer);
    }

    private static void backtract(int[] arr, int[] buffer, int bufferIndex, boolean[] isInBuffer) {
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isInBuffer[i]) {
                buffer[bufferIndex] = arr[i];
                isInBuffer[i] = true;
                backtract(arr, buffer, bufferIndex + 1, isInBuffer);
                isInBuffer[i] = false;
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int item : arr)
            System.out.print(item + " ");
        System.out.println();
    }
}
