// In this we are calculating the liveneighbours count and based on that mutating the original matrix

// Time Complexity : O(m*n)
// Space Complexity : O(1) - mutating original
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    // Declaring the m and n in global scope so that it is accessible in both
    // methods
    int m, n;

    public void gameOfLife(int[][] board) {
        // Checking base condition
        if (board == null || board.length == 0) {
            // Just return because return type is void
            return;
        }
        // Initializing m and n
        m = board.length;
        n = board[0].length;
        // So, to get a constant space, we will mutate the original matrix and indicate
        // a change as below:
        // 1->0: with 2
        // 0->1: with 3

        // Looping through the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Calculating count of live neighbours for each
                int liveNeig = liveNeig(board, i, j);
                // If the current cell is a live cell
                if (board[i][j] == 1) {
                    // Check if the count of live neighbours is <2 or >3
                    if (liveNeig < 2 || liveNeig > 3) {
                        // In that case the live cell will become dead, but we are indicating 1->0 with
                        // 2
                        board[i][j] = 2;
                    }
                } else {
                    // If the current cell is a dead cell
                    // Check if the count of live neighbours is ==3
                    if (liveNeig == 3) {
                        // In that case the dead cell will become live, but we are indicating 0->1 with
                        // 3
                        board[i][j] = 3;
                    }
                }
            }
        }
        // Loop again through the matrix, and replace all 2s and 3s with 0 and 1 resp.
        // to get the final next state in result matrix
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

    // Function to calc the count of live neighbours
    private int liveNeig(int[][] board, int i, int j) {
        // Declare a direction array which helps in getting the indices of 8 neighbours
        // of particular cell
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        // Initialize the live neighbours cnt to 0
        int cnt = 0;
        // Iterate through all neighbours one by one
        for (int[] dirs : dir) {
            // Calc the corresponding row and col
            int nr = i + dirs[0];
            int nc = j + dirs[1];
            // Check if the new row and new col are valid indices and if the neighbour is a
            // live cell
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                // In that case increment the cnt
                cnt++;
            }
        }
        // Return the live cell count
        return cnt;
    }
}