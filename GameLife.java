/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(1)
 * */
public class GameLife {
    int rows, cols;

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board == null) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int countLiveNeigh = countLives(board, i, j);
                if (board[i][j] == 0) {
                    if (countLiveNeigh == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (countLiveNeigh < 2) {
                        board[i][j] = 3;
                    }

                    if (countLiveNeigh > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLives(int[][] board, int row, int col) {
        int count = 0;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        for (int[] dir : direction) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                    (board[nr][nc] == 1 || board[nr][nc] == 3)) {
                count++;
            }
        }

        return count;
    }
}
