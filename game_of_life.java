// We need to obtain new matrix with the given game of life rules
// In this approach, we simultaneously mark a node as live or dead while not taking into account the changes made during the pass
// TC: O(n) - we do two passes over the matrix one after the other visiting each element exactly once each time
// SC: O(1) - as we are not using any extra data structure

class Solution {
    // Global variables to track the length of rows and columns
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int[][] result = new int[board.length][board[0].length];
        m = board.length;
        n = board[0].length;
        int liveNeighbors = 0;
        // We mark the node as follows to simaltenously manipulate and not effect the next nodes
        // 1 --> 0 == 2
        // 0 --> 1 == 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // Get the live neighbors count
                liveNeighbors = getLiveNeighborsCount(board, i, j);
                // if we encounter alive nodes we mark them dead based on the rules - dead here is 2
                if(board[i][j] == 1) {
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        board[i][j] = 2;
                    }
                }
                // if we encounter dead nodes we mark them live based on the rules - live here is 3
                else {
                    if(liveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        // iterate over board and change 2 --> 0 and 3 --> 1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int getLiveNeighborsCount(int[][] board, int i, int j){
        // Count live neighbors and return them by using directions array
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count = count + 1;
            }
        }
        return count;
    }
}
