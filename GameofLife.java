/*
Time Complexity: O(M×N), 
Space Complexity O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO

*/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i =0; i  < row; i++){
            for(int  j =0; j < col; j ++){
                int count = countLives(board,i,j);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i =0; i  < row; i++){
            for(int  j =0; j < col; j ++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countLives(int [][]board,int i , int j){
        int count =0;
        int row = board.length;
        int col = board[0].length;
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int dir[] : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < row && c >= 0 && c < col){
                if(board[r][c] == 1 || board[r][c] == -1){
                    count++;
                }
            }
        }
        return count;
    }
    
}