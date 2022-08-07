//time complexity: O(mn) 
//space complexity: O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int m; 
    int n; 
    int [][] dirs; 
    public void gameOfLife(int[][] board) {
        
        if(board.length == 0 || board== null) return; 
        m = board.length; 
        n = board[0].length; 
        
        //rule that we will be following: 
        //1->0 : 2
        //0->1 : 3
            //               top    bottom  left    right   topleft   topright  bottomleft   bottomright
        dirs = new int [][] {{-1,0}, {1,0} ,{0,-1} ,{0, 1} , {-1,-1} ,  {-1,1}   ,{1,-1}    , {1,1}  };
        for(int i=0; i<m;i++){
            for(int j=0; j < n; j++){
                int countLives = countAlive(board, i, j);
                
                //rule 1 and rule 3
                if(board[i][j] == 1 && (countLives < 2 || countLives>3)){
                    board[i][j]=2; 
                }
                if(board[i][j] == 0 && countLives == 3){
                    board[i][j]=3; 
                }
            }
        }
        
          for(int i=0; i<m;i++){
            for(int j=0; j < n; j++){
                if(board[i][j] == 2) board[i][j] =0;
                if(board[i][j]== 3) board[i][j] =1;  
            }
         }
    }
    
    private int countAlive(int [][] board, int r, int c){
        int count=0; 
        
        for(int []dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if(nr >=0 && nr < m && nc>=0 && nc < n && (board[nr][nc] ==1 || board[nr][nc] == 2)){
                count++;
                
            }
            
        }
        return count; 
    }
}
