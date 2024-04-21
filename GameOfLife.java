// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

/*
 * We have to look at 8 neighbours to check and see if there are any live cells.
 * 
 * But as we transform our current cell we cannot use the same 0 or 1 to mark a cell as dead. We need an alias.
 * 
 * 2 is an alias for 0 - which was alive before
 * 3 is an alias for 1 - which was dead before.
 * 
 * Once you treverse all the nodes n*m replace 2 with 0 & 3 with 1
 * 
 * 
 */

import java.util.*;;

public class GameOfLife {

    int[][] neighbours = new int[][] {
            { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentCount = getCountOfAlive(board, i, j);
                if (board[i][j] == 1) {

                    // Live cell
                    if (currentCount < 2 || currentCount > 3) {
                        // died
                        board[i][j] = 2; // Died now previously alive
                    }

                } else {
                    if (currentCount == 3) {
                        board[i][j] = 3; // Alive now previously dead
                    }

                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }

            }
        }
    }

    private int getCountOfAlive(int[][] board, int i, int j) {
        int count = 0;
        int rLength = board.length;
        int cLength = board[0].length;

        for (int[] neighour : this.neighbours) {
            int r = i + neighour[0];
            int c = i + neighour[1];

            if (r >= 0 && c >= 0 && r < rLength & c < cLength) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}