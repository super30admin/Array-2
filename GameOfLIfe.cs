using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class GameOfLIfe
    {
        int m = 0;
        int n = 0;
        public void GameOfLife1(int[][] board)
        {
            m = board.Length;
            n = board[0].Length;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int total = GetLiveTotal(board, i, j);
                    if (board[i][j] == 1 && (total < 2 || total > 3))
                    {
                        board[i][j] = 2;
                    }
                    else if (board[i][j] == 0 && total == 3)
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
                    else if (board[i][j] == 3)
                    {
                        board[i][j] = 1;
                    }
                }
            }
        }

        private int GetLiveTotal(int[][] board, int i, int j)
        {
            int[][] dirMatrix = { new int[]{ -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { -1, -1 }, new int[] { -1, 1 }, new int[] { 1, 1 }, new int[] { 1, -1 } };

            int total=0;

            foreach (int[] dir in dirMatrix)
            {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if((nr >= 0 && nc >= 0 && nr < m && nc < n) && (board[nr][nc] ==1 || board[nr][nc] ==2))
                    total += 1;
            }
          

            return total;
        }

    }
}
