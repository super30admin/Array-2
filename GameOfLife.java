// Time Complexity :O(N * M) N = Rows, M = Columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments exftplaining your approach
//1. Check for all the neighboring values of the numbers and keep a count of the live variables
//2. By checking the account we can modify the existing values as live or dead. 
class GameOfLife {
    public int[][] gameOfLife(int[][] board) {
        if (board.length == 0 || board == null)
            return new int[0][0];

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int alive = countALive(board, n, m, i, j);

                if (board[i][j] == 1 && (alive < 2 || alive > 3))
                    board[i][j] = 4;

                else if (board[i][j] == 0 && alive == 3)
                    board[i][j] = 2;

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
        return board;
    }

    int countALive(int[][] board, int n, int m, int i, int j) {
        int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int count = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < n && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 4))
                count++;
        }
        return count;

    }

    public static void main(String args[]) {
        GameOfLife obj = new GameOfLife();
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        int num[][] = obj.gameOfLife(board);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                System.out.print(" " + num[i][j]);
            }
            System.out.println("");

        }
    }
}