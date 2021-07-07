//Time Complexity: O(M.N.8) = O(M.N); M is nof columns and N is no of rows in a board
//Space Complexity:O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board[0].length == 0){
            return;
        }
        int m= board.length;
        int n= board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                int count = calculateNeighborCount(board,i,j,m,n);
                if(board[i][j]==1 && (count<2 || count>3)){ // condition 1 & 3
                    board[i][j]=3; // die
                } else if (board[i][j]==0 && (count==3)){ // condition 4
                    board[i][j]=2; // alive
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                } else if (board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }

    public int calculateNeighborCount(int[][] matrix,int i,int j,int m,int n){
        int result=0;
        int[][] distArray={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int[] dist: distArray){
            int row=i+dist[0];
            int col = j+dist[1];
            if(row>=0 && row<=m-1 && col<=n-1 && col>=0)
            {
                if(matrix[row][col] == 1 || matrix[row][col] == 3){
                    result++;
                }
            }
        }
        return result;
    }
}