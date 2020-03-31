class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans2 = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                
                int temp = process(i,j,board);
             //   //System.out.print(process(i,j,board)+" ");
                ans2[i][j] = temp;
               //System.out.print(temp+" ");
             
            }
        }
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                
                board[i][j] = ans2[i][j];       
            }
  
        }
        
    }
    public int process(int i,int j,int[][] board){
        //check neighbhours
        int result = getCount(i,j,board);
        //get live neighbour count
      //  //System.out.println(result);
        if(result < 2 && board[i][j] == 1){
        //    board[i][j] == 0;
            return 0;
        }
        else if( board[i][j] == 1 && (result == 2 || result == 3)){
          //  board[i][j] == 1;
            return 1;
        }
        else if( board[i][j] == 1 && result > 3){
            //board[i][j] == 0;
            return 0;
        }
        else{
            if( board[i][j] == 0 && result == 3)
            //board[i][j] == 1;
            return 1;
        }
        return board[i][j];        
        //decide what to do with current node
        //how it will impact others
    }
    public int getCount(int i, int j, int[][] board){
        
        int liveCount = 0;
        
        //leftCorner
        if(check(i-1,j-1,board) == 1)
            liveCount++;
        if(check(i-1,j,board) == 1)
            liveCount++;
        if(check(i-1,j+1,board) == 1)
            liveCount++;
        if(check(i,j-1,board) == 1)
            liveCount++;
        if(check(i,j+1,board) == 1)
            liveCount++;
        if(check(i+1,j-1,board) == 1)
            liveCount++;
        if(check(i+1,j,board) == 1)
            liveCount++;
        if(check(i+1,j+1,board) == 1)
            liveCount++;
       
        return liveCount;
    } 
    public int check(int i,int j, int[][] board){
        //return 0 out of bound
        //return 1 live neighbour
        //return -1 dead neighbour
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return -1;
        if(board[i][j] == 1)
            return 1;
        else
            return -1;
        
    }
}
