public class Solution
    {
        // Time Complexity : O(m * n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        int[][] directions;
        public void GameOfLife(int[][] board)
        {
            int m = board.Length;
            int n = board[0].Length;
                                         
            directions = new int[][] {
                new int[] {0, -1 },//left i, j-1 
                new int[] {0, 1}, //right i, j+1
                new int[] {-1, 0}, //up i-1 j
                new int[] {1, 0}, //down i+1 j
                new int[] {-1, -1}, //diagonal up left i-1 j-1
                new int[] {-1, 1}, //diagonal up right i-1 j+1
                new int[] {1, -1}, //diagonal down left i+1 j-1
                new int[] {1, 1} //diagonal down right i+1 j+1
            };

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int aliveNeighbors = countAliveNeighbors(board, i, j, m, n);
                    if (board[i][j] == 1 && (aliveNeighbors > 3 || aliveNeighbors < 2))
                    {
                        board[i][j] = 2; // we have to map 1 -> 0 but since we are modifying in place we assign 2
                    }
                    if (board[i][j] == 0 && aliveNeighbors == 3)
                    {
                        board[i][j] = 3; // we have to map 0 -> 1 but since we are modifying in place we assign 3
                    }
                }
            }

            //replace 2->0 and 3->1
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if(board[i][j] == 2)
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

        public int countAliveNeighbors(int[][] board, int i, int j, int m, int n)
        {
            int aliveNeighbors = 0;
            foreach (var direction in directions)
            {
                int nr = i + direction[0];
                int nc = j + direction[1];

                //bound check as not all elements have 8 neighbors and check for alive neighbors so 1 or 2
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2))
                {
                    aliveNeighbors++;
                }
            }
            return aliveNeighbors;
        }
    }
