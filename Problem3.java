// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
we get all possible neighbors of a cell and store in directions and get the count of all alive neighbors(cell with 1's)
We apply rules given to either switch the cell from live to dead or dead to live
We change the state of the original board when we encounter any of the rule and revert it later to corresponding state
*/
class Solution {

    private int getCountAlive(int [][] board, int i, int j, int m, int n) {
        int count = 0;
        //get the live neighbours of particular cell
        int [][] dir = new int[][] 
        { {0, -1}, {0, 1}, {-1, 0}, {1, 0},
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int[] d: dir) {
            int nr = i + d[0];
            int nc = j + d[1];
        
        //boundary checks
        if(nr >= 0 && nr < m && nc >= 0 && nc <n &&
         (board[nr][nc] == 1 || board[nr][nc] == 2)) {
            count ++;
        }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i< m;i++) {
            for(int j=0;j<n;j++) {
                int countAlive = getCountAlive(board, i ,j, m ,n);
                if (board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    board[i][j] = 2; //alive to dead
                }
                if(board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 3; //dead to alive
                }
            }
        }
        //revert all the 2's and 3's to its corresponding alive or dead state
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } 
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
}
