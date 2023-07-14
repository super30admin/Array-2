// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class GameOfLife {
        int[][] dir;

        public void gameOfLife(int[][] board) {
            int n = board[0].length;
            int m = board.length;
            dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = countAlive(i, j, m, n, board);
                    if (board[i][j] == 1 && (count < 2 || count > 3)) {
                        board[i][j] = 2;
                    }

                    if (board[i][j] == 0 && count == 3) {
                        board[i][j] = 3;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    }
                    if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
        private int countAlive(int i, int j, int m, int n, int[][] board){
            int count = 0;
            for(int k = 0; k<=dir.length-1; k++){
                int[] dirs = dir[k];
                int r = i + dirs[0];
                int c = j + dirs[1];
                if(r>=0 && c>=0 && r<m && c<n &&
                        (board[r][c] ==1 || board[r][c] == 2)){
                    count ++;
                }
            }
            return count;
        }

}
