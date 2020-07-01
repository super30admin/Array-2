/* Game of Life */

// Time Complexity : O(M*N)
// Space Complexity : O(1) in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*In this problem , I'll be designing a direction list that includes 
all the 8 possible directions from an element. I'll then iterate through 
the direction list to find out the number of neighbors that are alive and 
increment the count. If that count is <2 or greater than 
three I'll make it -1, which I'll be making 0 later. And if my element was dead 
and if the live count of the neighbor is equal to 3, then I'll mark it as 2 which 
I'll later change to 1.I'll repeat this process for the entire matrix and at the end 
I'll update the value of each element by 0,1
*/

class Solution {
    //defining globally
    private int m;
    private int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        //edge case
        if(m == 0 || board == null) return;
        n = board[0].length;
        //iterate
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLive(board, i, j);
                //Case1) and Case3) 1--->0
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = -1;
                }
                //Case4) 0---->1
                if(board[i][j] == 0 && (count == 3)){
                    board[i][j] = 2;
                }
            }
        }
        //then initialise final values to 0,1  after changing states
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }
    }
    //private countLive function 
    private int countLive(int[][] board, int i, int j){
        int count = 0;
        //create dirs array to include all 8 directions and validate the neighbours values
        int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == -1){
                    count++;
                }
            }
        }
        return count;
    }
}