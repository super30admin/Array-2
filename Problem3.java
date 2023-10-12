class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dirs=new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};
        for(int i =0; i< rows; i++){
            for(int j=0; j<cols ; j++){
                int count = countAlive(board,dirs, i, j, rows, cols);
                if(board[i][j]==1 && (count < 2 || count > 3)){
                    board[i][j] = 2; 
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    private int countAlive(int[][] board, int[][] dirs, int i, int j, int rows, int cols){
        int count = 0;
        for(int [] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr< rows && nc>=0 && nc<cols 
            && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}
