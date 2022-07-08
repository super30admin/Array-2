// Time Complexity : o(m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        
        //0->1 0->3  means if 3 it was a dead cell but turned to live
        //1->0 1->2  means if 2 it was first real cell but now dead   
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lcount=neighbourcount(board,i,j);
               if(board[i][j]==0){  //if current cell is dead
                    if(lcount==3){ //if live neighbour is exactly 3
                        board[i][j]=3;  //making it live
                    }
                }else{              //if current cell is live
                    if(lcount<2){
                        board[i][j]=2;  //making it dead;
                    }
                    if(lcount>3){
                        board[i][j]=2;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
    }
    
    private int neighbourcount(int[][] board,int r,int c){
        int[][] dirs={{-1,-1},{1,1},{1,0},{0,1},{0,-1},{-1,0},{-1,1},{1,-1}};
      
        int count=0;
         for(int[] dir:dirs){
            
             int nr= r+dir[0];
             int nc= c+dir[1];
                  
             if(nr>=0 && nc>=0 && nr<m && nc<n &&(board[nr][nc]==1 || board[nr][nc]==2)){
                 count ++;
             }
            }
        return count;
    }
}
