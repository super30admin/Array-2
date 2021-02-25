/* Time: O(mn) + O(mn) => O(mn)
where m = no of rows, n = no of columns

Space: O(1) constant
*/

class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1,-1}, {1,1,}};
    int dead = 2;
    int lived = 3;
    public void gameOfLife(int[][] board) {
        //invalid input
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        //scan the board and update the values
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int aliveN = countNbrs(board, i, j);
                
                // codition 4
                if(board[i][j] == 0 && aliveN == 3)
                    board[i][j] = lived;
                
                //condition 2
                else if(board[i][j] == 1 && (aliveN == 2 || aliveN == 3))
                    board[i][j] = 1; // keep it as it no change
                
                //condition 1 & 3
                else if(board[i][j] == 1 && (aliveN < 2 || aliveN > 3))
                    board[i][j] = dead;
            }
        }
        
        // now just update the values of dead & lived to 0  & 1 resp
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == dead) board[i][j]  = 0;
                else if(board[i][j] == lived) board[i][j] = 1;
            }
        }
    }
    
    //separate function to count no of neighbours
    private int countNbrs(int[][] board, int row, int col){
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for(int[] dir: dirs){
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            if(nrow >= 0 &&  nrow < n && ncol >= 0 && ncol < m && (board[nrow][ncol] == 1 || board[nrow][ncol] == dead))
                count++;
        }
        return count;
    }
}