//time O(mn)
//space O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int ones = 0;
                int zeroes = 0;
                for(int[] dir: dirs) {
                    int r = dir[0] + i;
                    int c = dir[1] + j;
                    if(r < m && r >=0 && c < n && c >=0 && (board[r][c] == 1 || board[r][c] == 110)) {
                        ones++;
                    } else {
                        zeroes++;
                    }
                }
                if(board[i][j] == 1 && (ones < 2 || ones > 3)) {
                    board[i][j] = 110;
                } else if(board[i][j] == 0 && ones == 3) {
                    board[i][j] = 101;
                }
            }
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 110) {
                    board[i][j] = 0;
                } else if(board[i][j] == 101) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
