// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no

class Solution1 {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board== null) return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countLive(board,i,j);
                if(board[i][j]== 1 && (count<2 || count >3)){
                    board[i][j]=3;
                }
                if(board[i][j]==0 && count==3){
                    board[i][j]=2;
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            if(board[i][j]==3) board[i][j] = 0;
            if(board[i][j]==2) board[i][j] = 1;
     }
    }
   }
    private int countLive(int[][] board,int i,int j){
        int result=0;
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int [] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr< m && nc>=0 && nc< n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                result++;
            }
        }
        return result;
    }
}
    
        
