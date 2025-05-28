// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] dirs = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0},
            {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(board, i, j, dirs);
                
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 5; // Alive -> Dead
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 4; // Dead -> Alive
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 4) {
                    board[i][j] = 1;
                } else if (board[i][j] == 5) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countAlive(int[][] board, int x, int y, int[][] dirs) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (board[nx][ny] == 1 || board[nx][ny] == 5) {
                    count++;
                }
            }
        }

        return count;
    }
}
