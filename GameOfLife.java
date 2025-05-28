class Solution {

    //Time complexity : O(M*N)
    //Space complexity : O(1) no extra space
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int neighbours = getAlives(board, i, j);
                if (board[i][j] == 1 && (neighbours < 2 || neighbours > 3)) {
                    board[i][j] = 4;
                }
                if (board[i][j] == 0 && neighbours == 3) {
                    board[i][j] = 5;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 4) {
                    board[i][j] = 0;
                }

                if (board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int getAlives(int[][] board, int r, int c) {

        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 },
                { -1, 1 }};
        int count = 0;

        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
                    && (board[nr][nc] == 1 || board[nr][nc] == 4)) {
                count++;
            }
        }

        return count;

    }
}