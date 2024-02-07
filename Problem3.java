//## Problem3 (https://leetcode.com/problems/game-of-life/)

// Time Complexity : O(M*N), where M*N is the number of elements in input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// To solve it in-place, we will use the following new states for the transitions:
// 0->1: -2, it denotes that the current cell was previously dead, and now alive
// 1->0: -1, it denotes that the current cell was previously alive, and now dead
// This concept is called "Temporary State Change"

class Solution {

    private int countAlive(int[][] board, int r, int c){
        // Relative distance of all the neighbors to a current cell
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        int count=0;
        for(int[] dir: dirs){
            // Get neighbors co-ordinates
            int nr=r+dir[0];
            int nc=c+dir[1];

            // Check if in bounds and alive
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length && (board[nr][nc]==1 || board[nr][nc]==-1)){
                count++;
            }
        }

        return count;
    }

    public void gameOfLife(int[][] board) {
        // Iterate over the matrix and change state in-place
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int neighborsAlive = countAlive(board,i,j);

                // Apply rules
                if(board[i][j]==1 && neighborsAlive<2){
                    // Mark current as dead - underpopulation
                    board[i][j]=-1;
                }else if(board[i][j]==1 && (neighborsAlive==2 || neighborsAlive==3)){
                    // No change
                    board[i][j]=board[i][j];
                }else if(board[i][j]==1 && neighborsAlive>3){
                    // Mark current as dead - overpopulation
                    board[i][j]=-1;
                }else if(board[i][j]==0 && neighborsAlive==3){
                    // Mark current as alive
                    board[i][j]=-2;
                }
            }
        }

        // Replace the states -2 and -1 with original states
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }else if(board[i][j]==-2){
                    board[i][j]=1;
                }
            }
        }
    }
}