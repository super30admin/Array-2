// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// gameOfLife1 - Implements using another matrix and taking additional space. 
//gameOfLife - implements without additional array. 




class Solution {
    int dirs[][]= new int[][]{{-1,-1},{-1,0},{-1,1},
                              {0,-1},        {0,1},
                              {1,-1},{1,0},{1,1}};
    int rows, cols;
    public void gameOfLife1(int[][] board) {
        rows = board.length;
        cols = board[0].length;
        int newBoard[][]=new int[rows][cols];
        for (int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                newBoard[i][j]=board[i][j];
            }
        }       

        for (int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                int count = getCount(board,i,j);
                if(board[i][j]==0 && count==3){
                    newBoard[i][j]=1;
                }else if (board[i][j]==1 && (count<2 || count>3)){
                    newBoard[i][j]=0;
                }
            }
        }

        for (int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                board[i][j]=newBoard[i][j];
            }
        } 
        
    }

    public int getCount(int board[][], int row, int col){
        int count=0;
        for(int [] dir: dirs){            
            int r = row + dir[0];
            int c = col + dir[1];

            if(r>=0 && r<rows && c>=0 && c<cols){
                if(board[r][c]==1 || board[r][c]==3){
                    count++;
                }
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        rows = board.length;
        cols = board[0].length;    
        for (int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                int count = getCount(board,i,j);
                if(board[i][j]==0 && count==3){
                    board[i][j]=2; //0 to 1
                }else if (board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=3; //1 to 0
                }
            }
        }

        for (int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        } 
        
    }
}