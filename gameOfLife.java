public class gameOfLife {
        int m,n;
        public void gameoflife(int[][] board) {
            if(board == null || board.length ==0){
                return;
            }
            m=board.length;
            n=board[0].length;
            //1->0==>2[2 indicates that a live cell becomes dead]
            //1->0==>2[3 indicates that a dead cell becomes alive]
    
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int countLiveNeighbors =countLiveNeighbors(board,i,j);
                    //we have all live cells
                    if(board[i][j] == 1){
                        if(countLiveNeighbors<2 ||countLiveNeighbors>3){
                            board[i][j]=2;
                        }
                    }
                    else if(board[i][j] == 0){
                        if(countLiveNeighbors==3){
                            board[i][j]=3;
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j< n;j++){
                    if(board[i][j]==2){
                        board[i][j]=0;
                    }
                    else if(board[i][j]==3){
                        board[i][j]=1;
                    }               
                }
            }   
        }
        private int countLiveNeighbors(int[][] board,int row,int col){
            int count=0;
            //U D L R UL UR LL LR
            int[][]dirs= {{-1, 0},{1, 0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
            for(int[]dir:dirs){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr >=0 && nr<m && nc >= 0 && nc<n &&(board[nr][nc]==1 || board[nr][nc]==2)){
                    count++;
                }
            }
        return count;
        }
    }
    

