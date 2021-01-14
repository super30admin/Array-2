// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//we will count the number of neighbors for each spot and based on the rules for the game we will assign it either with a
//2(dead) or 3(alive). If there are no changes to the spot it will still have either a 0 and 1 from before. We will go
//through the board again and replace the 2's and 3's with 0s and 1s respectively.

public class GameOfLife {
    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int c = countNeighbors(board, i, j);

                //will die from over/under population
                if(board[i][j] == 1 && (c < 2 || c > 3)){
                    board[i][j] = 2;
                }
                //will become alive
                if(board[i][j] == 0 && c == 3){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //switch 2's and 3's back to 1/0's
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }

    }

    private int countNeighbors(int[][] board, int i, int j){
        //8 diff combinations on where neighbors could be
        int[][] directions = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int count = 0;
        for(int[] d : directions){
            int row = i + d[0];
            int column = j + d[1];
            //check if in bounds and if alive, add to count if alive
            if(row >= 0 && column >= 0 && row <= board.length - 1 && column <= board[0].length - 1 && (board[row][column] == 1 || board[row][column] == 2)){
                count++;
            }
        }
        return count;
    }
}