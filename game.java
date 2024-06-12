// Time Complexity : O(nxm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int countLive = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1) { // live cell
                    if (countLive < 2 || countLive > 3) { // live to dead conditions
                        board[i][j] = 2;
                    }
                } else { // dead cell
                    if (countLive == 3) { //dead to live condition
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) { // iterating to change 3  to 0 and 2 to 1
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }

            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 },
                { 1, -1 } }; // direction array
        int nr = board.length, nc = board[0].length;
        int count = 0;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < nr && c < nc && r >= 0 && c >= 0 && (board[r][c] == 1 || board[r][c] == 2)) { // if alive
                count++;
            }
        }

        return count;

    }

}