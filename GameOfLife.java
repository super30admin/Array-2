// Time Complexity : O(m*n) where m is rows and n - colns of given board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        // 1 --> 0 = 3 and 0 --> 1 = 5

        for(int i = 0;i<board.length;i++){
            for(int j=0; j < board[0].length;j++){
                int count = countLives(board,i,j);
                if(board[i][j] == 1 && (count < 2 || count >3)){
                    board[i][j] = 3;
                }else if(board[i][j] == 0 && (count == 3))
                    board[i][j] = 5;
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j=0; j < board[0].length;j++){
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 5)
                    board[i][j] = 1;
            }
        }
    }
    private int countLives(int[][] nums,int i, int j){
        int[][] dirs = new int[][]{ {-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1} };
        int count = 0;
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<nums.length && c>=0 && c<nums[0].length && (nums[r][c] == 1 || nums[r][c] == 3))
                count++;
        }
        return count;
    }
}