// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Updating a board based on the current state of cells and their neighbors, following the
// game's rules, and using a temporary state.

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Count live neighbors of the current cell
                int alives = countAlives(board, i, j, m, n);
                if (board[i][j] == 1 && (alives < 2 || alives > 3)) {
                    board[i][j] = 2; // Mark cell as dying (temp state)
                } else if (board[i][j] == 0 && alives == 3) {
                    board[i][j] = 3; // Mark cell as becoming alive (temp state)
            }
        }

        // Update the board based on the temporary states (2 and 3)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlives(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        // Directions: right, left, down, up, and the four diagonals
        int[][] dirs = new int[][]{{0,1}, {0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            // Check if the new row and column are within bounds and if the cell is alive (1 or 2)
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}