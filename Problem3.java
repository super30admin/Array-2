import java.util.Arrays;

public class Problem3 {

    // TC - O(M*N)
    // SC - O(1)

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ncount = 0;

                int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
                for (int[] dir: dirs) {
                    int newr = i + dir[0];
                    int newc = j + dir[1];
                    if(newr >= 0 && newr < m && newc >= 0 && newc < n && (board[newr][newc] == 1 || board[newr][newc] == 2)) ncount++;
                }

                if(board[i][j] == 0 && ncount == 3)
                    board[i][j] = 3;
                else if(board[i][j] == 1 && (ncount < 2 || ncount > 3))
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        System.out.println(Arrays.deepToString(board));
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
