class Solution {
    int m ;
    int n ;
    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
         m = board.length;
         n = board[0].length;
        for(int i =0; i< m; i++) {
            for(int j =0; j<n; j++) {
                int count = getLifeAround(board, dir, i, j);
                if((board[i][j] == 1 || board[i][j] == 2) && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                } else if((board[i][j] == 0 || board[i][j] == 3) && count == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for(int i =0; i < m; i++) {
            for(int j =0 ; j< n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLifeAround(int[][] board, int[][] dirs, int i, int j) {
       int count = 0;
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
}