// Time Complexity : O(n*m)
// Space Complexity : O(1)
    // n & m are the number of rows and columns of the given array

// Your code here along with comments explaining your approach
    //At every cell we look at all the 8 neighbours. We can create a method that is responsible for this, to just return the number of living neighbours. We will change the state of the given array temporarily.
    //To preserve the original meaning of a living or dead cell, we put "-1" if a dead cell is going to be a living cell in the future, we put "-2" if a living cell becomes dead cell in the future. 
    //While calculating the number of living neighbours, we will only count those with "1" in them. Later, we will go through the array and replace "-1"s with "1"s and "-2"s with "0"s. With this done, we got the answer in no extra space.

class Solution {
    public void gameOfLife(int[][] board) 
    {
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int  x = board[i][j];
                int count = getLive(board, i, j);
                if (x==0)
                {
                    //dead to live
                    if (count==3)
                    {
                        board[i][j] = -1;
                    }
                }
                if (x==1)
                {
                    //live to dead
                    if (!(count==2||count==3))
                    {
                        board[i][j] = -2;
                    }
                }
            }
        }
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (board[i][j]==-1)
                {
                    board[i][j] = 1;
                }
                else if (board[i][j]==-2)
                {
                    board[i][j] = 0;
                }
            }
        }
    }
    private int getLive(int[][] board, int x, int y)
    {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,0},{1,1}};
        for (int[] dir : dirs)
        {
            int x1 = x+dir[0];
            int y1 = y+dir[1];
            if ((x1>=0&&x1<n)&&(y1>=0&&y1<m))
            {
                if (board[x1][y1]==1||board[x1][y1]==-2)
                {
                    count++;
                }
            }
        }
        return count;
    }
}