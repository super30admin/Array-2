/*
 * #289. Game of Life
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population..
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]

Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:

1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

 */


/*
 * Time Complexity: O(n*m) -> To traverse the rows and columns of a matrix
 * 
 * Space Complexity: O (1) -> No extra space is used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.array2;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
        // Base condition
        if(board == null || board.length == 0 || board[0].length == 0){
            return; // Do nothing
        }
        
        int n = board.length; // Number of rows 
        int m = board[0].length; // Number of columns
        
        // Traverse through the rows and columns of a matrix (2D array) 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // Call a function to count total alive neighbor cells of an element in matrix 
                int alive = countAlive(board, n, m, i , j);
                
                // Check conditions
                // Second condition can be avoided from check since state of live cell will remain same
                
                // 1st and 3rd condition
                // If alive cell, and number of alive neighbors < 2 or > 3 then change the value to 2
                if(board[i][j] == 1 && (alive < 2 || alive > 3)){
                    board[i][j] = 2;  // 2 -> live cell(previous state) becomes dead(next state)
                }
                // 4th condition
                else if(board[i][j] == 0 && alive == 3){
                    board[i][j] = 4; // 4 -> dead cell(previous state) becomes live(next state)
                }
            }
        }
        
        
        // Traverse again to change the 2's and 4's to 0 and 1 
        // 2 -> 0 -> dead (next state)
        // 4 -> 1 -> live (next state)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                // We cannot use else because there are other elements (0 or 1) too in matrix
                }else if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
         // Function to count total alive neighbor cells of an element in matrix
        private int countAlive(int[][] board, int n, int m, int i, int j){
            int count = 0; // Initialize the count of alive cells
            
            // Create a direction array to traverse through 8 directions from an element
            int[][] dirs = {{1,-1}, {1,0}, {1,1}, {0,-1}, {0,1}, {-1,-1}, {-1,0}, {-1,1}};
            
            // Traverse through the direction 2D array
            // each element in 2D array is an 'int' array of 2 numbers
            for(int[] dir : dirs){
                // Compute the row to traverse in one of 8 directions
                // e.g: 11 -> 01    -> (1 + (-1))
                int r = i + dir[0];
                // Compute the column to traverse in one of 8 directions
                //e.g: 11 -> 01    -> (1 + (0))
                int c = j + dir[1]; 
                
                // Check if row and column is not OutOfBounds and if the value of cell is '1' (current state live) or '2' (previous state live)
                if(r >= 0 && r < n && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 2))
                {
                    count++; // Increment the count of live cells
                    
                }
            }
            return count;  // return the total alive neighbors of an element in matrix
        }
        
}
