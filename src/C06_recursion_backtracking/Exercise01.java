package C06_recursion_backtracking;
/*
print all combinations of given string in length of x
 */

public class Exercise01 {

    public static void main(String[] args) {
        String str = "ABCD";
        char[] arr = str.toCharArray();

        printCombos(arr, 3);
    }

    public static void printCombos(char[] arr, int x) {
        if (arr == null || arr.length == 0 || x > arr.length) {
            return;
        }

        char[] buffer = new char[x];
        backtrack(arr, buffer, 0, 0);
    }

    private static void backtrack(char[] arr, char[] buffer, int startIndex, int bufferIndex) {
        if (bufferIndex == buffer.length) {
            printArray(buffer);
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

    private static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
