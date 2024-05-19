/**
One Approach - Use a resultt matrix to store changes acc to the rules.
        TC- O(m*n), SC -O(m*n)

Second Approach - for dead use 2 and for live use 3 to make it in space

        TC- O(m*n), SC- O(1)

Have a directions array for all directions
 */
class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // instead of creating new matrix, update the cutrrent one with values other than 0/1


        //int[][] newb = new int[m][n];

        // 10 is for dead;
        // 11 is for alive;
        this.dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int count = countAlive(board,i,j);
                if(board[i][j]==1){
                    if(count<2 || count>3) board[i][j] = 10;
                } else {
                    if(count==3) board[i][j] = 11;
                }
            }
        }
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] ==10) board[i][j] =0;
                if(board[i][j] ==11) board[i][j] =1;
            }
        }
    }
    private int countAlive(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;        
        int count =0;
        for(int[] dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && c>=0 && r<m && c<n){
            if(board[r][c]==1 || board[r][c]==10) count++;
            }
        }
        return count;
    }
}