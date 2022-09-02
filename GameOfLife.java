class GameOfLife {
    public void gameOfLife(int[][] board) {
    if(board==null)
        return;
 
    int numR = board.length;
    int numC = board[0].length;
    
    if (numR == 0 || numC == 0)
        return;
 
    int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
 
    for(int i=0; i<numR; i++){
        for(int j=0; j<numC; j++){
            int numNeighbours = 0;
            
            for(int k=0; k<dirX.length; k++){
                int moveX = i + dirX[k];
                int moveY = j + dirY[k];
                
                if(moveX >= 0 && moveX<numR && moveY>=0 && moveY<numC && (board[moveX][moveY]&1)==1){
                    numNeighbours++;
                }
            }
 
            if(numNeighbours<2){
                board[i][j] &= 1;
            }
            if(numNeighbours==2||numNeighbours==3){
                board[i][j] |=  board[i][j]<<1;
            }
            if(numNeighbours==3){
                board[i][j] |=2;
            }
            if(numNeighbours>3){
                board[i][j] &=1;
            }
        }
    }
 
    for(int i=0; i<numR; i++){
        for(int j=0; j<numC; j++){
            board[i][j] = board[i][j]>>1;
 
        }
    }
}
}
