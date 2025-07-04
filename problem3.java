// Time Complexity: O(m * n)
// Space Complexity: O(1)

// Using 2 to denote a live cell becoming dead
// Using 3 to denote a dead cell becoming live


class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length; // rows
        int n = board[0].length; // cols

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int count = countLiveNeighbors(board, i, j);
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                } 
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                } 
            }
        }


        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } 
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } 
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && 
            (board[nr][nc] == 1 || board[nr][nc] == 3)) {
                count++;
            }
        }
        return count;
    }
}
