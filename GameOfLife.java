// Time Complexity : O(mn)
// Space Complexity : O(1)

/*
 * keep track of all the alive cells in the voard. move in all 8
 * directions and count alive cells and use the conditions to change 
 * the cells. 
 */

class Solution {
    int[][] dirs;
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 0 && countAlive == 3) board[i][j] = 2;
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) board[i][j] = 3;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    public int countAlive(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)) count++;
        }
        return count;
    }
}