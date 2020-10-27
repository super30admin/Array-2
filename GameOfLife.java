package Oct27;

class GameOfLife {
    public void gameOfLife(int[][] board) {
        
/* 
Time Complexity: O(mn) where m is no.of rows and n is no.of cols in the board array.
Because we need to iterate through all elements of board array which is O(mn).

Space Complexity: O(1)
Since extra space used is only for dirs array but it is of fixed size, so O(1).
      
Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : No

Approach:
In place modification in the given array itself.
  
*/ 

        // edge
        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        /* 
        1) traverse through the given matrix in a linear manner
        2) find out count of all live neighbors of the curent cell
        3) using cuurrent cell value and its live neighbor count, apply the given rules to kill(1-> 100)/revive a cell(0->101)
        */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = calcLiveCount(board, i, j, rows, cols);
            
                // rule 1 - underpopulation
                if (liveNeighbors < 2 && board[i][j] == 1 ) {
                    board[i][j] = 100;  // dead
                }
                // rule 3 - overpopulation
                if (liveNeighbors > 3 && board[i][j] == 1 ) {
                    board[i][j] = 100; // dead
                }
                // rule 4 - reproduction
                if (liveNeighbors == 3 && board[i][j] == 0 ) {
                    board[i][j] = 101; // live
                }
            }
        }
        
        /*
        convert all the 100 to 0 and 101 to 1. 
        */
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if (board[i][j] == 100)  {
                   board[i][j] = 0;
               }
               if (board[i][j] == 101)  {
                   board[i][j] = 1;
               } 
            }     
         }
    }
    
    // helper function to determine new array element value at index (i,j) as per given rules
    public int calcLiveCount(int[][] board, int i, int j, int rows, int cols) {
        
        // direction array to check for all 8 neighbors of array element at (i,j)
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1},{0,-1},{0,1}};
        
        int count = 0;
        
        // traverse through direction array to find new array elements as p
        for (int[] d: dir) {
            int neighborRow = i + d[0];
            int neighborCol = j + d[1];
            // array out of bounds check
            if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                // check if neigbouring cell has a live value, i.e.1 or was earlier 1, but has been killed now,i.e.100
                if (board[neighborRow][neighborCol] == 1 || board[neighborRow][neighborCol] == 100) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
}