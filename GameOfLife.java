// Time Complexity : O(n) n:Array length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//counting the surroundings 1's and based on the conditions given in the input changing from 0 to 1 and 1 to 0
//For making sure that we are not loosing the previous state using some other integers to store other than 0 and 1.

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = getCount(i,j,board);
                if(board[i][j] == 1 && (count < 2 || count > 3) ) //changing from 1 to 0
                {
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && (count == 3))  //changing from 0 to 1
                {
                    board[i][j] = 2;
                }
            }
        }
       for(int i=0;i<m;i++){
            for(int j=0;j<n;i++){
              if(board[i][j] == 3){
                    board[i][j] = 0;
              }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
       }
    }
    
    int getCount(int i,int j,int[][] board){
        int m = board.length;
        int n = board[0].length;
                int count = 0;
                if(i>0 && j>0 && i<m && j<n && board[i][j-1] == 1 || board[i][j-1] == 3) //left
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i][j+1] == 1 || board[i][j+1] == 3) //right
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i-1][j] == 1 || board[i-1][j] == 3) //up
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i+1][j] == 1 || board[i+1][j] == 3)//down
                    count++;
                if(i>0 && j>0 && i<m && j<n &&board[i-1][j-1] == 1 || board[i-1][j-1] == 3)//upper left diagnol
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i-1][j+1] == 1 || board[i-1][j+1] == 3)//upper right diagnol
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i+1][j-1] == 1 || board[i+1][j-1] == 3)//lower diagnol left
                    count++;
                if(i>0 && j>0 && i<m && j<n && board[i+1][j+1] == 1 || board[i+1][j+1] == 3)//lower diagnol right
                    count++;
        return count;
    }
}
