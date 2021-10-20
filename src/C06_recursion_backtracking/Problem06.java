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

import C00_utils.Pair;

import java.util.Arrays;

public class Problem06 {
    private enum State {
        UNVISITED,
        VISITING,
        NO_PATH_FOUND
    }

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
        if (maze == null || maze.length == 0)
            return false;

        State[][] memo = new State[maze.length][maze[0].length];

        for (State[] states : memo) {
            Arrays.fill(states, State.UNVISITED);
        }

        return backtrack(maze, 0, 0, memo);
    }

    private static boolean backtrack(int[][] maze, int i, int j, State[][] memo) {
        if (oob(maze, i, j) || maze[i][j] == 1)
            return false;
        if (i == maze.length-1 && j == maze[0].length-1)
            return true;
        if (memo[i][j] == State.NO_PATH_FOUND || memo[i][j] == State.VISITING)
            return true;
        memo[i][j] = State.VISITING;

        Pair[] points = {
                new Pair(i + 1, j),
                new Pair(i - 1, j),
                new Pair(i, j + 1),
                new Pair(i, j - 1)
        };

        for (Pair point : points) {
            if (backtrack(maze, point.i(), point.j(), memo)) {
                return true;
            }
        }

        memo[i][j] = State.NO_PATH_FOUND;

        return false;
    }

    private static boolean oob(int[][] maze, int i, int j) {
        return i < 0 || i >= maze.length || j < 0 || j >= maze[0].length;
    }
}


