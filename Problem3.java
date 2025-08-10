## Problem3 (https://leetcode.com/problems/game-of-life/)

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// 0 -> Lives if it has 3 alive around
// 1 -> lives if it has 2 or 3 alive cells around it
// all Elements around array [00] = [-1-1,-10,-11,0-1,01,1-1,10,11]
// Mark 2 as prev Alive now Dead
// Mark 3 as Prev Dead Now Alive
class Solution {
    int dirs[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int rowLength, colLength;
    public void gameOfLife(int[][] board) {

        rowLength = board.length;
        colLength = board[0].length;

        // Iterate through the complete matrix 1st Pass
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                int count = getCount(board, i,j );                      // get count 
                if(board[i][j] == 0 && count == 3) {                    // case1 if O and count =3
                    board[i][j] = 3;
                }
                else if(board[i][j] == 1 && (count < 2 || count > 3)) { // case2 if 1 and count = 2 or 3
                    board[i][j] = 2;
                }
            }
        }

        //2nd Pass convert All Alive to Alive 3 to 1 and Dead to Dead 2 to 0
        for(int i = 0; i < rowLength; i++) {                            // Itegrate through the matrix and change 3 to 1 and 2 to 0
            for(int j = 0; j < colLength; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
                else if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getCount(int[][] board,int i,int j){                    // get Cound surrounding the matrix index
        int count = 0;
        for (int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // row > 0 , col > 0, row < rowLength , col < colLength, if Alive [1,2] as we are converting alive to 2 in above if 1 previous
            if(r>=0 && c>=0 && r<rowLength && c < colLength && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
    return count;
    }
}