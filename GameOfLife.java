// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :

public class GameOfLife {
    final static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public void gameOfLife(int[][] board) {

        //  mark dead to alive = -1
        //  mark alive to dead = 2
        //  update -1 to 1 and 2 to 0

        if (board.length == 0)
            return;

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++j) {

                if (board[i][j] == 0) {
                    int neighbors = count(board, i, j);
                    if (neighbors == 3)
                        board[i][j] = -1;
                }

                if (board[i][j] == 1) {
                    int neighbors = count(board, i, j);
                    if (neighbors < 2 || neighbors > 3)
                        board[i][j] = 2;
                }
            }

        update(board);
    }

    private int count(int[][] board, int i, int j) {
        int neighbors = 0;

        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2))
                neighbors++;
        }

        return neighbors;
    }

    private void update(int[][] board) {
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == -1)
                    board[i][j] = 1;
                else if (board[i][j] == 2)
                    board[i][j] = 0;
            }
    }
}
