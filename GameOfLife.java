// Time Complexity : O(N*M) N=rows, col=M
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class GameOfLife {

// Original || New  ||  State
//  0           0        0
//  1           0        1
//  0           1        2
//  1           1        3
//
//  0 --> 1 dead turns alive if alive neightbours are 3 else remains dead
//  1 --> 1 alive remains alive if alive neightbours are 2 or 3 else turns dead

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        //map the states against original values
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols;  j++) {
                int neighbours  = countLiveNeightbours(board, i, j);
                if(board[i][j] == 1) {
                    if(neighbours == 2 || neighbours == 3)
                        board[i][j] = 3;
                }
                if(board[i][j] == 0) {
                    if(neighbours == 3)
                        board[i][j] = 2;
                }
            }
        }
        //map the new value against the states
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols;  j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2 || board[i][j]== 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countLiveNeightbours(int[][] board, int r, int c) {
        int neighbours = 0;
        int rows = board.length;
        int cols = board[0].length;
        for(int i=r-1; i<r+2; i++) {
            for(int j=c-1; j<c+2;  j++) {
                if((i==r && j==c) ||  i<0 || j<0 || i==rows || j==cols)
                    continue;
                if (board[i][j] == 1 || board[i][j] ==3)
                    neighbours+=1;
            }
        }
        return neighbours;
    }
}
