// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force method for game of life.
class Solution {
    public void gameOfLife(int[][] board) {
        int count=0;
        int [][] newBoard=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                count=0;
               
                
                if(i-1>=0 && board[i-1][j]==1){
                    count=count+1;
                }
                if(i+1<board.length && board[i+1][j]==1){
                    count=count+1;
                }
                if(j+1<board[0].length && board[i][j+1]==1){
                    //System.out.println("hi");
                    count=count+1;
                }
                if(j-1>=0 && board[i][j-1]==1){
                    count=count+1;
                }
                if((i-1>=0 && j-1>=0) && board[i-1][j-1]==1){
                    count=count+1;
                }
                if((i-1>=0 && j+1<board[0].length) && board[i-1][j+1]==1){
                    count=count+1;
                }
                if((i+1<board.length && j-1>=0)&& board[i+1][j-1]==1){
                    count=count+1;
                }
                if((i+1<board.length && j+1<board[0].length) && board[i+1][j+1]==1){
                    count=count+1;
                }
                //System.out.println(board[i][j]+"="+count);
                if(board[i][j]==1 && count<2){
                    newBoard[i][j]=0;
                }
                if(board[i][j]==1 && (count==2 || count==3)){
                    newBoard[i][j]=1;
                }
                if(board[i][j]==1 && count>3){
                    newBoard[i][j]=0;
                }
                 if(board[i][j]==0 && count==3){
                    newBoard[i][j]=1;
                }
            }
        }
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[i].length;j++){
               board[i][j]=newBoard[i][j];
           }
       }
        
    }
}

// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//This is  the more efficient method.Without using the new 2d array I am doing the the in-place transforamtion.
class Solution {
    public void gameOfLife(int[][] board) {
        int count=0;
        int [][] newBoard=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                count=0;
               
                
                if(i-1>=0 && Math.abs(board[i-1][j])==1){
                    count=count+1;
                }
                if(i+1<board.length && Math.abs(board[i+1][j])==1){
                    count=count+1;
                }
                if(j+1<board[0].length && Math.abs(board[i][j+1])==1){
                    //System.out.println("hi");
                    count=count+1;
                }
                if(j-1>=0 && Math.abs(board[i][j-1])==1){
                    count=count+1;
                }
                if((i-1>=0 && j-1>=0) && Math.abs(board[i-1][j-1])==1){
                    count=count+1;
                }
                if((i-1>=0 && j+1<board[0].length) && Math.abs(board[i-1][j+1])==1){
                    count=count+1;
                }
                if((i+1<board.length && j-1>=0)&& Math.abs(board[i+1][j-1])==1){
                    count=count+1;
                }
                if((i+1<board.length && j+1<board[0].length) && Math.abs(board[i+1][j+1])==1){
                    count=count+1;
                }
                //System.out.println(board[i][j]+"="+count);
                if(board[i][j]==1 && count<2){
                    board[i][j]=-1;
                }
                if(board[i][j]==1 && (count==2 || count==3)){
                    board[i][j]=1;
                }
                if(board[i][j]==1 && count>3){
                    board[i][j]=-1;
                }
                 if(board[i][j]==0 && count==3){
                    board[i][j]=2;
                }
            }
        }
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[i].length;j++){
               if(board[i][j]<0){
                   board[i][j]=0;
               }
               if(board[i][j]>1){
                   board[i][j]=1;
               }
               // board[i][j]=newBoard[i][j];
           }
       }
        
    }
}