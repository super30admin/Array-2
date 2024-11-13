//289. Game of Life - https://leetcode.com/problems/game-of-life/description/
//Time Complexity: O(m*n)
//Space Complexity: O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        if(board == null || m==0)
            return;
        //manipulate values of the matrix with some random higher values
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = getLiveCount(dirs, board, i, j, m, n);
                if(board[i][j]==1 && (count < 2 || count > 3))
                    board[i][j]=2; //alive -> dead
                if(board[i][j]==0 && count==3)
                    board[i][j]=3; //dead -> alive
            }
        }
        // re-do the matrix with original values
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveCount(int[][] dirs, int[][] board, int i, int j, int m, int n){
        int count = 0;
        for(int[] dir : dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            if(nr >= 0 && nr < m && nc >= 0 && nc < n){ //check bounds
                if(board[nr][nc] == 1 || board[nr][nc] == 2){
                    count++;
                }
            }
        }
        return count;
    }
}