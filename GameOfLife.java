/**
 * url: https://leetcode.com/problems/game-of-life/
 * Title: 289. Game of Life
 * Time Complexity: O(m*n)
 * Space Complexity: O(1)
 */
public class GameOfLife {

    int moves[][] = {{0, 1}, {0, -1}, {1, 0,}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    // moves in all eight directions.

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alivecount = 0;
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (board[x][y] == 1 || board[x][y] == 2) { // 2 for mar gaya but alive in original state
                            alivecount++;
                        }
                    }
                }
                if (board[i][j] == 1 || board[i][j] == 3) {
                    if (alivecount > 3) { // overpopulation
                        board[i][j] = 2; // 2 for mar gaya
                    }
                    if (alivecount < 2) { // underpopulation
                        board[i][j] = 2; // 2 for mar gaya
                    }
                    if (alivecount == 2 || alivecount == 3) { // underpopulation
                        board[i][j] = 1; // alive
                    }
                }
                if (board[i][j] == 0) {
                    if (alivecount == 3) {
                        board[i][j] = 3; // 3 for new born
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
            int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
            new GameOfLife().gameOfLife(board);
             for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    }
                    if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
             for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
    }
}
