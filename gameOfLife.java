//Time Complexity : O(mn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    int n,m;
    public void gameOfLife(int[][] board) {
        //if board is null
        if(board==null||board.length==0)
            return;
        //dimensions of the matrix rows and cols
        m=board.length;
        n=board[0].length;
        //if live cell dies i.e., 1->0 then place 2 in the matrix
        //if dead cell becomes live i.e., 0->1 then place 3 in the matrix
        //iterate over the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //for the count of live cells, lets take a method and pass the board, current row and col values as the arguments
                int liveCells=getCount(board,i,j);
                //checking if the cell is live or dead at current position
                if(board[i][j]==1){
                    //checking how many live cells are present
                    if(liveCells<2||liveCells>3){
                        //then the cell dies
                        board[i][j]=2;
                    }
                        
                }
                else{
                    if(liveCells==3){
                        board[i][j]=3;
                    }
                }
            }
        }
        //iterate over the matrix again
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    //directions for 8 neighbors
    private int getCount(int[][] board, int row, int col){
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int total=0;
        //iterate over the directions and calculate the new row and col
        for(int[] direction:directions){
            int newRow=row+direction[0];
            int newCol=col+direction[1];
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && (board[newRow][newCol]==1 || board[newRow][newCol]==2) )
                total++;
        
         }
        return total;
    }
}