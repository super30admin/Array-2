// Time Complexity : O(8 * m * n) => O(m * n)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {

    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public void gameOfLife(int[][] board) {
        
        int rows = board.length, cols = board[0].length;

        // Represent conversion of 0 -> 1 as 7
        // Represent conversion of 1 -> 0 as -7
        // Represent conversion of 1 -> 1 as 1 itself.

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                int count = check(board, i, j, rows, cols);

                if(board[i][j] == 0)
                {
                    if(count == 3) board[i][j] = 7;
                }

                else
                {
                    if(count < 2) board[i][j] = -7;

                    else if(count > 3) board[i][j] = -7;
                }
            }
        }

        // Change the values for 7 and -7.
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(board[i][j] == 7) board[i][j] = 1;

                else if(board[i][j] == -7) board[i][j] = 0;
            }
        }
    }

    private int check(int[][] board, int row, int col, int rows, int cols)
    {
        int new_row, new_col, count = 0;

        for(int[] dir : dirs)
        {
            new_row = row + dir[0];
            new_col = col + dir[1];

            if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols)
            {
                // I only count if the value is either 1 or -7. -7 denotes that previously value was 1 but now it's 0
                if(board[new_row][new_col] == 1 || board[new_row][new_col] == -7) ++count;
            }
        }

        return count;

    }
}