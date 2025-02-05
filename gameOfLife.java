//Problem3 (https://leetcode.com/problems/game-of-life/)

// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 *Here, while traversing each element of the matrix, find the alive neighbours of the element. If element is alive and count of alive neighbours
 of element is less than 2 or greater than 3 make that element dead. If element is dead and count of alive neighbours is exactly 3 make that
 element alive. 
 */

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = countAlive(board, i, j, m, n);
                //Alive
                if(board[i][j]==1 && (countAlive <2 || countAlive >3)){
                    board[i][j] = 2;
                }
                if(board[i][j]==0 && countAlive == 3){
                    board[i][j] = 3;
                }
            }

        }

        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                //Alive
                if(board[i][j]==2){
                    board[i][j] = 0;
                }
                if(board[i][j]==3){
                    board[i][j] = 1;
                }
            }
            
        }
    }

    private int countAlive(int [][]board, int i, int j, int m, int n){
        int dirs[][] = new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>= 0 && nr<m && nc>=0 && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count +=1;
            
            }
        }
        return count;
    }
}
