// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class GameOfLife {
    class Solution {
        int[][] dirs;
        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            this.dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

            // 0 -> 1 : 2
            // 1 -> 0 : 3
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int liveCount = getLiveCount(board, i, j, m, n);
                    if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)){
                        board[i][j] = 3;
                    }
                    if(board[i][j] == 0 && (liveCount == 3)){
                        board[i][j] = 2;
                    }
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 2){
                        board[i][j] = 1;
                    }
                    if(board[i][j] == 3){
                        board[i][j] = 0;
                    }
                }
            }
        }

        private int getLiveCount(int[][] board, int i, int j, int m, int n){
            int count = 0;
            for(int[] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];

                if(nr < m && nc < n && nr >= 0 && nc >= 0 && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                    count++;
                }
            }
            return count;
        }
    }
}
