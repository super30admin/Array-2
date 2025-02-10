// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :There were a lot of if conditions and boundary cases but I learned a lot of new things.Easy but tedious
public class GameOfLife {
    int r, c;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        r = board.length;
        c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int countLiveNeighbours = getLiveNeighbours(board, i, j);
                if (board[i][j] == 1) {
                    if (countLiveNeighbours < 2 || countLiveNeighbours > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (countLiveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 1;
                if (board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    private int getLiveNeighbours(int[][] board, int i, int j) {
        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < r && nc >= 0 && nc < c && (board[nr][nc] == 1 || board[nr][nc] == 2))
                count++;
        }
        return count;
    }
}