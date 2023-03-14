

// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution3 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveN = numLiveNeighbors(board,i,j);
                if( board[i][j] == 1) {
                    if( liveN < 2 || liveN > 3) {
                        board[i][j] = 2;
                    }
                } else if( board[i][j] == 0 ) {
                    if( liveN == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( board[i][j] == 2 ) {
                    board[i][j] = 0;
                }
                if( board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int numLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
        for(int k = 0; k < 8; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if( x >= 0 && y >= 0 && x < m && y < n && (board[x][y] == 1 || board[x][y] == 2) ){
                count++;
            }
        }
        return count;
    }
}
