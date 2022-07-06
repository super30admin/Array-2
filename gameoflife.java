// TC : O(m*n)
// SC : O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        int m= board.length;
        int n= board[0].length;
        // assigning different values to 0 and 1 to minimise space complexity
        // 0==>1=====>2 dead becomes alive
        // 1==>0=====>3 alive becomes dead
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLiveNeighbors = countLives(board,i,j); // count live neighbors
                
                // when cell in dead
                if(board[i][j] == 0){   
                    if(countLiveNeighbors == 3){
                        board[i][j] = 2;
                    }
                }
                // when cell in alive
                else{                   
                    if(countLiveNeighbors <2){
                        board[i][j] = 3;
                    }
                    
                    if(countLiveNeighbors >3){
                        board[i][j] = 3;
                    }
                    
                }
            }
        }
        // reassigning the whole matrix in 0s and 1s
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
        // counting neighbor lives
      private int countLives(int[][] board,int r, int c){
            int count=0;
          //to take in account all 8 diections
            int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,-1},{1,1}};
            
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                // so that new row or column doesnt fall out of bounds
                if(nr>=0 && nr<board.length && nc<board[0].length && nc>=0 && (board[nr][nc] == 1 || board[nr][nc] ==3))
                {
                    count++;
                }
            }
            
            return count;
        
    }
}