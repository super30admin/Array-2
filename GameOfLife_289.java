// Time Complexity : O(MN)
// Space Complexity : O(1) for approach-1 and O(MN) for approach-2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* NOTE: 
1. DIRS array is a pattern to come up with when we need to access neighbors for every element in a matrix
2. BFS and DFS when you find snake pattern of flow between elements 
*/ 

/*
Approach:
========
1. Calculate neighbors by using dirs array, checking bounds and number of live neighbors. 
2. If 0 -> 0, 1 -> 1 state change, no need to worry about it. Our only concern is keeping track of 0-> 1 and 1-> 0, so pick 2 numbers 
for each case and update with new numbers whenever state changes.
3. Once entire matrix is traversed, change them to actual values 0 or 1
*/

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        if( board == null || m == 0) return; //edge case
        n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int neighbors = calculateNeighbors(board, i, j); //calculate neighbors
                
                if(board[i][j] == 1 && (neighbors < 2 || neighbors > 3)) // cases 1 and 3 - live and under or over populated 
                   board[i][j] = 3; // 3 indicates previously live and now dead neighbor 1-> 0 => 3
                else if(board[i][j] == 0 && neighbors == 3) // case 4
                   board[i][j] = 5; // 5 indicates previously dead now live neighbor 0->1 => 5
            }      
        }
        
        //update board in-place to its actual new state
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 5)
                    board[i][j] = 1; // If 5, implies it is now a live cell
                else if(board[i][j] == 3)
                    board[i][j] = 0; // If 3, implies it is now a dead cell
            }
        }
    }
    
    private int calculateNeighbors(int[][] board, int i, int j) {
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}}; // 8 directions from a point
        int count  = 0; //neighbor count
        for(int[] dir: dirs) {
            int row = dir[0]+i;
            int col = dir[1]+j;
            if(row >= 0 && row < m && col >= 0 && col < n) { // check bounds to prevent exception
                if (board[row][col] == 1 || board[row][col] == 3) count++; // If previously live cell or  live still, increment count
            }
        }
        return count;
    }
}

/*
1. Calculate neighbors for every cell using i from -1 to 1 and j from -1 to 1 because we have 8 neighbors
2. Update a temporary result matrix with the output
3. Copy the next state from result to board
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int neighbors = calculateNeighbors(board,i,j);

                //update cell state based on given conditions
                if(board[i][j] == 1) {
                    if(neighbors == 2|| neighbors == 3)
                        result[i][j] = 1;
                    else
                        result[i][j] = 0;
                }
                else {
                    if(neighbors == 3)
                        result[i][j] = 1;
                     else
                        result[i][j] = 0;
                }
            }
        }
        // copy cell next state from temp to board
        for(int i = 0; i <board.length; i++)  {
            for(int j = 0; j <board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    int calculateNeighbors(int[][] board, int r,int c) {
        int neighbors = 0;
        // 8 neighbors so i: -1..1 and j from -1.. 1
        for(int i = -1; i <= 1;i++) {
            for(int j = -1; j <= 1; j++) {
                if(!(i == 0 && j == 0)) {
                    //shouldn't count itself
                    if(r+i >= 0 && r+i < board.length && c+j >= 0 && c+j < board[0].length && board[r+i][c+j] == 1)
                        neighbors++;
                }
            }
        }
        return neighbors;
    }
}



