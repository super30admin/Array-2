// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class Main {
    private static int m;
    private static int n;
    private static int[][] dirs;

    public static void gameOfLife(int[][] board) {
        // null case
        if (board == null || board.length == 0)
            return;

        m = board.length;
        n = board[0].length;

        // if 0 --> 1 .... 2
        // if 1 --> 0 .... 3
        // for the direction we are using direction array
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        // for traversal through board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // count alive neighbours
                int aliveNeighbour = countAliveNeighbours(board, i, j);

                // if alive neighbours less than 2 or greater than 3 alive will be dead
                if (board[i][j] == 1 && (aliveNeighbour < 2 || aliveNeighbour > 3)) {

                    // to preserve old state 1-->0 become 3
                    board[i][j] = 3;
                }
                // if alive neighbours is equal to 3 dead will become alive
                if (board[i][j] == 0 && aliveNeighbour == 3) {
                    // to preserve old state 0 --> 1 become 2
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // to get back to the real state
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        for (int[] b : board) {
            System.out.println(Arrays.toString(b));

        }
    }

    // to count alive child
    private static int countAliveNeighbours(int[][] board, int i, int j) {
        int count = 0;
        // traverse in each direction
        for (int[] dir : dirs) {

            // here r is row of the neighbour
            int r = i + dir[0];
            // c is column of the neighbour
            int c = j + dir[1];
            // here we are checking it is in the bound and here we are also comparing with 3
            // as it is previously 1
            if (r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 3)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(board);

    }
}