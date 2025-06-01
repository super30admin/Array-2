//Problem: Game of Life
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                int count = countAlives(board, i ,j);
                if(board[i][j] == 1 && (count < 2 || count >3)){ //alive -> dead i.e. 1 to 0
                    board[i][j] = 5;
                }
                if(board[i][j] == 0 && count ==3 ){ //dead to alive i.e. 0 to 1
                    board[i][j] = 4;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 5){
                    board[i][j] = 0;
                }
                if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countAlives(int [][] board, int r, int c){
        // dir                      r     l     up      down   upright  uplef downrig   downlef
        int[][] dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int result =0;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            //bounds check
            if(nr >=0 && 
            nc >=0 && 
            nr < board.length && 
            nc < board[0].length && 
            (board[nr][nc] == 1 || board[nr][nc] == 5)){
                result++;
            }
        }
        return result;
    }
}