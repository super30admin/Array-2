// Time Complexity : O(m*n)
// Space Complexity :O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count = count(board,i,j);
                if(board[i][j]==1 && (count<2 || count>3))
                   board[i][j]=2;
               if(board[i][j]==0 && count==3)
                board[i][j]=3;
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2)
                   board[i][j]=0;
               if(board[i][j]==3)
                board[i][j]=1;
            }
        }
    }
    
    public int count(int[][] board, int i, int j){
        int dirs[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        for(int[] dir : dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row>=0 && row<board.length && col>=0 && col < board[0].length && (board[row][col]==1 || board[row][col]==2)){
                count++;
                
            }
        }
        return count;
    }
}
