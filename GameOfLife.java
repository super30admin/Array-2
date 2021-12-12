/*
Time complexity: O(mn)
Space Complexity: O(1)
*/
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countNumOfLives(board, i, j);

                if ( board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (lives == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if ( board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    public int countNumOfLives(int[][] board, int i, int j) {
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1},
                {-1, 1}, {1, 1}, {1, -1}};

        for (int[] direction : directions) {
            int newR = i + direction[0];
            int newC = j + direction[1];

            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && (board[newR][newC] == 1 || board[newR][newC] == 2)) {
                count++;
            }
        }

        return count;
    }
}