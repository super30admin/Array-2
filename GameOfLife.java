//Problem 33: Game of Life
// Time Complexity :O(rows*colums)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Note : Use dirs array for exploring immediate neigbors including immediate diagonals of an element in a matrix
//As same array is edited just make sure to create mapping for 1) //0->1 => 2(alive)
                                                             //2) //1->0 => 3(dead)
class Solution33 {
    int rows;
    int cols;
    public void gameOfLife(int[][] board) {
        //0->1 => 2(alive)
        //1->0 => 3(dead)
        if(board==null || board.length==0){
            return;
        }
        
        //TC : O(2(row*col))=>O(row*col)
        //SC : O(1)

        rows = board.length;
        cols = board[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int countLives = countLives(board,i,j);
                
                if(board[i][j]==1 && (countLives<2 || countLives>3)){
                    board[i][j] = 3;
                }else if(board[i][j]==0 && countLives==3){
                    board[i][j] = 2;
                } 
            }
        }
        
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
              if(board[i][j]==2){
                  board[i][j] = 1;
              }else if(board[i][j]==3){
                  board[i][j] = 0;
              }
            }
        } 
    }
    
   private int countLives(int[][] board,int i, int j){
       //Always use dirs because it is scalable & flexible;--Whenever asked to find values of immediate neigbors
       //For Calc dirs -< assume u r at 0,0(row, col)
       int[][] dirs =     {{-1,0},//top
                           {1,0},//bottom
                           {0,-1},//left
                           {0,1},//right
                           {-1,-1},//upper left -diagonal left
                           {-1,1},//upper right -diagonal right  
                           {1,-1},//bottom left -diagonal left
                           {1,1}//bottom right - diagonal right
                        };
       
       int count =0;
       for(int[] dir:dirs){//Time Complexity is constant because here dirs is of eight size & is fixed
           
           int r = i+dir[0];
           int c = j+dir[1];
           
           if(r>=0 && r<rows && c>=0 && c<cols && (board[r][c]==1 || board[r][c]==3)){
             count++;   
           }
           
       }
    return count;  
   }   
    
}