// Time Complexity : o(m *n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// here we know that array has only 1 or 0 so we denote 1 made 0 as 2 and 0 made 1 as 3 later replace them 
// this helps us to make soln o(1) space complexity
// to get the direction of all neighbouring cells i've made use of dirs matrix
// Your code here along with comments explaining your approach
public class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
         m = board.length;
        n = board[0].length;
        // 1-->0 marked as 2
        //0-->1 marked as 1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int countLiveCells = getCount(board, i, j); //getCount method gets us count of all live cells nearby
                if(board[i][j] == 1) {
                    if(countLiveCells < 2 || countLiveCells > 3) {
                        board[i][j] = 2;
                    }
                }
                else {
                    if(countLiveCells == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        //once we are done manipulating array, time to change 2's and 3's to their original values
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        } 
    }
    private int getCount(int[][] board, int r, int c) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        int total = 0;
        for(int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                total++;
            }
        }
        return total;
    }
}
