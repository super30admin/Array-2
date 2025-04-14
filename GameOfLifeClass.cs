public class Solution
{
    int m, n;
    public void GameOfLife(int[][] board)
    {
        int countLives = 0;
        m = board.Length;
        n = board[0].Length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                countLives = GetNeighborCounts(board, i, j);
                if (board[i][j] == 1 && (countLives < 2 || countLives > 3))
                {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && countLives == 3)
                {
                    board[i][j] = 3;
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

    public int GetNeighborCounts(int[][] board, int row, int column)
    {
        int count = 0;
        int[][] directions = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]];
        for (int d = 0; d < directions.Length; d++)
        {
            int newRow = row + directions[d][0];
            int newColumn = column + directions[d][1];
            if (newRow < 0 || newRow >= m)
            {
                continue;
            }
            if (newColumn < 0 || newColumn >= n)
            {
                continue;
            }
            if (board[newRow][newColumn] == 1 || board[newRow][newColumn] == 2)
            {
                count++;
            }
        }
        return count;
    }
}