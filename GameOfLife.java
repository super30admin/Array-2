/**
Time complexity: O(n*m)
Space complexity: O(1)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/

class Solution {
    /**
    Approach:
    - The approach is to first compute the count of live cells around each element in every direction.
    - Replace the element with 2 if it was alive but going to be dead.
    - Replace the element with 3 if it was dead but going to be alive.
    */
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int count = countLives(board, i, j, n, m); 
                if(board[i][j] == 1 && (count > 3 || count < 2)) {
                    board[i][j] = 2;
                } else if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j, int n, int m) {
        int[][] dirs = {{1,-1}, {1,0}, {1,1}, {0,-1}, {0,1}, {-1,-1}, {-1,0}, {-1,1}};
        int count = 0;
        
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < n && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 2)) {
                count += 1;
            }
        }
        return count;
    }
}
