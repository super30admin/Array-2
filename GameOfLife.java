// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : 

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length ; j++){
                
                int countOfLiveNeighbors = getCountOfLiveNeighbors(board, i, j );

                //Rule 1 and Rule 3
                if( board[i][j] == 1 && (countOfLiveNeighbors < 2 || countOfLiveNeighbors > 3)) {
                    board[i][j] = 3;
                }
                
                //Rule 4
                if( board[i][j] == 0 && (countOfLiveNeighbors == 3)) {
                    board[i][j] = 2;
                }
            }
        }
        
        //change back the mutated values to either live or dead
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length ; j++){
                if( board[i][j] == 3){
                    board[i][j] = 0;
                }
                if( board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    private int getCountOfLiveNeighbors(int[][] board, int i, int j){
        
        int count = 0;
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        for(int k = 0; k < 8; k++){
            //check if the indices of neighbors are out of bound
            if(i+ directions[k][0] >= 0 && i+ directions[k][0] < board.length && j+ directions[k][1] >= 0 && j+ directions[k][1] < board[0].length){
                //count as neighbor if element is live or was mutated to dead
                if(board[i+ directions[k][0] ][j +  directions[k][1] ] == 3 || board[i+ directions[k][0] ][j +  directions[k][1] ] == 1 )
                    count = count + 1;
            }
                
        }
        
        return count;
    }
}
