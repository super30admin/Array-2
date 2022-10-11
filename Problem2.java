// TC : O(m * n * 8(directions)) = O(mn)
// SC: O(1)
class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveNeighbours = countLiveNeighbours(board, i, j);

                if(board[i][j] == 1) { // live cell
                    // satisfying 1,2,3 conditions
                    if(liveNeighbours < 2 || liveNeighbours > 3) {
                        board[i][j] = 2;
                    }
                }
                else { // dead cell
                    // satisfying 4th condition
                    if(liveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // update 2 and 3 back to 0 and 1 respectively
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }

        return;
    }

    private int countLiveNeighbours(int[][] board, int i, int j) {
        int count = 0;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};

        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            // check boundry conditions and if neighbour has value 1 or 0
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }

        return count;
    }
}