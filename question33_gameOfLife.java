package Array2;

public class question33_gameOfLife {

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        //0 -- 1 --> 3
        //1 -- 0 --> 2

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int count = countLives(board, i, j, m, n);
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 1;
                if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    private static int countLives(int[][] board, int i, int j, int m, int n) {
        int result = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int dir[]: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 1 || board[row][col] == 2))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int board[][] = board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }
}
