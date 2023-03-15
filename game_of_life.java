// Time Complexity : O(mn); m = board.length, n = board[0].length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class Solution {
    int[][] dirs = new int[][] { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,0}, {1,-1}, {1,1}};

    private int[][] checkCell(int row, int col, int[][] board) {
        int countLive = 0;

        for(int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            // If out of bounds, ignore
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }

            if(board[x][y] == 1 || board[x][y] == 3) {
                countLive += 1;
            }
        }

        // Dead -> Alive
        if(board[row][col] == 0 && countLive == 3) {
            board[row][col] = 2;
        }
        // Alive -> Dead
        else if(board[row][col] == 1 && (countLive < 2 || countLive > 3)) {
            board[row][col] = 3;
        }

        return board;
    }

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board = checkCell(i, j, board);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // If dead cell
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}