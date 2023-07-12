// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution1 {

    //chk neighbours from all 8 dirs
    int[][] dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=countAliveCells(board,i,j,m,n);
                //live cell die due to over and under population
                if(board[i][j]==1 && (count<2 || count>3))
                {
                    board[i][j]=2;// change from 1 to 0
                }
                //dead cell becomes live
                if(board[i][j]==0 && count==3)
                {
                    board[i][j]=3;//change from 0 to 1
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;//apply final changes
                }
                if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
    private int countAliveCells(int[][] board,int i,int j,int m,int n)
    {
        int count=0;
        for(int[] dir:dirs)
        {
            //get neighbouring cell row col
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && c>=0 && r<=m-1 && c<=n-1 && (board[r][c]==2 || board[r][c]==1))
            {
                count++;
            }
        }
        return count;
    }

}