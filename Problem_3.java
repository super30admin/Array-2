// Time Complexity : O(n * m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* To achieve TC of O(n * m) and SC of O(1), we try to use inplace values of array to determine the next state. When we move from 0 -> 1 we update
   value of cell to 3. Else from 1 -> 0 we update value of cell to 2. We check for either 1 or 2 to get alive cells. In the end we replace values by 0 or 1
   in new state.
*/

class Solution {
    int[][] dirs;
    int n;
    int m;

    public Solution() {
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    }

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;

        n = board.length;
        m = board[0].length;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                int live = findLiveNeighbors(board, i, j);
                
                if(board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 2;

                if(board[i][j] == 0 && live ==3)
                    board[i][j] = 3;
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(board[i][j] == 3)
                    board[i][j] = 1;

                if(board[i][j] == 2)
                    board[i][j] = 0;    
            }
        }
    }

    private int findLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;
        for(int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && (board[nr][nc] == 1 || board[nr][nc] == 2))
                count++;
        }

        return count;
    }
}