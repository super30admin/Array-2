//In this problem, we need to update the given board. If we do so, we might loose old value. To retain it, we will update the values other than 0 or 1[as 0 and 1 are given in input]
//TC: 8*O(m*n); SC:O(1)


class Solution {
    public void gameOfLife(int[][] board) {

        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int active=getAliveCount(board,i,j);

                if(board[i][j] == 1 && (active>3 || active<2)){
                    board[i][j]=2;
                }

                if(board[i][j] == 0 && (active==3)){
                    board[i][j]=3;
                } 


            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }

                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
    }

    private int getAliveCount(int[][] board, int i, int j){
        int[][] dir=new int[][]{
            {-1,-1},{0,-1},{-1,0},{1,1},{0,1},{1,0},{-1,1},{1,-1}
        };

        int ans=0;

        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];

            if((r>=0 && r<board.length) && (c>=0 && c<board[0].length)){
                if(board[r][c]==1 || board[r][c]==2){
                ans+=1;
            }

            }
            

        }

        return ans;
    }
}
