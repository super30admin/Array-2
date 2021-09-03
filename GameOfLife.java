// Time Complexity : O(m * n) iterating over all elements twice but second time is for generating output matrix, making 2 a constant
// Space Complexity : O(1) directional array of fixed length 8
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class GameOfLife {
    public void gameOfLife(int[][] board) {
        //null check
        if(board.length == 0 || board == null) return;
        
        int m = board.length; //number of rows
        int n = board[0].length; //number of columns
        
        for( int i = 0; i < m; i++ ) {
            for( int j = 0; j < n; j++ ) {
                int count = countLive(board, i, j); //passing current iteration i,j 
                //count stores alive count of neighbors
                
                if(board[i][j] == 1 && (count<2 || count>3)) {
                    //condition: was alive and alive-neighbors either <2 or >3
                    board[i][j] = 3; //new stage 3 (meaning was alive, but now dead)
                }
                
                if(board[i][j] == 0 && count == 3) { 
                    //condition: was dead and alive-neighbors are 3
                    board[i][j] = 2; //new stage 2 (meaning was dead, but now alive)
                }
                
            }
        }
        
        //manipulating matrix again from 2,3 to 0,1
        for( int i = 0; i < m; i++ ) {
            for( int j = 0; j < n; j++ ) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
        
    }
    
    private int countLive(int[][] board, int i, int j) {
        int m = board.length; //number of rows
        int n = board[0].length; //number of columns
        
        int result = 0; //initializing the result int with 0
        
        //{right, left, bottom, top, downRight, downLeft, UpRight, UpLeft}
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        //directional array created
        
        for(int[] dir : dirs) { //finding all 8 neighbors
            int nr = i + dir[0]; //adding row value from directional array to original
            int nc = j + dir[1]; //adding col value from directional array to original
            
            if( nr>=0 && nr<m && nc>=0 && nc<n ) { //borders check
              if( board[nr][nc] == 1 || board[nr][nc] == 3 ) { //alive check with 1 & for old alives with 3
                  result++;
              }
            } 
        } //end of directional for loop
        return result; //returning count of live elements amongst neighbors
    }
    
}