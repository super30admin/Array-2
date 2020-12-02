//Time Complexity:O(M*N)
// Space Complexity : O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        int[] neigh = new int[]{-1, 0, 1};
        
        for(int row = 0; row < board.length; row++) {
            for(int col = 0 ; col < board[0].length; col++) {
                int liveneigh = 0;
                
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        if(!(neigh[i] == 0 && neigh[j] == 0)) {
                            int r = row + neigh[i];
                            int c = col + neigh[j];
                            
                            if((r >= 0 && r < board.length) && (c >= 0 && c < board[0].length) && (Math.abs(board[r][c]) == 1))
                                liveneigh++;
                            
                        }
                    }
                }
                    // System.out.println(liveneigh);

                if((board[row][col] == 1) && (liveneigh < 2 || liveneigh > 3)) 
                    board[row][col] = -1;
                if(board[row][col] == 0 && liveneigh == 3)
                    board[row][col] = 2;
                
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] > 0){
                    // System.out.println(board[i][j]);
                    board[i][j] = 1;
                }
                else{
                    board[i][j] = 0;
                }
            }
        }
        
    }
}
