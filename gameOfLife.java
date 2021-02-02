// Time Complexity : O(m*n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// simultaneously, we have to track change of state for a cell.
// If a cell was live and dies in next state (i.e 1 -> 0), we can indicate using -1.
// If a cell was dead and becomes live in next state (i.e 0 -> 1), we can indicate using -2.

// Now, while counting number of live neighbors, we have calculate board cells with value 1 & -1 (because they were live in // previous state, 1 -> 0).
// Also, we don't have to count cells with -2 value (because they were dead in previous state, 0->1).
class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        int x[] = new int[]{-1,-1,-1,0,0,1,1,1};
        int y[] = new int[]{-1,0,1,-1,1,-1,0,1};
        
        for(int i =0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int count = 0;
                for(int dir = 0;dir<8;dir++) {
                    int up = x[dir] + i; 
                    int down = y[dir] + j;
                    if((up >= 0 && up < n) && (down >= 0 && down < m)) {
                        if(board[up][down] == 1 || board[up][down] == -1)
                            count++;
                    }
                }
                
                if(board[i][j] == 1) { // 1->0 is -1
                    if(count < 2 || count > 3)
                        board[i][j] = -1;
                } else if(board[i][j] == 0) { // 0->1 is -2
                    if(count == 3)
                        board[i][j] = -2;
                }
            }
        }
        
        for(int i = 0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == -2)
                    board[i][j] = 1;
            }
        }
        return ;
    }
}
