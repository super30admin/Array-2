// Time Complexity :O(n*m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n= board[0].length;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};

        for(int i=0; i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count =countAliveNeighbours(board,i,j,dir);

                if(board[i][j]==1 && (count>3 || count<2))
                {
                    board[i][j]=2;
                }

                else if(board[i][j]==0 && count==3)
                {
                    board[i][j]=3;
                }
            }
        }
         for(int i=0; i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                board[i][j]=0;

                else if(board[i][j]==3)
                board[i][j]=1;
            }
        }

    }

    public int countAliveNeighbours(int[][] board,int i,int j,int [][]dir)
    {
        int count =0;

        for(int[] d: dir)
        {
           int r =i+d[0];
           int c =j+d[1];

            if(r>=0 && c>=0 && r<board.length && c<board[0].length && (board[r][c]==1 || board[r][c]==2))
            count=count+1;
        }
        return count;
    }
}