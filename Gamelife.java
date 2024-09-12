class Solution {
    public void gameOfLife(int[][] board) {
        //int result[][] = new int[board.length][board[0].length];
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                int count =0;
                if(i-1 >=0){
                    if(board[i-1][j] ==1 ||board[i-1][j] ==2) count++;
                }
                if(i-1 >=0 && j-1>=0){
                    if(board[i-1][j-1] ==1 ||board[i-1][j-1] ==2) count++;
                }
                if(i-1 >=0 && j+1<board[0].length){
                    if(board[i-1][j+1] ==1 ||board[i-1][j+1] ==2) count++;
                }
                if( j+1<board[0].length){
                    if(board[i][j+1] ==1 ||board[i][j+1] ==2) count++;
                }
                 if( j-1>=0){
                    if(board[i][j-1] ==1 ||board[i][j-1] ==2) count++;
                }
                if(i+1 <board.length){
                    if(board[i+1][j] ==1 ||board[i+1][j] ==2) count++;
                }
                if(i+1 <board.length && j-1>=0){
                    if(board[i+1][j-1] ==1 ||board[i+1][j-1] ==2) count++;
                }
                if(i+1 <board.length && j+1<board[0].length){
                    if(board[i+1][j+1] ==1 ||board[i+1][j+1] ==2) count++;
                }
                if(count< 2 && board[i][j]==1) board[i][j] =2;
                if(count> 3 && board[i][j]==1) board[i][j] =2;
                if(count==3 && board[i][j]==0) board[i][j] =3;
            }
        }
        
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                if(board[i][j] ==2) board[i][j]=0;
                 if(board[i][j] ==3) board[i][j]=1;
            }}
        
    }
}

// Class solution

class Solution {
     int[][] dirs;
    public void gameOfLife(int[][] board) {
        if(board==null) return;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
               
                int live = liveCount(board, i, j);
                 //rule 1 and 3
                if(board[i][j]==1 && (live<2 || live>3)){
                    board[i][j]=3;
                }
                //rule4
                if(board[i][j]==0 && live==3){
                    board[i][j]=2;
                }
            }
              
        }
        
          for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                
                if(board[x][y]==3){
                    board[x][y]=0;
                }
                if(board[x][y]==2){
                    board[x][y]=1;
                }
            }
            }
        
    } 
    
    public int  liveCount(int[][] board, int i, int j){
        int count = 0;
        dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && (board[r][c]==1 || board[r][c]==3)){
                count++;
            }
        }
        return count;
    }
}