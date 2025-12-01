// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        // 0 - dead, 1 - live
        // 1 -> < 2 live 1 -> 0
        // 1 -> == 2 or == 3 live 1 -> 1
        // 1 -> >3 live 1 -> 0
        // 0 -> == 3 live 1 -> 1
        // temporary pattern
        //map 0 -> 1 -> 2
        //map 1 -> 0 -> 3
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                int liveNeighbors = checkLive(i, j, board);
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                {
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && liveNeighbors == 3)
                {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3)
                {
                    board[i][j] = 0;
                }
            }
        }
    }

    private static int checkLive(int row, int col, int[][] board)
    {
        int[][] neighbors = new int[][]{{0,-1},{0,1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};
        int result = 0;

        for(int[] neighbor : neighbors)
        {
            int nr = row + neighbor[0];
            int nc = col + neighbor[1];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length)
            {
                if(board[nr][nc] == 1 || board[nr][nc] == 3)
                {
                    result++;
                }
            }
        }

        return result;
    }
}