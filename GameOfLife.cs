// time complexity - O(m*n)
// space complexity O(1)
public class Solution
{
    public void GameOfLife(int[][] board)
    {
        int m = board.Length;
        int n = board[0].Length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 1)
                {
                    if (aliveCount(board, i, j, m, n) < 2 || aliveCount(board, i, j, m, n) > 3)
                    {
                        board[i][j] = 2;
                    }
                }
                else
                {
                    if (aliveCount(board, i, j, m, n) == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
    public int aliveCount(int[][] board, int i, int j, int m, int n)
    {
        int[][] dir = new int[][] { [0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, 1], [1, -1] };
        int count = 0;
        foreach (int[] x in dir)
        {
            int idxR = i + x[0];
            int idxC = j + x[1];
            if ((idxR >= 0 && idxR < m) && (idxC >= 0 && idxC < n))
            {
                if (board[idxR][idxC] == 1 || board[idxR][idxC] == 2)
                {
                    count++;
                }
            }
        }
        return count;
    }
}