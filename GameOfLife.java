class Solution {
    public void gameOfLife(int[][] board) {

        //O(1) space and O(m * n) time
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

        for (int i=0; i<m; i++) {
            for (int j =0; j<n; j++) {

                int liveN = 0;
                for (int[] dir : directions) {
                    int nr = i + dir[0];
                    int nc = j + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (board[nr][nc] == 1 || board[nr][nc] == -2) {
                            liveN++;
                        }
                    }


                }

                if (board[i][j] == 0 && liveN == 3) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 1 && (liveN < 2 || liveN > 3)) {
                    board[i][j] = -2;
                }

                if (board[i][j] == 1 && (liveN == 2 || liveN == 3)) {
                    board[i][j] = 1;
                }

            }
        }

        for (int i=0; i<m; i++) {
            for (int j =0; j<n; j++) {

                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }

                if (board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }

    }
}