class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveCells = countLiveCells(board, i, j);
                if(board[i][j] == 1) {
                    if(liveCells < 2 || liveCells > 3) {
                        board[i][j] = 2;
                    } 
                }
                else {
                    if(liveCells == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveCells(int[][] board, int row, int col) {
        int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};
        int count = 0;
        for(int[] dir: dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == 2)) {
                count++;
            }
        }
        return count;
    }
}
