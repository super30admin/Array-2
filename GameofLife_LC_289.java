/*
Time complexity - O(M*N)
Space complexity - O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class GameofLife_LC_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countAlive(board, i , j);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 5; //kill it
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 4; //make it alive
                }
            }
        }

        //Restoring back the matrix
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 5){
                    board[i][j] = 0;
                }
                if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countAlive(int [][]board, int i, int j) {
        int dirs[][]= new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int result = 0;
        for(int dir[] : dirs) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            //check if they are valid , bounds check
            if(row < board.length && col < board[0].length &&
                    row >= 0 && col >= 0 && (board[row][col] == 1 || board[row][col] == 5)) {
                result++;
            }
        }
        return result;
    }
}