// Time Complexity : O(mxn)
// Space Complexity : O(1) I have not used any extra space.
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 

class Solution {
    public void gameOfLife(int[][] board) {
        // 0 -> 2 -> 1
        // 1 -> 3 -> 0
        int r = board.length;
        int c = board[0].length;
        int [][] dirs = new int [][]{
            //left, right, down, up
            {-1,0}, {1,0}, {0,1},{0,-1},
            //top-left,top-right, bottom-left,bottom-right
            {-1,1},{1,1},{-1,-1},{1,-1}
        };
        for(int i = 0;i < r; i++){
            for(int j = 0; j<c; j++){
                int aliveCount = getAliveCount(board, dirs, i, j, r, c);
                if(board[i][j] == 1){
                    if(aliveCount < 2 || aliveCount > 3){
                        board[i][j] = 3;
                    }
                }else{
                    if(aliveCount == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        //convert numbers to 1 and 0
        for(int i = 0;i < r; i++){
            for(int j = 0; j<c; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getAliveCount(int[][] board, int [][] dirs, int i, int j, int r, int c){
        int count = 0;
        for(int[] dir: dirs){
            int idxI = dir[0] + i;
            int idxJ = dir[1] + j;

            //handle borders
            if(idxI >=0 && idxI < r && idxJ >= 0 && idxJ < c 
                && (board[idxI][idxJ] == 1 || board[idxI][idxJ] == 3)){
                   count++;
            }
        }
        return count;
    }
}