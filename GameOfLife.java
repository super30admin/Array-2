package S30.Arrays_2;

/*
Time Complexity : O(mn), m -> # of rows, n -> # of columns
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class GameOfLife {

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    int R;
    int C;
    public void gameOfLife(int[][] board) {

        //edge case
        if(board == null || board.length == 0) return;

        //1 ---> 0 = 3
        //0 ----> 1 = 2
        this.R = board.length;
        this.C = board[0].length;


        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){

                int liveNeighbors = calculateLiveCells(i,j,board);
                if (board[i][j] == 1){  //current cell is live
                    if(liveNeighbors < 2 || liveNeighbors > 3){ //conditions 1 and 3
                        board[i][j] = 3;
                    }
                }else if(board[i][j] == 0){
                    if(liveNeighbors == 3){ //condition 4
                        board[i][j] = 2;
                    }
                }
            }
        }

        restoreBoard(board);

    }

    private int calculateLiveCells(int i, int j, int[][] board){

        int liveCount = 0;
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row < 0 || col < 0 || row >= R || col >= C) continue;
            if(board[row][col] == 1 || board[row][col] == 3)
                liveCount++;

        }

        return liveCount;
    }

    private void restoreBoard(int[][] board){

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
}
