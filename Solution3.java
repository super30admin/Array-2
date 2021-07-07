// Time complexity: O(m*n), where m*n is the size of the board. 
// Space complexity: O(1). 

class Solution3 {
    // function to calculate the number of live neighbors
    public int liveNeighborCount(int[][] board, int[][] directions, int i, int j) {
        // if board[i][j] == -1, it means it was originally 1. 
        int count = 0;
        for(int d=0; d<8; d++) {
            int newi = i + directions[d][0]; 
            int newj = j + directions[d][1]; 
            if(newi >= 0 && newi<board.length && newj >= 0 && newj<board[newi].length && Math.abs(board[newi][newj]) == 1) {
                count++;
            }
        }
        return count; 
    }
    
    public void gameOfLife(int[][] board) {
        int directions[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        int m = board.length;
        int n = board[0].length; 
        
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                // count the live neighbors.
                int count = liveNeighborCount(board, directions, i, j);
                if(board[i][j] == 0) {
                    if (count == 3) {
                        // change from 0 to 1 is denoted by 2.
                        board[i][j] = 2;
                    }
                }
                else {
                    if (count < 2 || count > 3) {
                        // change from 1 to 0 is denoted by -1.
                        board[i][j] = -1;
                    }
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                // updating the board with correct values.
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}