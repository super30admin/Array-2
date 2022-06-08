// Time complexity:O(n^2)
// space complexity: O(1)

class Solution {
    int[][] direction= new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0) return;
        int m=board.length;
        int n=board[0].length;
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 int countAlive = countAlive(board,i,j);
                 if(board[i][j]==1 && (countAlive < 2 || countAlive >3)){
                     board[i][j]=3;
                 }
                 if(board[i][j]==0 && (countAlive==3)){
                     board[i][j]=2;
                 }
             }
         }
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(board[i][j]==3) board[i][j]=0;
                 if(board[i][j]==2) board[i][j]=1;
             }
         }
        
        return;
    }
    
    public int countAlive(int[][] board ,int i, int j){
        int res=0;
        for( int[] dir : direction){
            int nr = i+dir[0];
                int nc=j+dir[1];
            if(nr >=0 && nc >= 0 && nr< board.length && nc <board[0].length && (board[nr][nc]==1 || board[nr][nc]==3)){
                res++;
            }
        }
        return res;
    }
}
