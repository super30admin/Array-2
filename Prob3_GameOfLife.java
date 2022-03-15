// Time Complexity : O(M*N)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach
/*
Check the live neighbour for each cell

According to that, apply rules for converting 0 -> 1 and 1 -> 0.

*/

class Solution {
    int[][] directions;
    public void gameOfLife(int[][] board) {
        
        
        if(board == null) return;

        directions = new int[][]{ {-1,0}, {1, 0}, {0,1}, {0,-1}, {-1,1}, {-1,-1}, {1,1}, {1,-1}};
                                // Up, Down, Right, Left, Right-Up, Left-Up, Right-Down, Left-Down
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                int c = neighbourCount(board, i, j);
                
                if(board[i][j] == 1 && ( c < 2 || c > 3 ) ){
                    board[i][j] = 2; // Cell dies
                }//First and Third Rule
                
                
                //4th Rule
                if(board[i][j] == 0 && c == 3 ){
                    board[i][j] = 3; //Cell lives
                }
            }
        }
        
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 2)    board[i][j] = 0;
                
                if(board[i][j] == 3)    board[i][j] = 1;
            }
        }
        
        
    }
    //Using 2 for 1 ===> 0
    //Using 3 for 0 ===> 1
    
    int neighbourCount(int[][] board, int p, int q){
        int l = 0;
        
        for(int[] curr : directions){
                int currX = p + curr[0];
                int currY = q + curr[1];
                
                if(currX < board.length && currX >= 0 && currY >= 0 && currY < board[0].length && (board[currX][currY] == 1 || board[currX][currY] == 2)){
                    l++;
                }
            
        }
        
        return l;
    }
}

