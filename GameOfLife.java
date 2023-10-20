
// Time Complexity : O(M*N) M is rows & N is columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class GameOfLife {
    class Solution {
        int[][] direction = new int[][]{
                {-1, -1},             {-1, 0},             {-1, 1},             {0, -1},            {0, 1},             {1, -1},
                {1, 0},            {1, 1}            };

        public void gameOfLife(int[][] board)
        {
            // to mutate the values consider 2 as live & 3 as dead
            int countOfLiveNodes = 0;
            for(int i = 0; i< board.length; i++)
            {
                for(int j = 0; j < board[0].length; j++)
                {
                    countOfLiveNodes = getLiveNodeCount(i, j , board);
                    if(board[i][j] == 1)
                    {
                        if(countOfLiveNodes < 2 || countOfLiveNodes > 3)
                            board[i][j] = 3;
                    }
                    else
                        board[i][j] = (countOfLiveNodes == 3) ? 2 : board[i][j];
                }
            }

            for(int i = 0; i< board.length; i++)
            {
                for(int j = 0; j < board[0].length; j++)
                {
                    if(board[i][j] == 3)
                        board[i][j] = 0;
                    if (board[i][j] == 2)
                        board[i][j] = 1;
                }
            }
        }

        public int getLiveNodeCount(int curRow, int curCol, int[][] board)
        {
            int countOfLiveNodes = 0;

            for(int i = 0; i < direction.length; i++)
            {
                int dirRow = curRow + direction[i][0];
                int dirCol = curCol + direction[i][1];
                if( ( dirRow >= 0 && dirRow < board.length ) &&
                        ( dirCol >= 0 && dirCol < board[0].length ) )
                {
                    if(board[dirRow][dirCol] == 1 || board[dirRow][dirCol] == 3)
                        countOfLiveNodes++;
                }
            }
            return countOfLiveNodes;
        }
    }
}
