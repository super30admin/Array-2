
public class Solution {

    // LeetCode Problem #289
    // Time Complexity - O(n^2)
    // Space Complexity - O(1)

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private int countNeighbors(int[][] board, int i, int j) {
        int neighbors = 0;

        for (int k = 0; k < 8; k++) {
            int row = i + dx[k], col = j + dy[k];
            if (isValid(board, row, col)) {
                if(board[row][col] == 1 || board[row][col] == -1) {
                    neighbors++;
                }
            }
        }

        return neighbors;
    }

    private boolean isValid(int[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countNeighbors(board, i, j);

                if (board[i][j] == 1) { 
                    if (count < 2 || count > 3) { 
                        board[i][j] = -1;
                    }
                } else { 
                    if (count == 3) { 
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }

                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

}