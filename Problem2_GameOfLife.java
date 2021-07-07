// Time Complexity : o(mn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        
        int m=board.length;
        int n=board[0].length;
        int count=0;
        
        //1->0 then 3
        //0->1 then 2
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                count=countLiveNeighbours(board,i,j,m,n);
                if(board[i][j]==1 && (count< 2 || count>3))
                    board[i][j]=3;
                if(board[i][j]==0 && count==3)
                    board[i][j]=2;
            }
        }
        
        // result should have only 0s and 1s so change 3s to 0 and 2s to 1
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
    
    private int countLiveNeighbours(int[][] board,int row,int column,int m,int n)
    {
        int result=0;
        int[][] dirs=new int[][]{{-1,-1},{-1,1},{1,1},{1,-1},{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int[] dir:dirs)
        {
            int r=row+dir[0];
            int c=column+dir[1];
            
            if(r>=0 && r<m && c>=0 && c<n)
            {
                if(board[r][c]==1 || board[r][c]==3)
                    result++; // counting live integers
            }
                
        }
        return result;
    }
}