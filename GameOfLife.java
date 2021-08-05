//https://leetcode.com/problems/game-of-life/
/*
Time: O(m*n) where m=rows and n = columns in board
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
                { -1, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int[] dir : dirs) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;

                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2))
                        liveCount++;
                }

                // Value 2: alive->dead
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) // Rule 1 and 3
                    board[i][j] = 2;

                // Value 3: dead->alive
                else if (board[i][j] == 0 && liveCount == 3) // Rule 4
                    board[i][j] = 3;

            }
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] %= 2; // 0 and 2 for dead, 1 and 3 for alive

    }

}
