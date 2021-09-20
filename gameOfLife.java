//Time complexity: O(MN)
//Space complexity: O(1)
class Solution {
    int[][] directions;
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board == null) {
            return;
        }
        m = board.length;
        n = board[0].length;
        directions = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}, {1,1}, {1,-1}, {-1,1},{-1,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countLives(board, i, j);
                if(board[i][j] == 1 && (count < 2 || count > 3 )) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLives(int[][] board, int i, int j) {
        int result = 0;
        for(int[] direction: directions) {
            int row = direction[0] + i;
            int col = direction[1] + j;
            if(row >= 0 && col >= 0 && row < m && col < n && (board[row][col] == 1|| board[row][col] == 3)) {
                result++;
            }
        }
        return result;
    }
}