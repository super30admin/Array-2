// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


class Problem3 {
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length; 

        int[][] posArr = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int cnt1 = 0;
                for (int[] pos : posArr) {
                    int pR = r + pos[0];
                    int pC = c + pos[1];
                    if (pR >= 0 && pR < row && pC >= 0 && pC < col) {
                        if (board[pR][pC] == 1 || board[pR][pC] == -1) {
                            cnt1++;
                        }
                    }
                }

                if (board[r][c] == 1) {
                    if (cnt1 < 2 || cnt1 > 3) {
                        board[r][c] = -1; // Mark for death
                    }
                    // else: stays alive, do nothing
                } else if (board[r][c] == 0) {
                    if (cnt1 == 3) {
                        board[r][c] = 2; // Mark for birth
                    }
                }
            }
        }

        // Finalize states
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == -1) board[r][c] = 0;
                else if (board[r][c] == 2) board[r][c] = 1;
            }
        }
    }
}
