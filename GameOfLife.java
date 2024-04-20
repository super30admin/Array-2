// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class GameOfLife {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        this.dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++) {

            for(int j=0;j<n;j++) {

                int count = countAlive(board, i, j);

                if(board[i][j] == 0) {
                    if(count == 3) {
                        board[i][j] = 2; //2 alive now dead prev
                    }
                }else if(board[i][j] == 1) {
                    if(count < 2 || count > 3) {
                        board[i][j] = 3; //3 dead now alive prev
                    }
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] ==2) {
                    board[i][j]=1;
                }else if(board[i][j] == 3) {
                    board[i][j]=0;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j){
        int count=0;
        int m = board.length;
        int n = board[0].length;
        for(int[] dir : dirs) {
            int r = i+ dir[0];
            int c =j + dir[1];

            if(r >= 0 && c >=0 && r < m && c < n) {
                if(board[r][c] == 1 || board[r][c] == 3) {
                    count++;
                }
            }
        }
        return count;
    }
}