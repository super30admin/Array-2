// Time Complexity :O(mn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class Solution {
    int brow,bcolumn;
    public void gameOfLife(int[][] board) {
        brow= board.length;
        bcolumn= board[0].length;
        
        for(int i=0; i<brow; i++)
        {
            for(int j=0; j<bcolumn; j++)
            {
                int count=countlive(board, i,j);
                if(board[i][j]==1)
                {
                    if(count<2|| count>3)
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
        
        for(int i=0; i<brow; i++)
        {
            for(int j=0; j<bcolumn; j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
        
    }
    public int countlive(int[][] board, int i, int j)
    {
        int count=0;
        int[][] direction={{-1,0},{0,-1},{1,0},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[] dir: direction)
        {
            int row=i+dir[0];
            int column=j+dir[1];
            if(row>=0 && column>=0 && row<brow && column<bcolumn && (board[row][column]==1 || board[row][column]==2))
            {
                count++;
            }
        }
        return count;
        
    }
}
