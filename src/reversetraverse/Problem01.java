package reversetraverse;

import java.util.Arrays;

public class Problem01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 4, 0};
        System.out.println(Arrays.toString(arr));
        duplicateEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void duplicateEven(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i] = arr[i-1];
            }
        }
    }
}
