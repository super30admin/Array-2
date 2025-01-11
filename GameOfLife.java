public class GameOfLife {
    //Time Complexity: O(m*n)
    //Space Complexity: O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 2 is same as 0
        // 3 is same as 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int liveNeighbors = 0;
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
                liveNeighbors++;
            }
        }
        return liveNeighbors;
    }
}