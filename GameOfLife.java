// Time Complexity - O(m*n)
//Space - O(1)
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLive = countLiveNeighbours(board,i,j);
                if(board[i][j] == 1){
                    if(countLive < 2 || countLive > 3){
                        board[i][j] = 2;
                    }
                } 
                else {
                    if(countLive == 3){
                        board[i][j] = 3;
                    }

                }

            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countLiveNeighbours(int[][] board, int row, int col){
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{-1,-1},{-1,1},{0,-1},{0,1},{1,-1},{1,1}};
        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 ||board[nr][nc] == 2)){
                count++;
            }
            
        }
        return count;

    }
}