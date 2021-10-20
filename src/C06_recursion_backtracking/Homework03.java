package C06_recursion_backtracking;
/*
Level: MediumSudokuSolver:​ Given a Sudoku board, find a solution.
The board can have some squares filled out already.
You have to fill the rest of the squares.
(Rules of Sudoku are as follows: In each column, row and 3 x 3 square,
you cannot have duplicate numbers. Also, only numbers 1-9 are allowed.)
 */

import C00_utils.Pair;
import C00_utils.SudokuBoardChecker;

import java.util.Arrays;

public class Homework03 {
    public static void main(String[] args) {
        int[][]board = new int[9][9];
        System.out.println("Before the solver");
        System.out.println(Arrays.deepToString(board));

        System.out.println("After the solver");
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(int[][] board) {
        SudokuBoardChecker checker = new SudokuBoardChecker(board);
        boolean success = backtrack(board, 0, 0, checker);
        if (!success) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean backtrack(int[][] board, int i, int j, SudokuBoardChecker checker) {
        if (i == board.length)
            return true;
        Pair next = nextIndexInBoard(i, j);

        if (board[i][j] != 0) {
            return backtrack(board, next.i(), next.j(), checker);
        }

        for (int candidate = 1; candidate <= 9; candidate++) {
            if (checker.canPlace(i, j, candidate)) {
                checker.place(i, j, candidate);
                board[i][j] = candidate;

                if (backtrack(board, next.i(), next.j(), checker)) {
                    return true;
                }

                checker.remove(i, j, candidate);
                board[i][j] = 0;
            }
        }

        return false;
    }

    private static Pair nextIndexInBoard(int i, int j) {
        if (j == 8)
            return new Pair(i + 1, 0);
        else
            return new Pair(i, j + 1);
    }
}
