// Game of Life
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// We have to record the state if we consider the same matrix. for 0->1 state we'll mark as 2 and 1->0 state we'll mark as 3.
// We shouldn't change directly 0 & 1 as we need all neighbours for later calculations.
// Then will follow 4 rules mentioned in the ques & to count live neighbours will create a static array & helper function to check these directions.

class Solution {
    private int m;
    private int n;
    private int [][]dirs; //static array

    public void gameOfLife(int[][] board) {
        //null

        m = board.length;
        n = board[0].length;

        dirs = new int[][] {{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        for(int i= 0; i< m; i++) {
            for(int j=0; j< n; j++) {
                int countAlive = countAlive(board, i, j);

                if(board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for(int i= 0; i< m; i++) {
            for(int j=0; j< n; j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }

        }
    }


    public int countAlive(int[][] board, int r, int c) {
        int count =0;
        for(int [] dir : dirs) { //for {-1,0}, r+(-1), c+0
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>= 0 && nc>= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3))
                count++;
        }
        return count;
    }
}