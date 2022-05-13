/**
 * 
 * time: O(m*n)
 * space: O(1) -- in-place 
 * 
 * Approach:
 * Rules:
 * originally alive 1 => < 2 alive neighbours => 0 dies due to underpopulation
 * originally alive 1 => > 3 alive neighbours => 0 dies due to overpopulation
 * originally  dead 0 => ==3 alive neighbours => 1 becomes alive due to reproduction
 * originally alive 1 => ==2 or ==3 alive neighbours => 1 continues to live
 * 
 * 1. Iterate over m x n elements and countAlive neighbours 
 *    use dirs array to go to the neighbouring cells
 * 
 * 2. Record transitions and represent it with 2, 3
 *      0 -> 1 record with a 2 - represents previously dead, but now alive
 *      1 -> 0 record with a 3 - represents previously alive, but now dead
 *  While counting the alive neighbours ensure that 3 is being checked for 
 * 
 * 3. change the 2,3 values with the corresponding dead/alive representation
 * 2 -> 1 - now alive
 * 3 -> 0 - now dead
 * 
 */
class Problem {
    int[][] dirs;
    int m, n;
        
    public void gameOfLife(int[][] board) {
        if(board == null) return;
        
        m = board.length; n = board[0].length;
                         // right   left    down     up       up/left
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        
        // 1.Iterate over m x n elements and countAlive neighbours 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countAlive = countAlive(board, i, j); // countAlive neighbours
                
                // 2. Record transitions with 2, 3
                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 2;
                }
                
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = 3;
                }
            }
        }
        
        // 3. change the 2,3 values with the corresponding dead/alive representation
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){               
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }  
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
         
    }
    
    public int countAlive(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int r = i+ dir[0];
            int c = j + dir[1];
            if(r >=0 && r < m && 
               c >= 0 && c < n && 
               (board[r][c] == 1 || board[r][c] == 3) ){
                count++;
            }
        }
        return count;
    }
}