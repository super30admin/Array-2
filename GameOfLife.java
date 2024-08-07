// Problem 289. Game of Life
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class GameOfLife {
    public void gameOfLife(int[][] board) {
        // 0 -> 1 -> 3
        // 1 -> 0 -> 2
        int m = board.length;
        int n = board[0].length;   // right, left, up, down, up-left, up-right, down-left, down-right
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLive(board, i, j, dirs);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if(count == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLive(int[][] board, int i, int j, int[][] dirs){
        int count = 0;
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 &&
                    nr < board.length &&
                    nc >= 0 &&
                    nc < board[0].length &&
                    (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                count++;
            }
        }
        return count;
    }
}
