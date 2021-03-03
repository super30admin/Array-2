// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length,m=board[0].length;
        // 1) live neighbors < 2 || live neighbors > 3 => live dies
        // 2) live neighbors == 3 => dead to live
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cells = neighbors(board,i,j);
                if(board[i][j] == 1 &&(cells >3 || cells < 2))
                    board[i][j] = 3;
                else if(board[i][j] == 0 && cells == 3)
                    board[i][j] = 2;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    public int neighbors(int[][] board,int i,int j){
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1},{1,-1},{-1,1},{-1,-1},{1,1}};
        int count =0;
        for(int[] d:dirs){
            int r = i+d[0];
            int c = j+d[1];
            if(r >= 0 && r < board.length && c >= 0 && c<board[0].length && (board[r][c] == 1 || board[r][c] == 3))
                count++;
        }
        return count;
    }
}
