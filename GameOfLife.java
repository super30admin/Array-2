// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] directions = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        // Dead State - Make it 2
        // Alive State - make it 3
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int count  = countLiveCells(board,i,j,directions);
                if(board[i][j] == 1){
                    if(count<2 || count>3) board[i][j] = 2;
                }
                if(board[i][j] == 0){
                    if(count == 3) board[i][j] = 3;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public int countLiveCells(int [][] board, int i, int j,int [][] directions) {
        int count = 0;
        for(int[] direction : directions) {
            int nr = i+direction[0];
            int nc = j+direction[1];
            if(nr>=0 && nr<board.length
            && nc>=0 && nc<board[0].length
            && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                // board[nr][nc] = 2 too since I changed the value to 2 to make dead cells alive
                count++;
            }
        }
        return count;
    }
}