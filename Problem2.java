// Leetcode 289 -> Game of life
// Time -> O(mn)
// Space -> O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        //0 -> 1 => 3
//        1 -> 0 => 7
        for(int row = 0; row < board.length; row++){
            for(int col=0; col<board[0].length; col++){
                
                int livingCells = count(board, row ,col);
                
                if(board[row][col] == 1){
                    if (livingCells>3 || livingCells<2){
                        board[row][col] = 7;
                    }
                }else{
                    if(livingCells ==3){
                        board[row][col] = 3;
                    }
                }
                
            }
        }
        
        for(int row = 0; row < board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col] == 3){
                    board[row][col] = 1;
                }
                
                if(board[row][col] == 7){
                    board[row][col] = 0;
                }
            }}
        
    } 
    
    private int count(int[][] board, int row, int col){
        
        int count = 0;
        
        int[][] diagElements = {{-1,0}, {1,0}, {0, -1},{0,1}, {-1,-1}, {-1,1},{1,-1},{1,1}};
        
        
        for(int i=0; i<diagElements.length; i++){
            
            int newRow = row + diagElements[i][0];
            int newCol = col + diagElements[i][1];
            
            if ((newRow >=0 && newRow <= board.length-1) && (newCol>=0 && newCol<= board[0].length-1)){
                
                if(board[newRow][newCol] == 1 || board[newRow][newCol] == 7 ){
                    count ++;
                }
            }
        }
        
        return count;
        
    }
}