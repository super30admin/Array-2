// Time Complexity: O(m*n)
// Space Complexity: O(1)
// Runs on LeetCode: Yes
class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int liveCount = getLiveCount(board, i, j);

                if (board[i][j] == 1 && liveCount < 2) {
                    board[i][j] = 4;
                } else if (board[i][j] == 1 && liveCount > 3) {
                    board[i][j] = 4;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 5;
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 4) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 5) {
                    board[i][j] = 1;
                }

            }
        }
    }

    private int getLiveCount(int[][] board, int i, int j) {
        int[][] dirs = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
        int count = 0;

        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
                if (board[row][col] == 1 || board[row][col] == 4) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

}