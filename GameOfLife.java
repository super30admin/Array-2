// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* APPROACH:
    iterate through the board and count active neighbours.
    to count, check for the neighbouring 8 elements of the cell, if it has a value 2 (ie recently killed, was alive before) or 1, increase count;
    1. if(cell is alive and count<2 or count>3) set to 2
    2. else if (cell is dead and count == 3) set to 3

    once iteration is completed, traverse through the matrix again and set all the 2 values to 0 and 3 values to 1.
 */

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1 && (countAlive(board, i, j) < 2 || countAlive(board, i, j) > 3)){
                    //die
                    board[i][j] = 2;
                }else if(board[i][j] == 0 && countAlive(board, i, j) == 3){
                    //alive
                    board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int countAlive(int[][] board, int i, int j){
        int[][] neighbors = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0, -1},{-1,-1}};
        int count = 0;
        for(int[] neighbor : neighbors){
            int x = i+neighbor[0];
            int y = j+neighbor[1];
            //2 because it was alive before
            if(x>=0 && x < board.length && y>=0 && y < board[0].length && (board[x][y] == 1 || board[x][y] == 2)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(Arrays.toString(board)); //[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

        int[][] board2 = {{1,1},{1,0}};
        gameOfLife(board2);
        System.out.println(Arrays.toString(board2)); //[[1,1],[1,1]]
    }
}
