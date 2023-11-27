// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

//Evaluate edges and corners and iterate through array to calculate next values
//To identify current or prev value, temporarily mark changed values with -1 and -2 for prev 1 and 0.
//At the end, change the negatives to their corresponding positives to mark the board with next state.
public class GameOfLife {
    public static void main(String ar[]) {
        GameOfLife g = new GameOfLife();
        int[][] in = new int[][]{{0}, {0}, {1}, {1}, {1}, {0}};
        g.gameOfLife(in);
    }


    public void gameOfLife(int[][] board) {
        //Null check
        if (board == null || board.length == 0) return;

        if (board.length <= 1 || board[0].length <= 1) {
            //Edge conditions for just row array or just 1 value arrays
            int prev, next;
            board[0][0] = 0;
            board[board.length - 1][0] = 0;
            board[0][board[0].length - 1] = 0;
            board[board.length - 1][board[0].length - 1] = 0;
            for (int i = 1; i < board.length - 1; i++) {
                prev = board[i - 1][0];
                next = board[i + 1][0];
                if (board[i][0] == 1) {
                    if ((prev == 0 || prev == -2) || next == 0)
                        board[i][0] = -1;
                }

            }
            for (int i = 1; i < board.length; i++) {
                if (board[i][0] == -2) board[i][0] = 1;
                else if (board[i][0] == -1) board[i][0] = 0;
            }

            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = 0;
                if (i == 0) {
                    if (j == 0) { //top left corner
                        if (board[i][j + 1] == 1) c++;
                        if (board[i + 1][j] == 1) c++;
                        if (board[i + 1][j + 1] == 1) c++;
                    } else if (j == n - 1) { //top right corner
                        if (Math.abs(board[i][j - 1]) == 1) c++;
                        if (board[i + 1][j - 1] == 1) c++;
                        if (board[i + 1][j] == 1) c++;
                    } else { //top row
                        if (Math.abs(board[i][j - 1]) == 1) c++;
                        if (board[i][j + 1] == 1) c++;
                        if (board[i + 1][j] == 1) c++;
                        if (board[i + 1][j - 1] == 1) c++;
                        if (board[i + 1][j + 1] == 1) c++;
                    }
                } else if (j == 0) {
                    if (i == m - 1) { //down left corner
                        if (Math.abs(board[i - 1][j]) == 1) c++;
                        if (Math.abs(board[i - 1][j + 1]) == 1) c++;
                        if (board[i][j + 1] == 1) c++;
                    } else {//left row
                        if (Math.abs(board[i - 1][j]) == 1) c++;
                        if (Math.abs(board[i - 1][j + 1]) == 1) c++;
                        if (board[i][j + 1] == 1) c++;
                        if (board[i + 1][j + 1] == 1) c++;
                        if (board[i + 1][j] == 1) c++;
                    }
                } else if (i == m - 1 && j == n - 1) { //down right
                    if (Math.abs(board[i][j - 1]) == 1) c++;
                    if (Math.abs(board[i - 1][j - 1]) == 1) c++;
                    if (Math.abs(board[i - 1][j]) == 1) c++;
                } else if (i == m - 1 && j < n - 1) { //down row
                    if (Math.abs(board[i][j - 1]) == 1) c++;
                    if (Math.abs(board[i - 1][j - 1]) == 1) c++;
                    if (Math.abs(board[i - 1][j]) == 1) c++;
                    if (Math.abs(board[i - 1][j + 1]) == 1) c++;
                    if (board[i][j + 1] == 1) c++;
                } else if (j == n - 1) { //right row
                    if (Math.abs(board[i - 1][j]) == 1) c++;
                    if (Math.abs(board[i - 1][j - 1]) == 1) c++;
                    if (Math.abs(board[i][j - 1]) == 1) c++;
                    if (Math.abs(board[i + 1][j - 1]) == 1) c++;
                    if (board[i + 1][j] == 1) c++;

                } else { // in between elements
                    if (Math.abs(board[i - 1][j - 1]) == 1) c++;
                    if (Math.abs(board[i - 1][j]) == 1) c++;
                    if (Math.abs(board[i - 1][j + 1]) == 1) c++;
                    if (Math.abs(board[i][j - 1]) == 1) c++;
                    if (Math.abs(board[i][j + 1]) == 1) c++;
                    if (board[i + 1][j - 1] == 1) c++;
                    if (board[i + 1][j] == 1) c++;
                    if (board[i + 1][j + 1] == 1) c++;
                }
                if (board[i][j] == 0 && c == 3) board[i][j] = -2;
                if (board[i][j] == 1 && (c < 2 || c > 3)) board[i][j] = -1; //prev = 1 now 0

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }

    }
}
