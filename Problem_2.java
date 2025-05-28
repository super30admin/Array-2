/*
 * Question:
 * Implement Conway's Game of Life.
 * Given a board with m x n cells, each cell is either dead (0) or alive (1).
 * The next state is determined by 8 neighbors using these rules:
 * 1. Any live cell with < 2 live neighbors → dies (underpopulation)
 * 2. Any live cell with 2 or 3 live neighbors → lives
 * 3. Any live cell with > 3 live neighbors → dies (overpopulation)
 * 4. Any dead cell with exactly 3 live neighbors → becomes alive (reproduction)
 *
 * Approach:
 * → Since changes should be made simultaneously, use **in-place encoding**:
 *    - 1 → 4: currently alive, will become dead
 *    - 0 → 5: currently dead, will become alive
 * → First pass: calculate new state and encode using 4 or 5
 * → Second pass: decode final state back to 0 or 1
 *
 * countAlive(): Counts valid neighbors (includes checking for encoded states)
 *
 * Time Complexity: O(m * n) — each cell is visited twice
 * Space Complexity: O(1) — no extra space, changes are in-place
 */

import java.util.Arrays;

class Problem_2 {
    static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlives = countAlive(board, i, j);
                if (board[i][j] == 1 && (countAlives < 2 || countAlives > 3)) {
                    board[i][j] = 4;
                }
                if (board[i][j] == 0 && (countAlives == 3)) {
                    board[i][j] = 5;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 5) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 4) {
                    board[i][j] = 0;
                }
            }
        }

    }

    private static int countAlive(int[][] board, int r, int c) {
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 },
                { 1, 0 }, { -1, 0 },
                { 1, 1 }, { -1, 1 },
                { 1, -1 }, { -1, -1 } };
        int result = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
                    && (board[nr][nc] == 1 || board[nr][nc] == 5)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
