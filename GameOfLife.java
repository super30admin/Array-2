/**TC - O(M*N) where m - numbe rof rows, n - number of columns
 * SC - O(1)
 * Ran on leetcode - yes
 */



class Solution {
    public void gameOfLife(int[][] board) {
        //1 --> 0 -> 3  live to dead,  mark this transition as 3
        //0 --> 1 -> 2  dead to alive, mark  this transition as 2
        
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0 ; j <board[0].length; j++){
                
                int count = countLives(board, i , j );
                if (board[i][j] == 0 && (count == 3)){
                    // if originially the cell was dead, make it alive based on the rule
                    board[i][j] = 2;
                }
                
                if (board[i][j] == 1 && ( (count < 2) || (count > 3) ) ) {
                    // if originally the cell was alive
                    board[i][j] = 3;
                }
            }
        }
        
       
        // Restore the original array
        for (int i = 0 ; i < board.length; i++) {
             for (int j = 0 ; j < board[0].length; j++) {
                 if (board[i][j] == 2){
                     board[i][j] = 1;
                 }
                 if (board[i][j] == 3){
                     board[i][j] = 0;
                 }
             }
        }
        
    }
    
    
    public int countLives(int[][] board, int i, int j){
        
        int ans = 0 ; 
        int[][] dirs = new int[][] {{0,-1}, {0,1}, {1,-1}, {1,1}, {1,0}, {-1,0}, {-1,-1},{-1,1}};
        for (int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
                
            if (r < board.length && r >=0 && c >=0 && c < board[0].length && (board[r][c] == 1  || board[r][c] == 3)){
                    ans += 1;      
            }
        }
        
        return ans;
    }
}
