package S30_Codes.Array_2;

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Array-2

class GameOfLife {
    private static final int
            DEAD = 0,
            LIVE = 1,
            DEAD_TO_LIVE = 2,
            LIVE_TO_DEAD = 3;

    private static final int[][] directions = new int[][]{
            {-1,  0}, // UP
            { 1,  0}, // DOWN
            { 0, -1}, // LEFT
            { 0,  1}, // RIGHT
            {-1, -1}, // UP_LEFT
            {-1,  1}, // UP_RIGHT
            { 1, -1}, // DOWN_LEFT
            { 1,  1} // DOWN_RIGHT
    };

    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                int liveNeighbourCount = aliveNeighbours(board, i, j);

                if(board[i][j] == DEAD){
                    if(liveNeighbourCount == 3)
                        board[i][j] = DEAD_TO_LIVE;
                }
                else{
                    if(liveNeighbourCount < 2 || liveNeighbourCount > 3)
                        board[i][j] = LIVE_TO_DEAD;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == LIVE_TO_DEAD)
                    board[i][j] = DEAD;
                else if(board[i][j] == DEAD_TO_LIVE)
                    board[i][j] = LIVE;
            }
        }
    }

    private int aliveNeighbours(int[][] board, int i, int j){
        int aliveCount = 0;

        for(int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];

            if(row<0 || row>=board.length || col<0 || col>=board[0].length)
                continue;

            if(board[row][col] == LIVE || board[row][col] == LIVE_TO_DEAD)
                aliveCount++;

        }
        return aliveCount;
    }
}