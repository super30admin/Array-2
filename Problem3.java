/*
Time COmplexity -> O(m*n)
Space complexity -> O(1)
*/

class Problem3 {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int countLiveNeighbours = getCountLiveNeighbours(board, i, j);
                if (countLiveNeighbours == 3 && board[i][j] == 0) {
                    board[i][j] = 3;
                } else if ((countLiveNeighbours < 2 || countLiveNeighbours > 3) && board[i][j] == 1) {
                    board[i][j] = 2;
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

    private int getCountLiveNeighbours(int[][] board, int i, int j) {

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        int count = 0;
        for (int[] dir : dirs) {
            int rp = dir[0] + i;
            int cp = dir[1] + j;
            if (rp >= 0 && rp < m && cp >= 0 && cp < n
                    && (board[rp][cp] == 1 || board[rp][cp] == 2)) {
                count++;
            }

        }
        return count;
    }
}