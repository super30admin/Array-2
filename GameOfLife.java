// Time Complexity : O(nm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes 

class GameOfLife{
        int dirs[][];
        public void gameOfLife(int[][] board) {
        
        int m  = board.length;
        int n = board[0].length;

        dirs= new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        //1 -> 0 = 3
        //0 -> 1 = 2

        for(int i=0; i<m; i++){
            for(int j=0; j<n ;j++){
                int countLive = countLive(board, i, j, m, n);
                if(board[i][j] == 1 && (countLive<2 || countLive>3)){
                    board[i][j] = 3;
                }if(board[i][j]==0 && countLive == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j = 0; j<n ; j++)
            if(board[i][j] == 2) board[i][j] == 1;
            if(board[i][j] == 3) board[i][j] == 0;
        }
    }
    private int countLive(int[][] board, int i, int j, int m , int n){
        int count = 0;
        for(int dir : dirs){
            int nr = i + dir[0]; // row 2+0 = 2
            int nc = j + dir[1]; // col 3+1 = 4
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc]==1) || board[nr][nc]==3){
                count++;
            }
        }
        return count;
    }
}