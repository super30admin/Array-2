// Approach: Traverse the board cell by cell, marking each cell as live or dead based on the given conditions. The key is to use
// numbers other than 1 and 0 to mark a cell as live or dead to avoid miscalculating the number of live neighbors.
// Time Complexity: O(m * n) where m - #rows, n - #cols
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/game-of-life/description/

public class GameOfLife {

//    The board is made up of an m x n grid of cells, where each cell has an initial state:
//    live (represented by a 1) or dead (represented by a 0).

//    Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
//    1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
//    2. Any live cell with two or three live neighbors lives on to the next generation.
//    3. Any live cell with more than three live neighbors dies, as if by over-population.
//    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

//    The next state of the board is determined by applying the above rules simultaneously to every cell in the current state
//    of the m x n grid board. In this process, births and deaths occur simultaneously.

//    Given the current state of the board, update the board to reflect its next state.

    void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Board can't be null or empty..");
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = Integer.MIN_VALUE;
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == Integer.MAX_VALUE) {
                    board[i][j] = 1;
                } else if (board[i][j] == Integer.MIN_VALUE) {
                    board[i][j] = 0;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    int countLiveNeighbors(int[][] board, int row, int col) {
        int[] rowN = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] colN = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if (row + rowN[i] >= 0 && row + rowN[i] < board.length && col + colN[i] >= 0 && col + colN[i] < board[0].length) {
                if (board[row + rowN[i]][col + colN[i]] == 1 || board[row + rowN[i]][col + colN[i]] == Integer.MIN_VALUE) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void withExtraSpace(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (live == 2 || live == 3) {
                        ans[i][j] = 1;
                    }
                } else {
                    if (live == 3) {
                        ans[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[i][j];
                System.out.print(ans[i][j] + " ");
            }
             System.out.println();
        }
    }

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        // Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        // Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        gol.gameOfLife(board); // prints board reflecing next state after playing game of life
    }
}