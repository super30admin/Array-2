class GameOfLife {
    public void gameOfLife(int[][] board) {
        /*
        Approach: 
        1.Mark the comversion of 1 to 0 as 2 and that of 0 to 1 as 3 , we donot have any other nos other than 0 or 1 
        2. Remap 2->0 and 3->1
        
        TC: O(m*n) where m is the no of rows and n is the number of columns. 
        SC: O(1)

        */


        if(board==null || board.length==0 || board[0].length==0) return;

        int m=board.length;
        int n=board[0].length;

        // 1 -> 0 - 2
        // 0 -> 1 - 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count= countOnes(board,i,j);
                if((count<2 || count>3) && board[i][j]==1){
                    board[i][j]=2;
                }
                else if(count==3 && board[i][j]==0){
                    board[i][j]=3;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count= countOnes(board,i,j);
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    public int countOnes(int board[][],int i,int j){
        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        int count=0;
        for(int dir[]:dirs){
            int r=i+dir[0];
            int c=j+dir[1];

            if(r>=0 && r<board.length && c>=0 && c<board[0].length && (board[r][c]==1|| board[r][c]==2)){
                count++;
            }
        }
        return count;
    }
}