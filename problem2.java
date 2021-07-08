class Solution {
    public void gameOfLife(int[][] board) {
        //time: O(M*N)
        //space- 0(!)
        
        /*
       LIVE- <2L- DEAD
       LIVE- >3- DEAD
       DEAD- ==3- LIVE
       
        */
        //1-0 3
        //0-1 2
        
        //with 3,2 I can access the prev state and the next state
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
             int cnt=  helper(board, i, j);
                
                //this way i will not affect others neighbors and making sure state is changed directly from the prev state(input)
                if(board[i][j]==1 && (cnt<2 || cnt>3)){
                    board[i][j]=3; 
                }
                
                else if(board[i][j]==0 && (cnt==3)) board[i][j]=2;
            }
        }
        
      for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==3) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
        
    }
      }
    }
    
    
    public int helper(int[][] board, int i, int j){
        
        int c=0;
        int[][] dir=new int[][]{{-1,-1}, {-1,1}, {1,1}, {1,-1}, {0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int[] d: dir){
        int row= i+d[0];
        int col= j+d[1];
            if(row>=0 && row<board.length && col>=0 && col<board[0].length){
        
        if(board[row][col]==1 || board[row][col]==3) c++;
        
    }}
        
        return c++;
    }
}