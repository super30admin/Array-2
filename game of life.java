time complexity: O(m*n)
space complexity: O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        // defines 2 to be a 1 -> 0 case, defines -1 to be a 0 -> 1 case
        //cases: if live n>3, then dead
        //if live, n>2, then dead
        //dead, n==3, then alive
        //live, 2 or 3 alive, then alive
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                int num = numOfLive(board, i, j);
                if (board[i][j] >= 1){
                    if (num < 2 || num > 3) {
                        board[i][j] = 2;
                    }
                }
                else{
                    if (num == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
    private int numOfLive(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (!(i == x && j == y) && isLive(board, i, j)) {
                    count ++;
                }
            }
        }
        return count;
    }
    private boolean isLive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] >= 1) {
            return true;
        }
        return false;
    }
}