class Solution {

    // TC: O(m * n)
    // SC: O(1)
    int m, n;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        
        m = board.length;
        n = board[0].length;
        
        // 1 ---> 0 return 2
        // 0 ---> 1 return 3
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);
                if (board[i][j] == 0) { 
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                } 
                else {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0; // count live neighbors
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}