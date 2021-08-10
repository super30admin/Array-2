using System;
using System.Collections.Generic;
using System.Text;

namespace LeetCodeSuper30
{
    class GameOfLifeLC
    {
        //Time Complexity: O(m*n)
        //Space Complexity: O(1)
        public void GameOfLife(int[][] board)
        {
            if (board == null || board.Length == 0)
            {
                return;
            }
            int m = board.GetLength(0);
            int n = board.GetLength(1);
            // 1 -> 0 = 2
            // 0 -> 1 = 3
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int count = CountLives(board, i, j, m, n);
                    //rule 1 and rule 3
                    if (board[i][j] == 1 && (count < 2 || count < 3))
                    {
                        board[i][j] = 2;
                    }
                    //rule 4
                    if (board[i][j] == 0 && (count == 3))
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
        private int CountLives(int[][] board, int i, int j, int m, int n)
        {
            //one is an array of array longs
            long[,] data = new long[2, 4] { { 1, 2, 3, 4 }, { 7, 8, 9, 10 } };
            //the other is a 2 dimensional array of longs
            long[][] data2 = new long[2][] { new long[4] { 1, 2, 3, 4 }, new long[4] { 7, 8, 9, 10 } };
            int result = 0;
          
            int[,] dirs1 = new int[8, 2] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
            int[][] dirs = new int[8][] { new int[2] { 0, 1 }, new int[2] { 1, 0 }, new int[2] { 0, -1 }, new int[2] { -1, 0 }, new int[2] { -1, -1 }, new int[2] { 1, 1 }, new int[2] { 1, -1 }, new int[2] { -1, 1 } };
            foreach (int[] dir in dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1))
                {
                    result++;
                }
            }
            return result;
        }
    }
}
