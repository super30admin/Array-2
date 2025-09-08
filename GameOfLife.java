// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
* keep track of 8 neighbours and to do so use this dir array
* live -> dead: mark them as 2 so we know originally they were alive
* dead -> live: mark them as 3, so we know originally they were dead
* convert 3->1 and 2->0
*/

class Solution {

    public void gameOfLife(int[][] board) {
        // to get all 8 neighbours
        int[][] dirs = {{0,1}, {1,0}, {1,1}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}};
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                //count number of live neighbours
                for(int[] dir : dirs){
                    int r = i + dir[0];
                    int c = j + dir[1];

                    if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2))
                        count++;
                }
                if(board[i][j] == 1){
                    if(count < 2 || count > 3)
                        board[i][j] = 2;
                }
                else
                    if(count == 3)
                        board[i][j] = 3;
            }
        }

        // swap 2 and 3 with dead and live (convert it to the original state)
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }

    }
}