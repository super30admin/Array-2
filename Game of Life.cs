/*
  Time complexity:O(m*n)
  Space complexity:O(1)

  Code ran successfully on leetcode: Yes

*/

public class Solution {
    public void GameOfLife(int[][] board) {
        int rows = board.Length;
        int cols = board[0].Length;
        int[] neighbors = {0,1,-1};
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                int live = 0;
                for(int i = 0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(!(neighbors[i]==0 && neighbors[j]==0))
                        {
                            int row = r+neighbors[i];
                            int col = c+neighbors[j];

                            if(row<rows && row>=0 && col<cols && col>=0 && Math.Abs(board[row][col])==1)
                                live++;
                        }
                    }
                }
                if(board[r][c]==1 && (live<2 || live>3))
                    board[r][c]=-1;

                if(board[r][c]==0 && live==3)
                    board[r][c]=2;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
