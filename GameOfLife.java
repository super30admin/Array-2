// Time Complexity : O(8(m * n)) =~ O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Rules: (cell == 1) && (live < 2 or live > 3) make it 0. (cell == 0 && live == 3) make it 1. To find live we need to traverse in  all 8 directions
* Use dirs array for direction int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1, 1}, {1, -1}, {1,1}}; //U, D, L, R, UL, UR, LL, LR
* As creating new grid will take space, we optimize it by 1 -> 0 = 2 and 0 -> 1 = 3 and then traverse again to revert and return next state.
*/

public class GameOfLife {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) {
            return;
        }
        
        m = board.length;
        n = board[0].length;
        //1 -> 0 = 2; 0 -> 1 = 3

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countLive(board, i , j);
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                } 
                else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                } 
                else {
                    board[i][j] = board[i][j];
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } 
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }

    private int countLive(int[][] board, int row, int col) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1, 1}, {1, -1}, {1,1}};
        //U, D, L, R, UL, UR, LL, LR
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int nr = row + dirs[i][0];
            int nc = col + dirs[i][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}
