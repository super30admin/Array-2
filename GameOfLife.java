// O(n * m) time, O(n * m) space
// class Solution {
//     public void gameOfLife(int[][] board) {
//         int n = board.length;
//         int m = board[0].length;
//         int[][] copy = new int[n][m];

//         int[][] dirs = new int[][] {
//             {0,1},
//             {0,-1},
//             {1,0},
//             {-1,0},
//             {1,1},
//             {-1,1},
//             {1,-1},
//             {-1,-1}
//         };

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 copy[i][j] = board[i][j];
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 int cell = board[i][j];
//                 int live = getLiveNeighbors(i, j, board, dirs);

//                 if (cell == 1 && (live < 2 || live > 3)) {
//                     copy[i][j] = 0;
//                 }
//                 else if (cell == 1 && (live == 2 || live == 3)) {
//                     copy[i][j] = 1;
//                 }
//                 else if (cell == 0 && live == 3) {
//                     copy[i][j] = 1;
//                 }
//                 else {
//                     copy[i][j] = 0;
//                 }
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 board[i][j] = copy[i][j];
//             }
//         }
//     }

//     private int getLiveNeighbors(int i, int j, int[][] board, int[][] dirs) {
//         int n = board.length;
//         int m = board[0].length;

//         int liveCellCount = 0;

//         for (int[] dir : dirs) {
//             int newI = i + dir[0];
//             int newJ = j + dir[1];

//             if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
//                 if (board[newI][newJ] == 1) {
//                     liveCellCount++;
//                 }
//             }
//         }
//         return liveCellCount;
//     }
// }

// O(n * m) time, O(1) space
class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] dirs = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
            {1,1},
            {-1,1},
            {1,-1},
            {-1,-1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cell = board[i][j];
                int live = getLiveNeighbors(i, j, board, dirs);

                if (cell == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 5; // was alive now dead, alive -> dead
                }
                else if (cell == 1 && (live == 2 || live == 3)) {
                    board[i][j] = 1;
                }
                else if (cell == 0 && live == 3) {
                    board[i][j] = 10; // was dead now alive, dead -> alive
                }
                else {
                    board[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 5) { // alive -> dead so now mark dead
                    board[i][j] = 0;
                }
                else if (board[i][j] == 10) { // dead -> alive so now mark alive
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveNeighbors(int i, int j, int[][] board, int[][] dirs) {
        int n = board.length;
        int m = board[0].length;

        int liveCellCount = 0;

        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                if (board[newI][newJ] == 1 || board[newI][newJ] == 5) {
                    liveCellCount++;
                }
            }
        }
        return liveCellCount;
    }
}