class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] copyBoard = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                copyBoard[i][j] = board[i][j];
            }
        }
      
        int[] dx = new int[]{1,1,0,-1,-1,-1,0,1};
        int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                
                int liveNeighbors = 0;
                
                for(int k=0;k<8;k++){
if(isSafe(i+dx[k],j+dy[k],board.length,board[0].length) && copyBoard[i+dx[k]][j + dy[k]] == 1){
                        liveNeighbors++;
                    }
                }
                //under population
                if(copyBoard[i][j] == 1 && liveNeighbors < 2){
                    board[i][j] = 0;
                }
                //over population
                if(copyBoard[i][j] == 1 && liveNeighbors > 3){
                    board[i][j] = 0;
                }
                if(copyBoard[i][j] == 0 && liveNeighbors == 3){
                    board[i][j]  = 1;
                }
            }
        }
        
    }
    private boolean isSafe(int x,int y,int m,int n){
        return (x>= 0 && x<m && y>=0 && y<n);
    }
}

//Time complexity : O(N*M)
