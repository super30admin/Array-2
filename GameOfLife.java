class Solution {
    int [][]directionArray= {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
    public int countAlive(int [][]board, int i, int j) {
        int count =0;
        for(int []res : directionArray) {
            int rowneighbors = res[0]+i;
            int columnneighbors = res[1]+j;
            if(rowneighbors >=0 && rowneighbors < board.length && columnneighbors >=0 && columnneighbors < board[0].length && (board[rowneighbors][columnneighbors] == 1 || board[rowneighbors][columnneighbors] == -1)) {
               count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        
        for(int i =0; i<board.length;i++) {
            for(int j =0; j<board[i].length;j++) {
                int countNeighbors = countAlive(board,i,j);
                if(board[i][j] == 1 && (countNeighbors < 2 || countNeighbors > 3)) {
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && countNeighbors==3) {
                    board[i][j] = -2;
                }
            }
        }
        for(int i =0; i<board.length;i++) {
            for(int j =0; j<board[i].length;j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if(board[i][j] == -2) {
                    board[i][j] = 1;
                }
    }
}
    }
}