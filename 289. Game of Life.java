class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLiveNeighbours = countLives(board, i, j);
                //if the cell was dead
                if(board[i][j] == 0){
                    //When there are exactly 3 live neighbours
                    if(countLiveNeighbours == 3){
                        board[i][j] = 2;
                    }
                }
                else{
                    //fewer than 2 live neighours
                    if(countLiveNeighbours < 2){
                        board[i][j] = 3;
                    }
                    //more than 3 live neighbous
                    if(countLiveNeighbours > 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLives(int[][] board, int r, int c){
        int count = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                count ++;
            }
        }
        return count;
    }
}