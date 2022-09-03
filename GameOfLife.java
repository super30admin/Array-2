/**
## Problem3 (https://leetcode.com/problems/game-of-life/)
 
Time Complexity :   O (M*N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (289. Game of Life)
Any problem you faced while coding this :       No
 */

 class GameOfLife {
    int[][] dir;
    int m;
    int n;
    public int[] gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
 
        // make dir array to check all directions
        dir = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        // 0->1  --->2
        // 1->0  --->3
        for( int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int countAlive = countAlive(board, i, j);
                
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        // visit board again, make 3->0 and 2->1
        for( int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
        return null;
    }
    
    private int countAlive(int[][] board, int i, int j){
        int result = 0;
        
        for(int[] dirs: dir){
            int nr = i+dirs[0];
            int nc = j + dirs[1];
            
            // check boundry
            if(nc >= 0 && nr >= 0 && nc<n && nr<m && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                result++;
            }
        }
        return result;
    }
    
    public static void main(String args[]) 
    { 
        GameOfLife obj = new GameOfLife();
        int[][] board = new int[][]{{1,1,0},{1,0,0},{1,0,1}};
        obj.gameOfLife(board);

        // print result
        for( int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+ " ");
            }
        }
    }
}