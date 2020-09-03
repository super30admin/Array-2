// Time Complexity : O(n)
// Space Complexity : O(1) , no extra space other than the returning array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0||board==null||board[0].length==0) return;
        int n=board.length,m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int alive= countAlive(board,n,m, i, j);
                 if(board[i][j]==1 &&(alive<2||alive>3)){
                     board[i][j]=2;
                 }
                else if(board[i][j]==0&&(alive==3)){
                    board[i][j]=4;
                }
                
            }
        }
        for (int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==4){
                    board[i][j]=1;
                }
            }
        }
        
    }
    private static int countAlive(int[][] board, int n, int m, int i, int j){
        int[][] dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int count=0;
        for(int[] dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            
            if(r>=0 && r<n&&c>=0&&c<m &&(board[r][c]==1||board[r][c]==2)){
                count+=1;
            }
        }
        return count;
    }
}