// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        // If a value changes from 0->1 set state as 3
        // If a value changes from 1->0 set state as 2
        // While searching for 1 use 2  
        // While searching for 0 use 3
        // While updating use 1 for 3  
        // While updating use 0 for 2
        int count = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                count = checkHorizontal(i,j,board)+checkVertical(i,j,board)+checkDiagonal(i,j,board);
                if(board[i][j]==1){
                    if(count<2){
                        board[i][j]=2;
                    }
                    else if(count==2 || count==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=2;
                    }
                }
                else{
                    if(count==3){
                        board[i][j]=3;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
            }
        }
        // Updating
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                   board[i][j]=0; 
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    
    public int checkHorizontal(int i,int j,int[][] board){
        int count = 0;
        if(checkRange(i,j-1,board)){
            if(board[i][j-1]==1 || board[i][j-1]==2){
            count++;
            }
        }
        if(checkRange(i,j+1,board)){
            if(board[i][j+1]==1 || board[i][j+1]==2){
            count++;
            }
        }
        return count;
    }
    public int checkVertical(int i,int j,int[][] board){
        int count = 0;
        if(checkRange(i-1,j,board)){
            if(board[i-1][j]==1 || board[i-1][j]==2){
            count++;
            }
        }
        if(checkRange(i+1,j,board)){
            if(board[i+1][j]==1 || board[i+1][j]==2){
            count++;
            }
        }
        return count;
    }
    public int checkDiagonal(int i,int j,int[][] board){
        int count = 0;
        if(checkRange(i+1,j-1,board)){
            if(board[i+1][j-1]==1 || board[i+1][j-1]==2){
            count++;
            }
        }
        if(checkRange(i-1,j-1,board)){
            if(board[i-1][j-1]==1 || board[i-1][j-1]==2){
            count++;
            }
        }
        if(checkRange(i+1,j+1,board)){
            if(board[i+1][j+1]==1 || board[i+1][j+1]==2){
            count++;
            }
        }
        if(checkRange(i-1,j+1,board)){
            if(board[i-1][j+1]==1 || board[i-1][j+1]==2){
            count++;
            }
        }
        return count;
    }
    public boolean checkRange(int i,int j,int[][] board){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length){
            return true;
        }
        return false;
    }
}