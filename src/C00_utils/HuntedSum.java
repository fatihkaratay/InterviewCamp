package C00_utils;

import java.util.Arrays;

public class HuntedSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,0},
                {0,5,0,1},
                {2,1,3,10}
        };

        System.out.println(huntedSum(matrix));
    }

    private static int huntedSum(int[][] matrix) {
        // modify the matrix if current value is 0, update all
        // below values as zero
        System.out.println(Arrays.deepToString(matrix));
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    // set all columns to zero
                    for (int i = row; i < matrix.length; i++) {
                        matrix[i][col] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return 0;
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                sum += matrix[row][col];

        return sum;
    }
}
