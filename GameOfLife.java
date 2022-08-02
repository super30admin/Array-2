// Time Complexity : O(mn), where m = number of rows of matrix, n = number of columns of matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 1. Iterate through the board and check for alive neighbors count for each element, if given rules are not satisfies, change the state of element from 1 to 2 and from 0 to 3.
// 2. After changing values of elements to 2 & 3 wherever required, iterate through the matrix again and change the state of elements from 2 to 0 and from 3 to 1.

//289. Game of Life (Medium) - https://leetcode.com/problems/game-of-life/
class Solution {
    int m, n;
    int[][] dirs;
    
    public void gameOfLife(int[][] board) {
        if (board == null || board[0].length == 0) return;
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int aliveCount = getAliveCount(board, i, j);
                
                if (board[i][j] == 1 && (aliveCount < 2 || aliveCount > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && aliveCount == 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int getAliveCount(int[][] board, int i, int j) {
        int count = 0;
        
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        
        return count;
    }
}