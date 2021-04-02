/*
Runtime complexity - O(N*M) where N and M is the number of rows and columns in the matrix respectively.
Space complexity - O(1) - in place computation are performed
*/

class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0)
            return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=getcount(i,j,board);
                if(board[i][j]==0 && val==3)
                    board[i][j]=3;
                if(board[i][j]==1 && (val>3 || val<2))
                    board[i][j]=2;
            }
        }
        //change the board back
        for(int i=0;i<m;i++) // Change the modified element back to 1 and 0
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                    board[i][j]=1;
                if(board[i][j]==2)
                    board[i][j]=0;
            }
        }
    }
    
    public int getcount(int row,int col,int[][] board)
    {
        int[][] dirs={{1,1},{-1,-1},{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,-1}}; // Compute the number of 1 by comparing all the neighbors
        int count=0;
        for(int[] dir:dirs)
        {
            int r=row+dir[0];
            int c=col+dir[1];
            if(r>=0 && r<m && c>=0 && c<n)
            {
                if(board[r][c]==1 || board[r][c]==2)
                    count++;
            }
        }
        return count;
    }
}	
