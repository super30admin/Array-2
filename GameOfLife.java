// Time Complexity : O(M*N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
public class GameOfLife {
    int m;
    int n;

    public void gameOfLife(int[][] board) {

        if(board.length == 0 || board == null){
            return;
        }

        m = board.length;
        n = board[0].length;


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                int adjacentLiveCells = countLiveCells(board, i, j);
                if(board[i][j] == 1){ // Current element is live cell

                    if(adjacentLiveCells < 2 || adjacentLiveCells > 3){
                        board[i][j] = 2;
                    }

                }else{ // Current element is dead cell
                    if(adjacentLiveCells == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Now marking new Live Cells from 3 -> 1 and new Dead Cells from 2 -> 0

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }

                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLiveCells(int[][] board, int i, int j){

        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,-1},{1,1}};
        int count = 0;


        for(int k = 0; k < dirs.length; k++){

            int p = i + dirs[k][0];
            int q = j + dirs[k][1];

            if((p >= 0 && p <= m - 1) && (q >= 0 && q <= n - 1) && (board[p][q] == 1 || board[p][q] == 2)){
                count++;
            }
        }

        return count;
    }
}
