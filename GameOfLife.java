// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// mapped cells which go from 0 -> 1 as -2 and 1 -> 0 as -1.
// This helped preserve the state and then at the end reversed the mapping

class GameOfLife {
    int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
            { 0, -1 } };

    public void gameOfLife(int[][] board) {
        // map live->dead cell : 1 -> 0 with -1
        // map dead->live cell : 0 -> 1 with -2
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int sum = sumOfNeighbors(i, j, board);
                if (board[i][j] == 1 && (sum > 3 || sum < 2)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && sum == 3) {
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int sumOfNeighbors(int i, int j, int[][] board) {
        int sum = 0;
        // traversing the 8 directions
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
                // if it's -2 that means it became alive after
                sum += board[row][col] == -2 ? 0 : Math.abs(board[row][col]);
            }
        }
        return sum;
    }
}