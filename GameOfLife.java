// Time Complexity : O(m * n), where m is number of rows and n is number of columns
// Space Complexity : O(1), since we are modifying the board in-place (no extra space used)
// Did this code successfully run on Leetcode : Yes

//Approach:
// 1. Use 8 directions to count live neighbors for each cell
// 2. Mark transitions: 0→1 as 3, 1→0 as 2 (in-place)
// 3. Final pass: convert 3→1 and 2→0 to update board

public class GameOfLife {
    int[][] dirs;
    int m, n;

    public void gameOfLife(int[][] board) {
        this.dirs = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1,-1}, {1,0}, {1,1}};
        this.m = board.length;
        this.n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = getCount(board, i, j); // number of alive cells around it
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }else if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j){
        int count = 0;

        for(int[] dir : dirs){
            int r = i + dir[0];// row of neighbor
            int c = j + dir[1];// column of neighbor

// check if neighbor is within the grid and check if the neighbor was originally alive
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }
        return count;
    }
}
