// Time Complexity : O(n) where n is the number of elements 
// Space Complexity : O(1) in place display
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : in-place
/* Your code here along with comments explaining your approach: Check for each element, the neighbors (vertical, horizontal and diagonal) positions
using the Directions matrix, and update row and column value for the element you are searching for 1's. In countlives function, we can pass a
element and use its ith and jth position to calculate the neighbors positions for that element, and we can count the number of 1's. If we are flipping
 1 to 0, we would use arbitary number 8 to denote that this were earlier 1. If we are flipping 0 to 1, we would use 7 to denote that this was
 earlier 0 so that it does not affect our present search of 1's. At the end , we would iterate over the matrix to convert our 7's to 1 and 8's to 0's.
*/
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0 ; i <board.length; i++)
        {for(int j = 0; j < board[0].length; j++){
               int lives = countlives(board, i, j);
                if(board[i][j] == 1 && lives < 2){              // Rule 1
                    board[i][j] = 8;
                } else 
                if(board[i][j] == 1 && lives > 3){              // Rule 3
                    board[i][j] = 8;                            // Denote it was earlier 1
                } else 
                if(board[i][j]==0 && lives == 3){               // Rule 4
                    board[i][j] = 7;                            // Denote it was earlier 0
                }
            }
        }
        for(int i = 0 ; i <board.length; i++)
        {for(int j = 0; j < board[0].length; j++){
            if(board[i][j] == 7){                               // Iterate over the matrix again to flip the bits to original 1's and 0's, the numbers that 7 and 8 represented
                board[i][j] = 1;
            } else 
            if(board[i][j] == 8){
                board[i][j] = 0;
            }
        }}
    }
    private int countlives(int[][] board, int i , int j){
        int count_lives = 0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};   // All direction positions
        for(int[] dir: dirs){
            int r = i + dir[0];                                     // Update row and column positions for each element to search for neighbors
            int c = j + dir[1];
            if(r >= 0 && c>=0 && r < board.length && c < board[0].length && (board[r][c] == 1 || board[r][c]==8)){      // 1 found
                count_lives++;                  // increment the count
            }
        }
        return count_lives;
        
    }
}