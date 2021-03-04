public class GameOfLife_289 {

    int LIVE_TO_DEAD = 10;
    int DEAD_TO_LIVE = 20;

    int LIVE = 1;
    int DEAD = 0;

    public void gameOfLife(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If live lives with less than live people, dies.
                // if live lives between 2 and 3 then live
                // if live lives more than 3 lives, then dies
                // if dead lives with exact 3 live then become live
                if (matrix[i][j] == LIVE || matrix[i][j] == LIVE_TO_DEAD) {
                    int noOfLives = getCountOfLives(matrix, i, j, m, n);
                    if (noOfLives > 3 || noOfLives < 2) {
                        matrix[i][j] = LIVE_TO_DEAD;
                    }
                } else {
                    int noOfLives = getCountOfLives(matrix, i, j, m, n);
                    if (noOfLives == 3) {
                        matrix[i][j] = DEAD_TO_LIVE;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == DEAD_TO_LIVE)
                    matrix[i][j] = LIVE;
                if (matrix[i][j] == LIVE_TO_DEAD)
                    matrix[i][j] = DEAD;
            }
        } 
    }

    private int getCountOfLives(int[][] matrix, int rowIndex, int colIndex, int rowLength, int colLength) {

        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int noOfLives = 0;
        for (int i = 0; i < dirs.length; i++) {
            int[] currentDir = dirs[i];
            int row = rowIndex + currentDir[0];
            int column = colIndex + currentDir[1];
            // Elimate the out of bound index
            if (row >= 0 && row < rowLength && column >= 0 && column < colLength) {
                // Caluclate the live values
                if (matrix[row][column] == LIVE || matrix[row][column] == LIVE_TO_DEAD) {
                    noOfLives++;
                }
            }
        }
        return noOfLives;
    }

    public static void main(String[] args) {
        GameOfLife_289 gameOfLife_289 = new GameOfLife_289();
        gameOfLife_289.gameOfLife(new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 }, });

    }
}
