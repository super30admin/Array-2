// TC: O(m*n)
// SC: O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int m = board.length;
        int n = board[0].length;

        // Iterate over each cell to mark the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j, dirs);
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // Dead => Alive
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; // Alive => Dead
                }
            }
        }

        // Update the board with the final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Dead
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Alive
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
