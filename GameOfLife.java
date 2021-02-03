// Time Complexity :O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        if(board ==null || board.length==0||board[0].length==0){
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //calling the function to calculate the count of alive neighbors
                int count = countNeighbor(board,i,j,n,m);
                
                if(board[i][j] == 1 && (count<2 || count>3)){
                    //setting the value to 2(alive->dead) if the cell is alive and count is less than 2 or count is greater than 3
                    board[i][j] = 2;
                }else if(board[i][j]==0 && count==3){
                    //setting the value to 3(dead->alive) if the cell is dead and count is equal to 3
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]==2){
                board[i][j] = 0;
            }else if(board[i][j]==3){
                board[i][j] = 1;
            }
        }
    }
    }
    
    private int countNeighbor(int[][] board,int i,int j,int n,int m){
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        
        int count=0;
        for(int[] dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r>=0 && r<n && c>=0 && c<m && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }
        return count;
    }
                   
}