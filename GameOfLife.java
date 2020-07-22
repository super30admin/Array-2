/**
Problem: Find the next state of the board
Time Complexity : O(m*n), where m is the number of rows, n is the number of columns of the given matrix.
Space Complexity : O(1), no additional space is utilized.

Did the problem run on leetcode : Yes

Approach : Modify the matrix in place by keeping note of the previous state transitions using a denotation.
1. We proceed by applying the given rules and change the state and we keep a note of the transition. 
i.e., if a cell's state has been changed after applying the given rules, then we mark the transition from 0 to 1 as 2, and from 1 to 0 as 3.
2. Later, we reiterate thru the matrix, and whereever we find 2s and 3s, we change our states accordinly.
3. After this straightforward process, we are left with the board in its next state.

*/

class Solution {
    public void gameOfLife(int[][] board) {
        //directions of the neighboring cells.
        int[][] directions = {{0,-1},{-1,-1},{-1,0},{1,-1},{1,0},{1,1},{-1,1},{0,1}};
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                int live = 0;
                for(int[]d : directions) {
                    if(i+d[0]<0 || i+d[0] >= board.length || j+d[1] < 0 || j+d[1] >= board[0].length) {
                        continue;
                    }
                    if(board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 3) {
                        live++;
                    }
                }
                
                if(board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}