class Solution {
    // This method will count all the ones in the neighbouring indices
    private int countOnes(int[][] board, int row, int col) {
        int[][] ids = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };
        int count = 0;
        for (int[] id : ids) {
            int r = row + id[0];
            int c = col + id[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public void gameOfLife(int[][] board) {
        // 1 -> 2 -> 0 if < 2 1's
        // 1 -> 1 -> 1 if =2,3 1's
        // 1 -> 2 -> 0 if >3 1's
        // 0 -> 3 -> 1 if =3 1's
        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int count = countOnes(board, r, c);
                if (board[r][c] == 0 && count == 3) {
                    board[r][c] = 3; // convert dead state to temp state (3) indicating it was in dead state earlier
                                     // and needs to move to live state.

                } else if (board[r][c] == 1) {
                    if (count < 2 || count > 3) {
                        board[r][c] = 2; // convert live state to temp state (2) indicating it was in live state earlier
                                         // and needs to move to dead state.

                    }
                }

            }
            ;
        }

        // At this point the board matrix will have the temp state so we'll convert 2->0
        // and 3->1
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
}