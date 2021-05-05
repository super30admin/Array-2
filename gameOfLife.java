//Time Complexity : O(n)
//Space Complexity : O(1). No extra space used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    
     static boolean isValid(int nx, int ny,int r,int c){
        
        if(nx > -1 && ny > -1 && nx < r && ny < c){
            
            return true;
        }
         
         return false;
    }
    
     static void isAliveOrDead(int i, int j, int[][] board,int r, int c){
        
        int[] dx = new int[]{-1,0,1,0,-1,-1,1,1};
        int[] dy = new int[]{0,1,0,-1,-1,1,-1,1};
        
        int nx;
        int ny;
        int alive = 0;
        int dead = 0;
        
        for(int z = 0; z < 8; z ++){
            
            nx = i + dx[z];
            ny = j + dy[z];
            
            
            if(isValid(nx,ny,r,c)){
                
                if(board[nx][ny] == 0 || board[nx][ny] == 3){
                    
                    dead = dead + 1;
                }
                else if(board[nx][ny] == 1 || board[nx][ny] == 2){
                    
                    alive = alive + 1;
                }
            }
        }
      //  System.out.println("Alive is "+ alive);
      //   System.out.println("dead is "+ dead);
         
        
        if(board[i][j] == 1 && alive < 2){
            
            board[i][j] = 2;
        }
        else if(board[i][j] == 1 && alive > 3){
            
            board[i][j] = 2;
        }
        else if(board[i][j] == 0 && alive == 3){
            
            board[i][j] = 3;
        }
        
    }
    public void gameOfLife(int[][] board) {
        
        int r = board.length;
        int c = board[0].length;
       // int[][] tempBoard = new int[r*c];
        
        for(int i = 0; i < r; i ++){
            
            for(int j = 0; j < c; j ++){
                
                isAliveOrDead(i, j, board,r,c );
            }
        }
        
        for(int i = 0; i < r; i ++){
            
            for(int j = 0; j < c; j ++){
                
               if(board[i][j] == 2){
                   
                   board[i][j] = 0;
               }
               else if(board[i][j] == 3){
                   
                   board[i][j] = 1;
               }
            }
        } 
        
    }
}