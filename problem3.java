//Time Complexity :O(N*M)
//Space :O(1)
class Solution {

    public static int countLiveNeigbours(int[][] board, int i, int j) {

        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { -1, 0 } };

        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && (board[x][y] == 2 || board[x][y] == 1))
                count++;

        }

        return count;
    }

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int alive = countLiveNeigbours(board, i, j);

                if ((board[i][j] == 1) && (alive < 2 || alive > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && alive == 3) {
                    board[i][j] = 4;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == 4)
                    board[i][j] = 1;
            }
        }
    }
}