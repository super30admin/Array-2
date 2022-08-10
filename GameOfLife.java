// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    /*
     * In-place modification of the board
     * For temporary modification, we mark 1 - 0 transition as 3
     * We mark 0 - 1 transition as 2
     * Take into 3 into consideration while calculating live cells as it is currently a live cell while processing
     */
    
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] dirs = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        
        for (int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int live_neighbors = getLiveNeighbors(i, j, board, rows, cols, dirs);
                
                if (board[i][j] == 1) {
                    if (live_neighbors < 2 || live_neighbors > 3) {
                        board[i][j] = 3;
                    }
                }
        
                if (board[i][j] == 0) {
                    if (live_neighbors == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        // process the 2s and 3s at the end to get the new state
        
        for (int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
    
    private int getLiveNeighbors(int i, int j, int[][] board, int rows, int cols, int[][] dirs) {
        int live = 0;
        
        for (int[] dir: dirs) {
            
            int neighbor_x = i + dir[0];
            int neighbor_y = j + dir[1];
            
            if (neighbor_x >= 0 && neighbor_x < rows && neighbor_y >= 0 && neighbor_y < cols) {
                if (board[neighbor_x][neighbor_y] == 1 || board[neighbor_x][neighbor_y] == 3) {
                    live++;
                }
            }
        }
        
        return live;
    }
}