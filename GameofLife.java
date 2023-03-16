class Solution {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Initial state:");
        printBoard(board);

        gameOfLife(board);

        System.out.println("Next state:");
        printBoard(board);
    }

    public static void gameOfLife(int[][] board) {
        int[][] nextBoard = new int[board.length][board[0].length];

        // Iterate through each cell in the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // Get the current cell's state and count the number of live neighbors
                int state = board[row][col];
                int liveNeighbors = countLiveNeighbors(board, row, col);

                // Apply the rules of the game to determine the next state of the cell
                if (state == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    nextBoard[row][col] = 0; // Cell dies due to underpopulation or overpopulation
                } else if (state == 0 && liveNeighbors == 3) {
                    nextBoard[row][col] = 1; // Cell is born due to reproduction
                } else {
                    nextBoard[row][col] = state; // Cell's state remains the same
                }
            }
        }

        // Copy the next state of the board back to the original board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = nextBoard[row][col];
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;

        // Iterate through the neighbors of the cell at (row, col)
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                // Ignore the cell itself and out-of-bounds cells
                if ((i == row && j == col) || i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                    continue;
                }

                // Count the live neighbors
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
