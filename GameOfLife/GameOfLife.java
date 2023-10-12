/* Time Complexity : O(m*n) 
 * 	m - rows of the input matrix - board.length 
 *  n - cols of the input matrix - board[0].length */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {

    //dirs == 8 ==> (i,j) ==> top-left, top, top-right, right, bottom-right, bottom, bottom-left,left
    int[][] dirs = new int[][] {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        int m = board.length;//rows
        int n = board[0].length; // column
        
        /*Transition rule
         * 0 -> 1 ==> replace with 2
         * 1 -> 0 ==> replace with 3 */

        //Iterate and modify/mutate the matrix as per four given rules and above Transition rule
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countAliveNeighbors(board, i, j, m, n);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }

        //Iterate and get to Next state using above Transition rule
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }          
    }

    private int countAliveNeighbors(int[][] board, int i, int j, int m, int n){
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0]; //neighbor row
            int nc = j + dir[1]; //neighbor col

            if(nr >= 0 && nr < m && nc >= 0 && nc < n //boundary condition check
                && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                count ++;
            }
        }
        return count;
    }
}