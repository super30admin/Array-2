// Time Complexity: O(m*n)
// Space Complexity: O(1)
// We go cell by cell and count how many live neighbors it has.
// based on the given conditions we mark transitions with temporary values: 2 (alive → dead) and 3 (dead → alive).
// After iterating all the cells we convert 2 ->0 and 3 ->1

class Problem3 {
    public void gameOfLife(int[][] board) {
        int m = board.length; //rows
        int n = board[0].length; // columns

        // alive to dead 1->0 : 2
        // dead to alive 0->1: 3
        for (int i = 0; i<m; i++){
            for(int j=0; j<n;j++) {
                int liveCellCount = getLiveCellCount(board, i, j, m, n);
                // make it dead cell
                if(board[i][j] == 1 && (liveCellCount < 2 || liveCellCount > 3)) {
                    board[i][j] = 2;
                }
                // make it live cell
                if(board[i][j] == 0 && liveCellCount == 3) {
                    board[i][j] = 3;
                }
            }
        }

        // change back to 2 and 3 to actual dead or live cells
        for (int i = 0; i<m; i++){
            for(int j=0; j<n;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0; // it is changed from 1->0
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1; // it is changed from 0->1
                }
            }
        }

    }

    private int getLiveCellCount(int[][] board, int row, int column, int totalRows, int totalColumns){
        int count = 0;
        // initialise the direction matrix for all 8 directions
        int [][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        // iterate over direction array to get  new adjacent cell live and find if new cell is live or not
        for(int[] dir : dirs){
            int nr = row+dir[0];
            int nc = column+dir[1];
            // check for index out of bound and live cell
            if(nr >=0 && nr < totalRows && nc >=0 && nc < totalColumns && (board[nr][nc] ==1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
}