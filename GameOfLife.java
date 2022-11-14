//Time complexity is O(m*n)
//Space complexity is O(1)
public class Solution {
    public void gameOfLife(int[][] board)
        {
            int n = board.length;
            if (n == 0)
            {
                return;
            }

            int m = board[0].length;


            int[][] dirs = new int[][]
            {
                new int[]{0,1},
                new int[] {0,-1},
                new int[] {1,0},
                new int[] {-1,0},
                new int[] {1,1},
                new int[] {1,-1},
                new int[] {-1,1},
                new int[] {-1,-1}
            };


            //2 - dead to live
            //3 - live to dead

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {

                    int liveCount = 0;
                    for(var dir : dirs)
                    {
                        int newI = i + dir[0];
                        int newJ = j + dir[1];

                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m)
                        {
                            if (board[newI][newJ] == 1 || board[newI][newJ] == 3)
                            {
                                liveCount++;
                            }
                        }
                    }


                    if (board[i][j] == 0)
                    {
                        if (liveCount == 3)
                        {
                            board[i][j] = 2;
                        }

                        continue;
                    }

                    if (liveCount < 2)
                    {
                        board[i][j] = 3;
                        continue;
                    }

                    if (liveCount > 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (board[i][j] == 2)
                    {
                        board[i][j] = 1;
                        continue;
                    }

                    if (board[i][j] == 3)
                    {
                        board[i][j] = 0;
                        continue;
                    }
                }
            }

        }
}