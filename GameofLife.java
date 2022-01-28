public class GameofLife {
    // 1 -> 0 = 5
    // 0 -> 1 = -1

    public void gameOfLife(int[][] m) {

        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {

                int living = calc(m, row, col);
                if (m[row][col] == 1) {
                    if (living > 3 || living < 2) {
                        m[row][col] = 5;
                    }
                }
                if (m[row][col] == 0) {
                    if (living == 3) {
                        m[row][col] = -1;
                    }
                }
            }
        }
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                if (m[row][col] == 5) {
                    m[row][col] = 0;
                }
                if (m[row][col] == -1) {
                    m[row][col] = 1;
                }
            }
        }

    }

    public int calc(int[][] m, int row, int col) {
        int Rrow = m.length;
        int Ccol = m[0].length;
        int[][] neigh = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

        int living = 0;
        for (int i = 0; i < neigh.length; i++) {
            int nRow = row + neigh[i][0];
            int nCol = col + neigh[i][1];

            if ((nRow >= 0 && nRow < Rrow) && (nCol >= 0 && nCol < Ccol)) {
                if (m[nRow][nCol] == 1 || m[nRow][nCol] == 5) {
                    living++;
                }
            }
        }
        return living;
    }
}
