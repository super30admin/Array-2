// Time Complexity : O(m*n); m = #rows; n = #cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 0 -> 1 : 2
        // 1 -> 0 : -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = board[i][j];
                int count = countNeighbors(board, i, j, m, n);
                if (cell == 0 && count == 3)
                    board[i][j] = 2;
                if (cell == 1 && (count < 2 || count > 3))
                    board[i][j] = -1;

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                if (board[i][j] == -1)
                    board[i][j] = 0;
            }
        }


    }
    private int countNeighbors(int a[][], int i, int j, int m, int n) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        int live = 0;
        for(int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < m && c >= 0 && c < n && (a[r][c] == 1 || a[r][c] == -1))
                live++;
        }
        return live;
    }
}
