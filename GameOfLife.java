// Time Complexity : O(m*n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : As per the problem and given conditions, we change the alive to dead ones to 2 and dead to alive ones to 3. As all
// operations happen simultaneously according to the problem, we shouldn't consider the updated values so we maintain 2 or 3 for updated
// ones. We first calculate the alives and perform the logic on the count, iterate the array again and transform 2 and 3 to alive or
// dead values in the matrix.

class Solution {
    int m, n;

    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alivesCount = CountAlives(board, i, j);
                if(board[i][j] == 1 && (alivesCount < 2 || alivesCount > 3)){ //as per the condition in problem
                    board[i][j] = 2; // alive to dead.
                }
                if(board[i][j] == 0 && alivesCount == 3){
                    board[i][j] = 3;// dead to alive
                }
            }

        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){// iterate again to make 2's as 0 and 3 as 1
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    public int CountAlives(int[][] board, int i, int j) {
        //All 8 possible directions are stored.
        int directions[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int count = 0;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            if (row >= 0 && row < m && col >= 0 && col < n) { // row and column are within borders.
                if (board[row][col] == 1 || board[row][col] == 2) //as we changed to 2 for alive to dead.
                    count++;
            }
        }
        return count;
    }
}