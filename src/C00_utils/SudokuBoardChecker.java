package C00_utils;

public class SudokuBoardChecker {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];

    public SudokuBoardChecker(int[][] board) {
        // add existing numbers to the checker.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    place(i, j, board[i][j]);
                }
            }
        }
    }

    public boolean place(int i, int j, int number) {
        if (!canPlace(i, j, number)) {
            return false;
        }

        row[i][number] = true;
        col[j][number] = true;
        box[boxNumber(i, j)][number] = true;

        return true;
    }

    public boolean canPlace(int i, int j, int number) {
        if (row[i][number]) return false;
        if (col[j][number]) return false;

        if (box[boxNumber(i, j)][number]) return false;

        return true;
    }

    public int boxNumber(int i, int j) {
        // Note: (i/3) * 3 is not the same as i
        // for all int values, i/3 gets reduced to floor (i / 3)
        return (i/3)*3 + (j/3);
    }

    public void remove(int i, int j, int number) {
        row[i][number] = false;
        col[j][number] = false;
        box[boxNumber(i, j)][number] = false;
    }
}
