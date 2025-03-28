// Time Complexity : O(M * N) M rows and N is columns.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No.

// Approach:
// 1. For each cell, count the number of live neighbors by checking its surrounding cells 
// 2. Store results in temporary states (2 and 3).
// 3. After scanning all cells, update the board by changing the temporary states (2 becomes 1, 3 becomes 0).
// 4. This simulates the next generation of the Game of Life based on the rules.


public class gameOfLifeAndDeath 
{
    public void gameOfLife(int[][] board) 
    {
        for(int i=0;i<board.length;i++)
        {  
            for(int j=0;j<board[i].length;j++)
            {
                int one = 0;
                if(i-1 >= 0 && i-1<board.length && j<board[i].length && j>=0)
                {
                    if(board[i-1][j] == 1 || board[i-1][j] == 3)
                    {
                        one++;
                    }
                }
                if(i-1 >= 0 && i-1<board.length && j-1<board[i].length && j-1>=0)
                {
                    if(board[i-1][j-1] == 1 || board[i-1][j-1] == 3)
                    {
                        one++;
                    }
                }
                if(i-1 >= 0 && i-1<board.length && j+1<board[i].length && j+1>=0)
                {
                    if(board[i-1][j+1] == 1 || board[i-1][j+1] == 3)
                    {
                        one++;
                    }
                }

                if(i >= 0 && i<board.length && j+1<board[i].length && j+1>=0)
                {
                    if(board[i][j+1] == 1 || board[i][j+1] == 3)
                    {
                        one++;
                    }
                }

                if(i >= 0 && i<board.length && j-1<board[i].length && j-1>=0)
                {
                    if(board[i][j-1] == 1 || board[i][j-1] == 3)
                    {
                        one++;
                    }
                }

                if(i+1 >= 0 && i+1<board.length && j<board[i].length && j>=0)
                {
                    if(board[i+1][j] == 1 || board[i+1][j] == 3)
                    {
                        one++;
                    }
                }

                if(i+1 >= 0 && i+1<board.length && j-1<board[i].length && j-1>=0)
                {
                    if(board[i+1][j-1] == 1 || board[i+1][j-1] == 3)
                    {
                        one++;
                    }
                }

                if(i+1 >= 0 && i+1<board.length && j+1<board[i].length && j+1>=0)
                {
                    if(board[i+1][j+1] == 1 || board[i+1][j+1] == 3)
                    {
                        one++;
                    }
                }
                
                if(board[i][j] == 0 && one ==3 )
                {
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && one <2 )
                {
                    board[i][j] = 3;
                }
                if(board[i][j] == 1 && one >3 )
                {
                    board[i][j] = 3;
                }
            }
        }    
        for(int i=0;i<board.length;i++)
        {  
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j] == 3)
                {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}
