// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem: Problem3 (https://leetcode.com/problems/game-of-life/)

// Approach

/**
 * We calculate the live nodes for each of the elements of the array
 * we check the conditions of the game and do temporary modification of the array to save the extra space.
 */

class GameOfLife {
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        // if a state is changing from 1 --> 0, we denote it by 2 temporarily
        // if a state is changing from 0 --> 1, we denote it by 3 temporarily
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, rows, cols);
                
                if(board[i][j] == 0) {
                    if(liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                } else if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        // Revert back the temporary assigned values
        // if a state is changing from 1 --> 0, we denote it by 2 temporarily
        // if a state is changing from 0 --> 1, we denote it by 3 temporarily
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j, int rows, int cols) {
        
        int [][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        
        int result = 0;
        int a = -1;
        int b = -1;
        for (int[] dir : dirs) {
            a = i + dir[0];
            b = j + dir[1];
            
            if(a >= 0 && a < rows && b >= 0 && b < cols && (board[a][b] == 1 || board[a][b] == 2)) {
                result++;
            }
        }
        
        return result;
    }
}