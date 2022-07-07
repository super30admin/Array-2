// Time Complexity : O(MXN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board == null){
            return;
        }

        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLives = countLiveNeighbors(board, i, j);

                if(board[i][j] == 0){
                    if(countLives == 3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(countLives < 2 || countLives > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    int countLiveNeighbors(int[][] board, int row, int column){
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int count = 0;

        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = column + dir[1];

        if(newRow >= 0  && newRow < m && newCol >= 0 && newCol < n && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)){
                count++;
            }
        }
        return count;
    }
}