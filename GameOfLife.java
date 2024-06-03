// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int x = board[0].length; 
        int y = board.length; 

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int liveNeighbors = 0; 
                
                for (int[] dir : directions) {
                    int h = j + dir[1]; 
                    int v = i + dir[0]; 
                    if (h >= 0 && h < x && v < y && v >= 0 && (board[v][h] == 1 || board[v][h] == -1)) {
                        liveNeighbors++; 
                    }
                }
                
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; 
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; 
                }
            }
        }
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; 
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; 
                }
            }
        }
    }
}