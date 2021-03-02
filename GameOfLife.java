class GameOfLife {
    
    // Time Complexity: O(nm)
    // Space Complexity: O(1)
    
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // live changed to dead -> -1
        // dead changed to live -> -2
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int count = getLiveNeighborCount(board, i, j);
                if(board[i][j] == 1){
                    if(count != 2 && count != 3)
                        board[i][j] = -1;
                }else{
                    if(count == 3)
                        board[i][j] = -2;
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == -2)
                    board[i][j] = 1;
            }
        }
    }
    
    private int getLiveNeighborCount(int[][] board, int row, int col){
        // left, right, up, down, up-left, up-right, down-left, down-right
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count = 0;
        for(int[] i : dirs){
            int nextRow = row + i[0];
            int nextCol = col + i[1];
            
            if(nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length)
                continue;
            else{
                if(board[nextRow][nextCol] == 1 || board[nextRow][nextCol] == -1)
                    count++;
            }
        }
        return count;
    }
}