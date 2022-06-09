class Solution {
    //Time complexity:O(m*n)
    //Space complexity:O(1)
    private int m;
    private int n;
    int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int c=countCells(board,i,j);
                if(board[i][j]==1 && (c<2 || c>3)){
                    board[i][j]=3;
                }
                if(board[i][j]==0 && c==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    private int countCells(int[][] board,int i,int j){
        int res=0;
        for(int[] d:dir){
            int nr=d[0]+i;
            int nc=d[1]+j;
            if(nc>=0 && nr>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==3)){
                res++;
            }
        } 
        return res;
    }
}