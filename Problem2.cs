// Time Complexity : O(m*n) where m & n are the dimensions of board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution {
    private int rows;
    private int columns;
    private int[][] dirs;
    public void GameOfLife(int[][] board) {
        rows = board.Length;
        columns = board[0].Length;
        dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,0},
            new int[] {-1,0},
            new int[] {-1,-1},
            new int[] {1,1},
            new int[] {-1,1},
            new int[] {1,-1},
        };

        Helper(board);

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                // 1 -> 0 : 2
                if(board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                
                // 0 -> 1 : 3
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void Helper(int[][] board)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                int neighbours = GetNeighbours(board, i , j);

                if(board[i][j] == 1)
                {
                    if(neighbours < 2 || neighbours > 3)
                    {
                        board[i][j] = 2;
                    }
                }

                else if(board[i][j] == 0)
                {
                    if(neighbours == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
    }

    public int GetNeighbours(int[][] board, int i, int j)
    {
        int neighbours = 0;

        foreach(int[] dir in dirs)
        {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nr<rows && nc>=0 && nc<columns && (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                neighbours += 1;
            }
        }

        return neighbours;
    }
}