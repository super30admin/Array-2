// TimeComplexity: O(mn)
// SpaceComplexity: O(1)
// Explanation: We iterate through each cell, count its 8 neighbors, and mark state transitions in-place using temporary values (2 and 3) to preserve original states during computation. 
// After the first pass, we convert the temporary states to their final values in a second pass.

class Solution {
    public void gameOfLife(int[][] board) {
        // 1-->0 ==2;
        // 0-->1 ==3;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                board[i][j] = 2;          // live → dead
            } else if (board[i][j] == 0 && count == 3) {
                board[i][j] = 3;          // dead → live
            }

            }   
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j) {
         
         int count =0;
         int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},{ 0, -1},{ 0, 1},{ 1, -1}, { 1, 0}, { 1, 1}};
         for (int k =0; k<dir.length; k++) {
            int newi = i+dir[k][0];
            int newj = j+dir[k][1];
            if(newi > -1 && newi < board.length && newj >-1 && newj < board[0].length && (board[newi][newj] == 1 || board[newi][newj] == 2)){
                count+=1;
            }
         }

         return count;
    }
}
