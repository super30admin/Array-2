// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; int n = board[0].length;
        if(board == null || m == 0 || n== 0) return;
        
        for(int i=0; i<m;i++) {
            for(int j=0;j<n;j++) {
                //get count og total number of adjesent nodes of value 1
                int count = getCount(board, i, j, m, n);
                // When 1 -> 0 change we use 3
                // When 0 -> 1 change we use 2
                if(board[i][j] == 1 && (count<2 || count > 3))
                    board[i][j] = 3;
                
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
        }
        //We change the 3's and 2's back to 1 and 0 since we want the original array to be in the same format we got it in
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
    
    public int getCount(int[][] board, int i, int j, int m, int n) {
        // DIfferent directions we can take from our current point
        int [][] dirs = {{0,1}, {0,-1,}, {1,0}, {-1, 0}, {1,1}, {1, -1}, {-1, 1}, {-1,-1}};
        int result = 0;
        for(int[] dir: dirs) {
            int r = i+ dir[0];
            int c = j+ dir[1];
            //Checking if the location is on the board and if it's neightboars are 1
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c] == 1 || board[r][c] == 3)) {
                result++;
            }
        }
        return result;
    }
}
