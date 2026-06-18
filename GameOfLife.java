class Solution {
    // TC - O(n)
    // SC - O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // get the neighbouring count of live cells
                int count = countLiveCells(board, i, j, m, n);

                // if element at index is 1 but count of live cells < 2 or >=4 
                // then set the element value to 2 (we choose 2 so that we can modify the same input array
                // to find the next state of matrix)

                // so if value is being updated from 0 -> 1 we set it to -1
                // if value is updated from 1 -> 0 we set it as 2
                if (board[i][j] == 1) {
                    // set value as 2 if 1 -> 0
                    if (count < 2 || count >= 4) {
                        board[i][j] = 2;
                    }
                }
                // if element at index is 0 but count of live cells is 3 
                // then set the element value to -1
                if (board[i][j] == 0 && count == 3) {
                    // set value as -1 if 0 -> 1
                    board[i][j] = -1;
                }
            }
        }

        // to reset the input array value to the original value
        // if value is 2 -> set it as 0, if value is -1 -> set it as 1
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLiveCells(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        // we take an array of directions that we need to add to indexes to find their neighbouring cells
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            // if index is not out of bounds of the matrix and value is > 0 (1 or 2), then incr the count of live cells
            if (nc >= 0 && nc < n && nr >= 0 && nr < m && board[nr][nc] > 0) {
                count++;
            }
        }

        return count;
    }
}