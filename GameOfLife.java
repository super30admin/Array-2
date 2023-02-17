// TC: O(m x n)
// SC: O(1) No extra space used other than original input matrix

class Solution {

    int m, n;
    int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    private int getCount(int[][] board, int i, int j) {
        int count = 0;
        for(int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        // 1 -> 0 : 2
        // 0 -> 1 : 3
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = getCount(board, i, j);
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}