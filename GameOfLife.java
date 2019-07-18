class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = count(board,i,j);
                if(board[i][j]==1 &&( count <2 || count>3)){
                    board[i][j]=-1;
                }
                
                 if(board[i][j]==0 && count==3){
                    board[i][j]=2;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
            }
    }
    }
    
    public int count(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int count =0;
        //Top
        if(i>0){
            if(board[i-1][j]==1 || board[i-1][j]==-1)count++;
        }
         //Bottom
        if(i<m-1){
            if(board[i+1][j]==1 || board[i+1][j]==-1)count++;
        }
        //Left
         if(j>0){
            if(board[i][j-1]==1 || board[i][j-1]==-1)count++;
        }
        //Right
        if(j<n-1){
            if(board[i][j+1]==1 || board[i][j+1]==-1)count++;
        }
       
         //diagnol top left
        if(i>0 && j>0){
            if(board[i-1][j-1]==1 || board[i-1][j-1]==-1)count++;
        }
        
         //diagnol top right
        if(i>0 && j<n-1){
            if(board[i-1][j+1]==1 || board[i-1][j+1]==-1)count++;
        }
          //diagnol bottom left
        if(i<m-1 && j>0){
            if(board[i+1][j-1]==1 || board[i+1][j-1]==-1)count++;
        }
          //diagnol bottom right
        if(i<m-1 && j<n-1){
            if(board[i+1][j+1]==1 || board[i+1][j+1]==-1)count++;
        }
        
        return count;
    }
}