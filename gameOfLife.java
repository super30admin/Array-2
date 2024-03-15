// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
                            //up       down.   left. right.ldu.     ldd.   rdu.   rdd 
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};
        for(int i=0; i< m;i++){
            for(int j = 0;j<n;j++){
                int countAlive = countAlive(board,i,j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    //it dies
                    board[i][j] = -1;
                }else if(board[i][j] == 0 && countAlive == 3){
                    //it becomes alive
                    board[i][j] = -2;
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }else if(board[i][j] == -2){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int r, int c){
        int count = 0;
        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            //bounds check
            if(nr>=0 && nc >=0 && nr < board.length && nc < board[0].length 
            && (board[nr][nc] == 1 || board[nr][nc] == -1)){
                count++;
            }
        }
        return count;
    }
}