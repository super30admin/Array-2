// Question https://leetcode.com/problems/game-of-life/
/**
 * Time complexity : O(n*m)
 * Space complexity : O(1)
 * Did this code successfully run on Leetcode : yes
 */
class Solution {
    // 0->1 
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                // get the count of live cells
              int alive = countOfliveCells(board,i,j);  

              if(board[i][j]==0 && alive==3){
                 board[i][j] = 3; // dead will convert into alive
              }else if(board[i][j]==1 && (alive<2 || alive>3)){
                 board[i][j] = 2; // alive will convert into dead
              }  
            }
        }
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]==2){
                    board[i][j] = 0;
                }else if(board[i][j]==3){
                     board[i][j] = 1;
                }
            }
        }
    }
    int countOfliveCells(int[][] board,int i,int j){
        int count = 0;
        for(int[] dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if((nr>=0 && nr<board.length) && (nc>=0 && nc<board[0].length)){
                if(board[nr][nc]==1 || board[nr][nc]==2) count++;
            }
        }
        return count;
    }
}