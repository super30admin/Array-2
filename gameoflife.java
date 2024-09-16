
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    private int m;
    private int n;
    public void gameOfLife(int[][] board) {
        m=board.length;
        // edge case
        if(board==null || board.length==0 ) return;
        n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=countLives(board,i,j);
                //case 1 or 3
                if(board[i][j]==1 && (count<2 || count>3)) board[i][j]=-1;
                // case 4
                if(board[i][j]==0 && count==3) board[i][j]=2;
            }
        }
        // get final values
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                 if(board[i][j]==-1) board[i][j]= 0;
                 if(board[i][j]==2)  board[i][j]= 1;
            }
        }
        
        
    }
    // to check how many are alive in neighbourhood
    private int countLives(int[][] board,int i,int j)
    {
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        int r=0;int c=0;
        int count=0;
        for(int[] dir: dirs)
        {
            r=i+dir[0];
            c=j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n) // to prevent out of bound
            {
                if(board[r][c]==1 || board[r][c]==-1){ count++;}
            }
        }
        return count;
    }
}