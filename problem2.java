// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


class Solution {
    int m;
    int n;
    int[][] dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        //1--> 0 then mark as 2
        //0--> 1 then mark as 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countlive=countAlive(board, i, j);
                if(board[i][j]==1 && (countlive<2 || countlive>3)){
                    board[i][j]=2;
                }
                else if(board[i][j]==0 && countlive==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    
    private int countAlive(int[][] board, int r, int c){
        int count=0;
        for(int[] dir:dirs){
            int nr= r+dir[0];
            int nc= c+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc < n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }
}