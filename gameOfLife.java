//time complexity O(n)
//space complexity O(1)

class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveCount = countLives(board, i, j);
                if(board[i][j] == 1){
                    if(liveCount < 2 || liveCount > 3){
                    board[i][j] = -100;
                    }
                } else {
                    if(liveCount == 3){
                        board[i][j] = 100;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == -100){
                    board[i][j] = 0;
                }
                if(board[i][j] == 100){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countLives(int[][] board, int i, int j){
            int count = 0;
            int [][] dirs = {{0,1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(r >= 0 && c >= 0 && r < m && c < n &&
                   (board[r][c] == 1 || board[r][c] == -100)){
                    count++;
                }
            }
            return count;
        }
}
