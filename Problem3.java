class Problem3 {
    public void gameOfLife(int[][] board) {
        //null check
        if(board == null || board.length == 0) return;

        // traverse the matrix and make necessary changes based on the rules.
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                int countAlive = countAliveNeighbors(board, i, j);
                if(board[i][j] == 1 && (countAlive<2 || countAlive>3)){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && countAlive==3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j]==2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int countAliveNeighbors(int[][] board, int r, int c){
        int[][] dir = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
        int count =0;
        for(int i = 0; i<dir.length; i++){
            int currRow = r+dir[i][0];
            int currColumn = c+dir[i][1];
            if(currRow<0 || currRow>board.length-1 || currColumn<0 || currColumn > board[0].length-1){
                continue;
            }
            else if(board[currRow][currColumn] == 1 || board[currRow][currColumn] == 3){
                count++;
            }
        }
        return count;
    }
}