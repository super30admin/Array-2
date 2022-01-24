//Time Complexity = O(m*n)
//Space Complexity  = O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                int count = findCount(board,i,j);
                if(count<2 && board[i][j]==1 ) board[i][j] = 3;
                else if(count>3 && board[i][j]==1) board[i][j]= 3;
                else if(count==3 && board[i][j]==0 ) board[i][j] = 4;
            }
        
        }
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==3) board[i][j]=0;
                else if(board[i][j]==4) board[i][j] =1;
            }
        
        }
        
    }
    public int findCount(int[][] board, int row,int col){
        int[] state = {0,0,1,-1,1,-1,1,-1};
        int[] column = {1,-1,0,0,1,-1,-1,1};
        int count = 0;
        for(int i =0;i<state.length;i++){
            int r = row+state[i];
            int c = col+column[i];
            if(r>= 0 && r<board.length && c>=0 && c<board[0].length){
                if(board[r][c]==3 || board[r][c]==1){
                    count+=1;
                }
            }
        }
        return count;
        
    }
}