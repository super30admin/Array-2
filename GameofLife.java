// Time Complexity O(m*n)
//Space Complexity O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int neighbors = countLive(board,i,j);
                
                if(board[i][j]==0){
                    if(neighbors==3){
                        board[i][j] = 2;
                    }
                }else{
                    if(neighbors<2){
                        board[i][j]=3;
                    }
                    if(neighbors>3){
                        board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j] = 1;
                }else if(board[i][j]==3){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLive(int[][] board, int row, int col){
        int count = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1}, {-1,-1}, {1,1},{1,-1}};
        int m = board.length;
        int n = board[0].length;
        
        for(int[] dir:dirs){
            int newrow = row + dir[0];
            int newcolumn = col + dir[1];
            
            if(newrow>=0 && newrow<m && newcolumn>=0 && newcolumn <n && (board[newrow][newcolumn]==1 || board[newrow][newcolumn]==3)) {
                count++;
            }
        }
        return count;
    }
}