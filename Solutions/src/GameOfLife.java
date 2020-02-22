// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No
class GameOfLife {
    int[] x = {-1,-1,-1,0,0,1,1,1};
    int [] y = {-1,0,1,-1,1,-1,0,1};
    // int[] x = {-1,-1,-1,0,1,1,1,0};
    // int [] y = {-1,0,1,1,1,0,-1,-1};
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                int count  = getneighbors(board, i, j);
                //alive
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = -1;
                    }
                }
                else{
                    if (count == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getneighbors(int[][] board, int i, int j){
        int neighbours = 0;
        for(int k=0;k<8;k++){
            int row = i+x[k];
            int col = j+y[k];
            if(isValid(board,row,col)){
                if(board[row][col]==1 || board[row][col]==-1){
                    neighbours++;
                }
            }
        }
        return neighbours;
    }

    private  Boolean isValid(int[][] board, int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }
}
