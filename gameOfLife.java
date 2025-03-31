class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions to check all 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // First pass: mark changes without affecting original state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, directions);

                // Rule 1 and Rule 3: Mark dead (1 -> 0) or alive (0 -> 1)
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // 1 -> 0 (marked as 2 temporarily)
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // 0 -> 1 (marked as 3 temporarily)
                }
            }
        }

        // Second pass: Apply the marked changes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Die
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1; // Become alive
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int[][] directions) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check if neighbor is valid and alive (1 or was 1 but marked as 2)
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
                count++;
            }
        }
        return count;
    }
}
