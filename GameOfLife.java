class GameOfLife 
{
   //Time Complexity: O(m * n)
   // Space Complexity: O(1)
   
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for 8 possible neighbors (up, down, left, right, and diagonals)
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        // First pass: Apply transition encoding
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k], nj = j + dy[k];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && (board[ni][nj] == 1 || board[ni][nj] == 2)) {
                        liveNeighbors++;
                    }
                }

                // Apply Game of Life rules using encoded values
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;  // Mark as 'died' (1 -> 0)
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;  // Mark as 'revived' (0 -> 1)
                    }
                }
            }
        }

        // Second pass: Finalize updates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;  // Dead
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;  // Alive
                }
            }
        }
    }
}

