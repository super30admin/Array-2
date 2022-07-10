import java.util.Arrays;

public class GameOfLifeSolution {
    int m, n;

    public int[][] gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return new int[0][0];
        }

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);
                // if existing cell is dead
                if (board[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // 0 = 1 -> 2 //Assigning 2 when 0 is changing to 1
                    }
                }
                // if existing cell is live
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 3; // 1 = 0 -> Assigning 3 when 1 is changing to 0
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }

        return board;

    }

    private int countLiveNeighbors(int[][] board, int cR, int cL) {
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
        // All the directions in Clock Wise // TL, T, TR, R, BR, B, BL, L
        int count = 0;
        for (int[] dir : dirs) {
            int nR = cR + dir[0];
            int nC = cL + dir[1];
            // Checking the the diaglonal element is either 1 or 3
            // as during the process before changing from live dead (1 -> 3), it was live,
            // so counting it

            if (nR >= 0 && nR < m && nC >= 0 && nC < n && (board[nR][nC] == 1 || board[nR][nC] == 3)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GameOfLifeSolution gols = new GameOfLifeSolution();
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        int[][] resultBoard = gols.gameOfLife(board);
        for (int[] resultRows : resultBoard) {
            System.out.println(Arrays.toString(resultRows));
        }

    }
}
