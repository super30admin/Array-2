/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity: O(ROW * COL)
The main idea is to idenitfy neighbours and then iterate each direction of the neighbour. Also, note that since we cannot use new array we will substitute with 2 or 3 based on rule if the final value changes to live we will substiute with 1 and if its dead we will substitiute with 3
**/


class Solution {
    
    int[][] neighbours = {{0,1},{0,-1},{-1,-1},{1,1},{1,0},{-1,0},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        
        
        for(int i =0; i< board.length; i++){
            for(int j  =0; j< board[0].length; j++){
                int numLives = getLives(board,i,j);
                if(board[i][j] == 1 && (numLives < 2 || numLives > 3))
                   board[i][j] = 2;
                
                if(board[i][j] == 0 && numLives == 3)
                   board[i][j] = 3;
            }
        }
        
        for(int i =0; i< board.length; i++){
            for(int j  =0; j< board[0].length; j++){
                board[i][j] = board[i][j] % 2;  
                
            }
        }
        
        
    }
    
    public int getLives(int[][] board, int row, int col){
        int numLives  = 0;
        //Iterating the directions
        for(int[] neighbour : neighbours){
            int newRow = neighbour[0] + row;
            int newCol  = neighbour[1] + col;
            
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
                continue;
            
            if(board[newRow][newCol] == 1 || board[newRow][newCol] == 2){
                numLives = numLives + 1;
            }
            
            
        }
        return numLives;
    }
    
    
}
