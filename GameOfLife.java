// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] nextState = new int[m][n];

        // Define the eight possible directions to explore the neighbors
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Iterate over each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Count the live neighbors of the current cell
                int liveNeighbors = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // Check if the neighbor is within the bounds of the board
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the rules to determine the next state of the cell
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextState[i][j] = 0;
                    } else {
                        nextState[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextState[i][j] = 1;
                    } else {
                        nextState[i][j] = 0;
                    }
                }
            }
        }

        // Copy the next state back to the original board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }
}
