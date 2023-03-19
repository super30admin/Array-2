//Leetcode : 289
// Time Complexity : O(mn)
// Space Complexity : O(1)
public class GameOfLife {
    private int[][] dirs;
    public void gameOfLife(int[][] board) {

        //1 --> 0 2
        //0 --> 1 3
        int m = board.length;
        int n = board[0].length;
        //right left     up      down  upleft   upright downleft downright
        dirs = new int[][] {{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 1) {
                    if(countAlive < 2 || countAlive > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if(countAlive == 3)
                        board[i][j] = 3;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int row, int col){

        int count = 0;
        for(int i=0; i<dirs.length; i++){
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if ((newRow >=0 && newRow <= board.length-1) && (newCol>=0 && newCol<= board[0].length-1)){
                if(board[newRow][newCol] == 1 || board[newRow][newCol] == 2){
                    count ++;
                }
            }
        }
        return count;
    }
}
