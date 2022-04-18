//time - O(m*n) m-board.length, n-board[0].length
//space-O(1) as dirs array size will remain constant for all input sizes 
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        int liveCells = 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                liveCells = calculateLiveCells(board, i, j, dirs);
                if(board[i][j]==0){
                    if(liveCells==3)
                        board[i][j] = 3;
                }
                else if(board[i][j]==1){
                    if(liveCells < 2 || liveCells > 3)
                        board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int calculateLiveCells(int[][] board, int row, int col, int[][] dirs){
        int live = 0;
        for(int[] dir : dirs){
            int r = row+dir[0];
            int c = col+dir[1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length){
                live += (board[r][c]==1 || board[r][c]==2) ? 1 : 0;
            }
        }

        return live;
    }
}