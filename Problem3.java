// Problem3 (https://leetcode.com/problems/game-of-life/)


// Time Complexity : O(nm) where n snd m are the row and column dimensions
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        // 0 -> 2   Making 0 to 1
        // 1 -> -1  Making 1 to 0
        m = board.length;
        n= board[0].length;

        //Edge case
        if(board == null || board.length == 0)
            return;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveNeighbors = countLives(board,i,j);
                //Case 1 & case 3
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)){
                    board[i][j] = -1;
                }

                //Case 4
                if(board[i][j] == 0 && liveNeighbors == 3){
                    board[i][j] = 2;
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }


    }

    private int countLives(int[][] board,int i,int j){
        int count= 0 ;
        //To visit all boxes
        int[][] direction = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int[] d : direction){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && r <m && c>=0 && c<n){
                if(board[r][c] == 1 || board[r][c] == -1)
                    count++;
            }
        }
        return count;
    }


}