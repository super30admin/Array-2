// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class GameOfLife {

        int[][] dirs = {{0,1},{0,-1},{1,0},{1,-1},{1,1},{-1,0},{-1,1},{-1,-1}};
        int n;
        int m;
        public void gameOfLife(int[][] board) {
    
            m = board.length;
            n = board[0].length;
            int[][] output = new int[m][n];
    
            for (int i=0; i<m; i++ ){
                for (int j=0;j<n;j++){
                    int cnt = findLivePopu(board, i, j);
                    if (cnt > 3 && board[i][j] == 1) output[i][j] = 0;
                    else if (cnt == 3 && board[i][j] == 0) output[i][j] = 1;
                    else if ((cnt == 2 || cnt == 3) && board[i][j] == 1 ) output[i][j] = 1;
                    else if (cnt < 2 && board[i][j] == 1) output[i][j] = 0;
                }
            } 
            for (int i=0; i<m; i++ ){
                for (int j=0;j<n;j++){
                    board[i][j] = output[i][j];
                }
            }
        }
    
        public int findLivePopu(int[][] borad, int r, int c){
            int cnt = 0;
            for (int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >=0 && nr < m && nc <n && borad[nr][nc] == 1) cnt++;
            }
            return cnt;
    
        }
    
}
