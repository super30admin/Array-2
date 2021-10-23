// 289 Game of Life
// solved on leetcode
// Time complexity - O(n*m)
// space complexity - O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        
        // 1 -->0  == 5
        // 0 -->1  ==10
        
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                
                // living cells
                int livingCells= count(board,row,col);
            
                    if(board[row][col]==1){
                        if(livingCells<2 || livingCells>3){
                            board[row][col]=5;
                        }
                    }else{
                        if(livingCells==3){
                            board[row][col]=10;
                        }
                    }
                }
            }
        
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                    if(board[row][col]==5){
                        board[row][col]=0;
                    }
                    if(board[row][col]==10){
                        board[row][col]=1;
                    }
                
                }
            }
            
        }
    
    
     public int count(int[][] board, int row, int col){
        int [][] index = {{-1,0},{-1,-1},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count=0;
        for(int i=0;i<index.length;i++){
            int newRow=row+index[i][0];
            int newCol=col+index[i][1];
            
            if((newRow>=0 && newRow<board.length) && (newCol>=0 && newCol<board[0].length)){
                if(board[newRow][newCol]==1 || board[newRow][newCol]==5){
                    count++;
                }
            }
        }
        return count;
    }
}