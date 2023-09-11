// Time Complexity : O(M*N)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :yes

/*
 * In first iteration over the matrix we will change the states going from 1-> 0 as -1 and 0 -> 1 as 2 this way we can keep track of previous states while updating states for other cells and change them back to 1 and 0 in second iteration
 */


 class Solution {
    public void gameOfLife(int[][] board) {
        //2 0 -> 1 , -1 1 -> 0
        int[][] directions = {{-1,0}, {-1, 1}, {0, 1}, {1,1}, {1,0}, {1,-1}, {0,-1},{-1,-1}};
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int currState = board[i][j];
                int alive = 0;
                for(int[] dir: directions){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(r >=0 && r< board.length && c >=0 && c<board[0].length){
                        int ns = board[r][c];
                        if(ns == 1 || ns == -1){
                            alive += 1;
                        }
                    }
                }
                if(currState == 0 && alive == 3){
                    board[i][j] = 2;
                }
                else if(currState == 1){
                    if(alive != 2 && alive != 3){
                        board[i][j] = -1;
                    }
                }
            }
        }

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }

        
        
    }
}