// Time Complexity : O(m * n) - m is thwe row length and n is the column length
// Space Complexity : O(1) - No additional data structure is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board == null ) return;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j  < board[0].length;j++){
               int count = directions(i,j,board);
                //System.out.println(count);
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j]%2 == 0){
                    board[i][j] = 0;
                }
                else{
                    board[i][j] = 1;
                }
            }
        }
    }
    public int directions(int row,int col,int[][] board){
            int count = 0;
            int m = board.length;
            int n = board[0].length;
            int[][] dirs = {{1,-1},{1,0},{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1}};
            for(int[] dir : dirs){
                int new_row = dir[0] + row;
                int new_col = dir[1]  + col;
                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n && (board[new_row][new_col] == 1 || board[new_row][new_col] == 2)) count++;
            }
            return count;
    }
}
// Your code here along with comments explaining your approach