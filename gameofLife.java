/*
 * Time Compl - O(mxn)
 * Space Compl - O(n)
 */


class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        // live -> dead value ->2
        // dead -> live value ->3

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                int countLiveNeighbors = countLiveNeighbors(board, i, j);

                // check for live cell
                if(board[i][j] == 1){
                    if(countLiveNeighbors < 2 || countLiveNeighbors >3){
                        board[i][j] = 2;
                    }
                } else {
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        // traverse matrix to change matrix of 2s and 3s to normal 0s and 1s
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

        private int countLiveNeighbors(int[][] board, int row, int col){

            int m = board.length;
            int n = board[0].length;
            int count = 0;
            int dirs[][] = {
                {-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1},{-1,1}, {1,-1}, {1,1}
            };
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    (board[nr][nc] == 1 || board[nr][nc] == 2)){
                    count++;
                }
            }
            return count;
        }
    }
