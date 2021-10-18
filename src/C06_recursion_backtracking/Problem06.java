package C06_recursion_backtracking;
/*
Level: Medium
Maze Problem: You are given a 2D array that represents a maze. It can have 2 values - 0 and 1.
1 represents a wall and 0 represents a path.
The objective is to reach the bottom right corner, i.e, A[A.length-1][A.length-1]. You start from
A[0][0]. You can move in 4 directions - up, down, left and right. Find if a path exists to the
bottom right of the maze.

For example, a path exists in the following maze:
0 1 1 1
0 1 1 1
0 0 0 0
1 1 1 0
 */

public class Problem06 {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };

        System.out.println(isPathExist(maze));
    }

    public static boolean isPathExist(int[][] maze) {
        return false;
    }
}
