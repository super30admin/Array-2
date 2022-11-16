/**
 * Leetcode289
 */
public class Leetcode289 {

    int m;
    int n;

    public void gameOfLife(int[][] board) {
        // rules for live cell and dead cell:
        // live cell:
        // if neighbours of live cell is < 2 live cells then it become a dead cell
        // if neighbours of live cell is >3 live cells then it remains live cells

        // dead cell:
        // if neighbours of a dead cell has exact 3 live neighbours then this dead cell
        // will convert
        // into live cell
        // 1-->0 which means live cell is changing to dead cell then store 2 to maintian
        // the state so
        // later on we know this is live cell and chnaged to dead cell
        // 0-->1 which means dead cell is changing to live cell then store 3 to maintian
        // the state so
        // later on we know this is dead cell and chnaged to live cell
        if (board == null || board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int livecells = coutnlive(board, i, j);
                if (board[i][j] == 1) {
                    if (livecells < 2 || livecells > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (livecells == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int coutnlive(int[][] board, int row, int col) {
        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        for (int[] dir : dirs) {
            int newrow = row + dir[0];
            int newcol = col + dir[1];
            if (newrow >= 0 && newcol >= 0 && newrow < m && newcol < n
                    && (board[newrow][newcol] == 1 || board[newrow][newcol] == 2)) {
                count++;
            }
        }
        return count;
    }
}

// time complexity--> O(m*n)
// space complexity--> O(1)