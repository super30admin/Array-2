/*Time Complexity: O(m*n) matrix size but two pass
 * Space Complexity: O(1) in place no auxiliary space
 * Leetcode: yes
 * Any Issues: no
 */
class LiveBoard {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int elem = board[i][j];
                int sum = neighborsSum(i, j, m, n, board);
                if(sum == 3 && elem == 0)
                    board[i][j] = 2;
                else if((sum < 2 || sum > 3 ) && elem == 1)
                    board[i][j] = 3;
            }
        }


        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board[i][j] = board[i][j] == 2 ? 1 : board[i][j] == 3 ? 0 : board[i][j];
    }
    // 2 previously 0 now 1
    // 3 previously 1 now 0
    private int neighborsSum(int row, int col, int m, int n, int[][] board)
    {
        int[][] xy = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int count = 0;
        for(int i=0; i<xy.length; i++)
        {
            int nrow = row + xy[i][0];
            int ncol = col + xy[i][1];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && (board[nrow][ncol] == 1 || board[nrow][ncol] == 3))
                count++;
        }
        return count;
    }
}