public class GameOfLife {
    class Solution {
        private int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int aliveCells = countAlive(board, i, j);
                    if (board[i][j] == 1 && (aliveCells < 2 || aliveCells > 3)) { // Cell Dies
                        board[i][j] = -1;
                    } else if (board[i][j] == 0 && aliveCells == 3) {
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

        private int countAlive(int[][] board, int row, int col) {
            int count = 0;
            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                if (currRow >= 0 && currRow < board.length && currCol >= 0 && currCol < board[0].length
                        && (board[currRow][currCol] == 1 || board[currRow][currCol] == -1)) {
                    count++;
                }
            }
            return count;
        }
    }
}
