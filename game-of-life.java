//TC: O(m*n)
//SC: O(1)


class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLive = countLives(board, i, j);
                if (board[i][j] == 1 && (countLive < 2 || countLive > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && countLive == 3) {
                    board[i][j] = 3;
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

    private int countLives(int[][] board, int i, int j) {
        int count = 0;
        //r, b, l, t, tr,br,bl,tl
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { 1, -1 },
                { -1, -1 } };

        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            //bounds check
            if(nr >= 0 && nr < board.length && nc >=0 && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}