// Time Complexity = O(m*n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Logic: Traverse the board and check its neighbors count and these are the conditions which make the change happen in the value:
//currValue   condition   newValue
//  1            <2   =>     0
//  1            >3   =>     0
//  0            =3   =>     1
// mark 1->0 => 2 and 0->1 => 3 in the board, and run another for loop to change it back to 2->0 and 3->1

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length==0) return;
        m = board.length;
        n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                countNeighbors(board, i, j);
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void countNeighbors(int[][] board, int r, int c) {
        int[][] neighbors = new int[][] {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int count = 0;
        for (int i=0; i<neighbors.length; i++) {
            int rValue = r + neighbors[i][0];
            int cValue = c + neighbors[i][1];
            if ((rValue >= 0) && (rValue<m) && (cValue >= 0) && (cValue<n) && (board[rValue][cValue]==1 || board[rValue][cValue]==2)) {
                count++;
            }
        }
        if (board[r][c] == 1 && (count<2 || count>3)) {
            board[r][c] = 2;
        }
        else if (board[r][c] == 0 && count==3) {
            board[r][c] = 3;
        }
    }
}