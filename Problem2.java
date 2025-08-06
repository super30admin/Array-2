// Time Complexity :O(n*m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


//for each cell we need to check the number of alive neighbors using directions array
// without directly modifying with the result we use temporary state change by using 2,3 
// 2 means alive -> dead and 3 means dead -> alive
// finally we convert the temporary state to the original state

class Solution {
    int dirs[][];
    int n,m;
    public void gameOfLife(int[][] board) {

        this.dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        this.n=board.length;
        this.m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=getCount(board,i,j);   // calculates number of alive cells around it
                if(count==3&&board[i][j]==0)
                    board[i][j]=3;       // dead -> alive;
                else if((count<2||count>3)&&board[i][j]==1)
                    board[i][j]=2;       // alive -> dead;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2)
                    board[i][j]=0;
                else if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
    int getCount(int mat[][],int i,int j){
        int count=0;
        for(int dir[]:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0&&r<n&&c>=0&&c<m){
                if(mat[r][c]==1||mat[r][c]==2)
                    count++;
            }
        }
        return count;
    }
}