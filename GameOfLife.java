// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    private int[][] dirs;
    public void gameOfLife(int[][] board) {
        dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countAliveNeighbours(board,i,j,m,n);
                if(board[i][j]==1 && (count < 2 || count > 3)){
                    board[i][j] = 2;  //1-->0
                }else if(board[i][j]==0 && count == 3){
                    board[i][j] = 3;  //0-->1
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAliveNeighbours(int[][] board, int i, int j, int m, int n){
        int count = 0;
        for(int[] dir:dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}