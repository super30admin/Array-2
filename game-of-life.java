//Space Complexity is O(1)
//Time Complexity is O(mn) where m is rows and n is cols
class Solution {
    int m, n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        // 1->0 or when live becomes dead we change it to 2
        // 0->1 or when dead becomes alive we change it to 3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    // live cell

                    if (count < 2 || count > 3) {
                        // it dies
                        board[i][j] = 2;
                    }

                } else {
                    // dead cell
                    if (count == 3) {
                        // becomes alive
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }

                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n
                    && (board[newRow][newCol] == 2 || board[newRow][newCol] == 1)) {
                count++;
            }
        }

        return count;
    }
}