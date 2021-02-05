class gameoflife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        //initializing n,m
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count= countlives(board, i, j, n, m);
                //2--->alive--->dead
                //3--->dead---->alive
                if(board[i][j]==1){
                    if(count>3){//condition 3
                        board[i][j]=2;
                    }
                    else if(count==2 && count==3){//condition 2
                        board[i][j]=3;
                    }
                    else if(count<2){//condition 1
                        board[i][j]=2;
                    }
                }
                else if(board[i][j]==0){
                    if(count==3){//condition 4
                        board[i][j]=3;
                    }
                }
            }
        }
        // changing 2--->0, 3---->1
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }

            }
        }
    }
    //This is function for count of lives using directions
    private int countlives(int[][] board, int i, int j, int n, int m){
        int[][] dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int count=0;
        for(int[] dir : dirs){
            int r= i + dir[0];
            int c= j + dir[1];

            if(r>=0 && r<n && c>=0 && c<m && (board[r][c]==1 || board[r][c]==2)){
                count+=1;
            }
        }
        return count;
    }
}

//Time complexity=o(n*m)
//space complexity=o(1)
