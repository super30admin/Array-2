// Time Complexity : O(mn), where m is the row length and n is the column length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class GameOfLife {
    int m, n;
    public void gameOfLife(int[][] board) {
        //base case
        if(board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                int liveNeighborsCount = countLiveNeighbors(board, i, j);

                //If the cell is dead, check if live neighbours count equals 3.
                //If yes, it becomes alive.
                if(board[i][j] == 0) {
                    if(liveNeighborsCount == 3){
                        //if a cell becomes 0 -> 1, then mark it as 2
                        board[i][j] = 2;
                    }
                } else {
                    if(liveNeighborsCount < 2 || liveNeighborsCount > 3) {
                        //if a cell becomes 1 -> 0, then mark it as 3
                        board[i][j] = 3;
                    }
                }
            }
        }

        //reconstruct the original array by assigning back 2 to 1 and 3 to 0
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int countLiveNeighbors(int[][] board, int r, int c) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int count = 0;

        //parse through all 8 directions
        for(int[] dir: dirs) {
            //find neighbour row and column
            int rn = dir[0] + r;
            int cn = dir[1] + c;

            //check if neighbour row and column is within the range and is live (1 or 3)
            if(rn>=0 && cn>=0 && rn<m && cn<n && (board[rn][cn] == 1 || board[rn][cn] == 3)){
                count++;
            }
        }
        return count;
    }
}