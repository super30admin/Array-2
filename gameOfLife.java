// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class gameOfLife {
    int[][] dirs;
    public void gameOfLifem(int[][] board) {
        if(board==null) return;
        int m=board.length, n=board[0].length;
        dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{-1,-1},{1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){ //if a live cell
                    int live=get1s(board,i,j,m ,n );
                    //dead if less than 2 or greater than 3 live neighbors
                    if(live<2 || live>3) board[i][j]=2;
                }else{
                    int live=get1s(board,i,j, m ,n );
                    //lives if dead cell has more than 3 live neighbors
                    if(live==3) board[i][j]=3;
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //update the values.
                if(board[i][j]==2) board[i][j]=0;
                 if(board[i][j]==3) board[i][j]=1;
            }
         }
    }
    private int get1s(int[][] board, int i, int j, int m, int n){
        int count=0;
        //logic
        for(int[] dir:dirs){
            //check neighbors
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c]==1 || board[r][c]==2)) count++;
        }
        return count;
    }
}
