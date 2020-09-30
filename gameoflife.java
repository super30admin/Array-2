//Time complexity:O(mn)
//Space Complexity:O(1)

class Solution {
    private int neighbours(int[][] board,int row,int column){
        int m=board.length;
        int n=board[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{1,1},{-1,1}};
        int count=0;
        for(int[] arr:dirs){
            int i=row+arr[0];
            int j=column+arr[1];
            if((i>=0 && i<m) && (j>=0 && j<n)){
                if(board[i][j]==1 || board[i][j]==2) count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int s=neighbours(board,i,j);
                if(board[i][j]==1){
                    if(s<2 || s>3){
                        board[i][j]=2;
                    }
                }
                else{
                    if(s==3){
                        board[i][j]=-2;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-2){
                    board[i][j]=1;
                }
                else if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }
    }
}