// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Successfully executed on leetcode
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int alive = aliveNeighbours(board, i, j, m, n);
                if(board[i][j] == 0 && alive ==3 ){
                    board[i][j] = 2;
                } else if(board[i][j] == 1 && (alive <2 || alive>3)) {
                    board[i][j] = -2;
                } else if(board[i][j] == 1 && (alive==2 || alive ==3)) {
                    board[i][j] =1;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==-2) {
                    board[i][j] = 0 ;
                } else if(board[i][j]==2) {
                    board[i][j] = 1 ;
                }
            }
        }
    }

    private int aliveNeighbours(int[][] board, int i, int j, int m, int n) {
        int[][] dir = {{-1,0}, {0, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int alive = 0;

        for(int[] d: dir) {
            int x = d[0]+i;
            int y = d[1]+j;
            if((x >= 0) && (x < m) && (y<n) && (y>=0)) {
                if(board[x][y] == 1) {
                    alive++;
                } else if(board[x][y] == -2) {
                    alive++;
                }
            }
        }
        return alive;
    }
}