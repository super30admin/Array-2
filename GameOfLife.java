/**
 * Time complexity is O(n^2)
 * space complexity id O(1)
 */
class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        dirs = new int[][] {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = getLiveCount(i, j, board, m, n);
                if(board[i][j] == 0) {
                    if(count == 3) {
                        board[i][j] = 2;
                    }
                }
                else {
                    if(count < 2 || count > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int getLiveCount(int i, int j, int[][] board, int m, int n) {
        int count = 0;
        for(int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            
            if(r >= 0 && r < m &&  c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3)) {
                count++;
            }
        }
        return count;
    }
}