class Problem3 {
    public static void main(String[] args) {
        int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int count = setState(board, i, j, m, n);
                if (board[i][j] == 1) {
                    board[i][j] = count > 3 || count < 2 ? 2 : 1;
                } else if (board[i][j] == 0) {
                    board[i][j] = count == 3 ? 3 : 0;
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int setState(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (i > 0)
            count += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
        if (i < m)
            count += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
        if (j > 0)
            count += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
        if (j < n)
            count += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
        if (i > 0 && j > 0)
            count += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
        if (i > 0 && j < n)
            count += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
        if (i < m && j > 0)
            count += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
        if (i < m && j < n)
            count += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
        return count;
    }
}