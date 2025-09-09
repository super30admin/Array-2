public class Solution
{
    public void GameOfLife(int[][] board)
    {
        int m = board.Length;
        int n = board[0].Length;

        // Make a copy to avoid interfering updates
        int[][] copy = new int[m][];
        for (int i = 0; i < m; i++)
        {
            copy[i] = new int[n];
            for (int j = 0; j < n; j++)
            {
                copy[i][j] = board[i][j];
            }
        }

        for (var i = 0; i < m; i++)
        {
            for (var j = 0; j < n; j++)
            {
                if (copy[i][j] == 1)
                {
                    var shouldDie = CheckLiveShouldDie(copy, i, j);
                    if (shouldDie)
                    {
                        board[i][j] = 0;
                    }
                }
                else
                {
                    var shouldLive = CheckDeadShouldLive(copy, i, j);
                    if (shouldLive)
                    {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public bool CheckLiveShouldDie(int[][] board, int i, int j)
    {
        int liveCellCount = 0;
        var coords = new (int, int)[]
        {
            (i - 1, j - 1),
            (i - 1, j),
            (i - 1, j + 1),
            (i, j - 1),
            (i, j + 1),
            (i + 1, j - 1),
            (i + 1, j),
            (i + 1, j + 1)
        };

        foreach (var (x, y) in coords)
        {
            if (x >= 0 && x < board.Length && y >= 0 && y < board[0].Length)
            {
                if (board[x][y] == 1)
                {
                    liveCellCount++;
                }
            }
        }

        if (liveCellCount < 2 || liveCellCount > 3)
        {
            return true; // dies
        }
        return false; // survives
    }

    public bool CheckDeadShouldLive(int[][] board, int i, int j)
    {
        int liveCellCount = 0;
        var coords = new (int, int)[]
        {
            (i - 1, j - 1),
            (i - 1, j),
            (i - 1, j + 1),
            (i, j - 1),
            (i, j + 1),
            (i + 1, j - 1),
            (i + 1, j),
            (i + 1, j + 1)
        };

        foreach (var (x, y) in coords)
        {
            if (x >= 0 && x < board.Length && y >= 0 && y < board[0].Length)
            {
                if (board[x][y] == 1)
                {
                    liveCellCount++;
                }
            }
        }

        if (liveCellCount == 3)
        {
            return true; // becomes alive
        }
        return false;
    }
}
