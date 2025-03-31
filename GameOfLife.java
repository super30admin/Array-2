// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

This code modifies the board in place using a two-pass approach.
 It first iterates through the board,
 counting live neighbors for each cell and marking cells transitioning from
 live to dead (2) or dead to live (3) based on the game rules.
 A second pass then finalizes these transitions by converting 2 → 0 and 3 → 1.
 The getCount function helps determine the number of live neighbors by
 checking adjacent cells while handling boundary conditions.
 This approach efficiently updates the board in O(m × n) time with O(1) space
 by encoding state changes within the same matrix. 🚀
* */
class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        //2 tells live to dead
        //3 tells dead to live
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                int count=getCount(board,i,j,m,n);
                if(board[i][j]==1)
                {
                    if(count<2)
                    {
                        board[i][j]=2;
                    }
                    else if(count>3)
                    {
                        board[i][j]=2;
                    }
                }
                else
                {
                    if(count==3)
                    {
                        board[i][j]=3;
                    }
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
    private int getCount(int[][] board,int row,int col,int m,int n)
    {
        int count=0;
        int[][] dirs=new int[][]{
                {-1,-1},
                {0,-1},
                {1,-1},
                {1,0},
                {1,1},
                {0,1},
                {-1,1},
                {-1,0}
        };
        for(int i=0;i<dirs.length;i++)
        {
            int newRow=dirs[i][0]+row;
            int newCol=dirs[i][1]+col;
            if(newRow < 0 || newRow>m-1 || newCol<0 || newCol>n-1)
                continue;
            if(board[newRow][newCol]==1 || board[newRow][newCol]==2)
                count++;
        }
        return count;
    }
}