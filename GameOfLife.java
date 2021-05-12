/*

Thought Process: Find neighbours 1 counts and perform according to the given logic. If 0 is converted to 1 mark it as 3 and if 1 is converted to 0 mark it as 2 to mark the changes. Once all the changes for each cell is done, revert the 3 bac to 1 and 2 back to 0.

T.C -> It seems like 3 Loops ->  2 for to loop into matrix and 1 to count dirs. But dirs is always constant of size 8. So, the T.C will be O(MN) where M is row and N is col lengths of board

S.C -> Updating in the board itself. So we have S.C as O(1)

*/

class GameOfLife {
    
    int m,n;
    
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 ) return;
        
        m = board.length;
        n = board[0].length;
        
        // 1 -> 0 // Make it 2
        // 0 -> 1 // make it 3
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = countLives(board, i, j);
                if(board[i][j] == 1 && count < 2)
                    board[i][j] = 2;
                if(board[i][j] == 1 && (count == 2 || count == 3))
                    board[i][j] = 1;
                if(board[i][j] == 1 && count > 3)
                    board[i][j] = 2;
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 3)
                    board[i][j] = 1;
                if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }
    
    private int countLives(int[][] board, int row, int col){
        int count = 0;
        int[][] dirs = {{0,1}, {1,0}, {1,1}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        
        for(int[] dir: dirs){
            int r = dir[0] + row;
            int c = dir[1] + col;
            
            if(r >= 0 && c >= 0 && r<m && c<n && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }
        return count;
    }
}