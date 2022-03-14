// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    
    private int[][] directions = new int[][] {
      
        // i   j
       // row col
        { -1, -1 }, // LEFT UP
        { -1,  0 }, // UP
        { -1,  1 }, // RIGHT UP
        {  0,  1 }, // RIGHT
        {  1,  1 }, // RIGHT DOWN
        {  1,  0 }, // DOWN
        {  1, -1 }, // LEFT DOWN
        {  0, -1 }, // LEFT
        
    };
    
    private int getLiveNeighbourCount(int[][] board, int i, int j) {
        
        int liveNeighbourCount = 0;
        
        int m = board.length;
        int n = board[0].length;
        
        for (int[] direction : directions) {
            
            int x = i + direction[0];
            int y = j + direction[1];
            
            if (x >= 0 && x < m && y >= 0 && y < n) {
                
                // maintaining and incrementing count for state changes
                if (board[x][y] == -2 || board[x][y] == 1) {
                    liveNeighbourCount++;
                }
            }
        }
        
        return liveNeighbourCount;
    }
    
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        // marking 0 to 1 as -1
        // marking 1 to 0 as -2
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int liveNeighbourCount = getLiveNeighbourCount(board, i, j);
                
                // initially if cell is live
                if (board[i][j] == 1) {
                    
                    // < 2 means dead
                    // == 2 || == 3 means alive
                    // > 3 means dead
                    if (liveNeighbourCount < 2 || liveNeighbourCount > 3) {
                        // cell changes from live to dead, 1 -> 0
                        board[i][j] = -2;
                    }
                }
                
                else { // cell dead
                    if (liveNeighbourCount == 3) {
                        // cell changes from dead to alive, 0 -> 1
                        board[i][j] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // now convert any -1 or -2 back to 1 and 0
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                
                if(board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }
    }
}