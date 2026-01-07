// Time Complexity : O(M*N), Go through each cell in the board
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// We can do this by counting live neighbors at each cell. Copy the matrix and apply the rules to each cell and decide whether
// the cell is live or dead. Extra space is needed - O(M*N).
// To do it in place, we need to identify the cells that have gone from live to dead and vice versa, so we use another
// number 2 to represent 1-> 0 and 3 as to represent state 0->1.
// 1 --> 0 = 2
// 0 --> 1 = 3
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // directions for finding 8 neighbors
        int[][] dirs = {{0,1},{1,0}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = getLiveNeighborsCount(board, i, j, dirs);
                // Apply rules if cell is live
                if(board[i][j] == 1){
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        board[i][j] = 2;
                    }
                }else {
                    // Apply rules if cell is dead
                    if(liveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // replace 3 with 1 and 2 with 0, the state they actually represents
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }

                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getLiveNeighborsCount(int[][] board, int i, int j, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs){
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            if(newRow < 0 || newCol < 0 ) continue;
            if(newRow >= board.length || newCol >= board[0].length) continue;

            // count if there are live neighbors + the neighbors that were live before getting updated.
            if(board[newRow][newCol] == 1 || board[newRow][newCol] == 2){
                count++;
            }
        }

        return count;
    }
}
