// Time Complexity :O(N*M) n are the rows and m are the columns in the given array.
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: calculating the count of live neighbours of every cell and updating it to 
// if it is initially alive and then becomes dead , and to 3 if it is initially dead and becomes alive. So when counting the live neighbours 
//we consider even the value 2 as they are initially alive 
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0)
            return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alive=liveNeighbours(board,i,j);
                if(board[i][j]==1 && (alive<2||alive>3)){
                    board[i][j]=2;
                }                    
                else if(board[i][j]==0&&alive==3)
                    board[i][j]=3;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                    board[i][j]=0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
    public int liveNeighbours(int[][] board, int i,int j){
        int[][] dir = {{0,1},{1,0},{1,1},{1,-1},{-1,1},{-1,-1},{0,-1},{-1,0}};
        int count=0;
        for(int[] direction : dir){
            int r = i+ direction[0];
            int c= j+ direction[1];
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c]==1||board[r][c]==2))
                count++;
        }
        return count;
    }
}