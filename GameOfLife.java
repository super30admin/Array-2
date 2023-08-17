// Tc = O(m*n)
//SC = O(1)

public class GameOfLife {

    public static void main(String[] args) {

        int[][] arr = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        GameOfLife obj = new GameOfLife();
        obj.gameOfLife(arr);
        
        for(int i =0 ; i < arr.length ; i++){
            for (int j =0 ; j< arr[0].length ; j++){

                System.out.println( arr[i][j] + "");
            }
        }
        System.out.println();
    }

    int[][] dir;

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        dir = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        // 0 == 1 : 2
        // 1==0 :3

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int countAlive = countAlive(board, m, n, i, j);
                if (board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }

        }
    }

    private int countAlive(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for (int[] dirs : dir) {
            int nr = i + dirs[0];
            int nc = j + dirs[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)) {
                count++;
            }

        }
        return count;
    }
}
