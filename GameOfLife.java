/**
 TC - O(m*n) , SC - O(1)
 */
class GameOfLife {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for(int i =0; i < m; i++) {
            for(int j =0; j < n; j++) {

                count = getOneCount(board, i, j, m, n);

                //If current cell is live
                if(board[i][j] == 1) {
                    if(count < 2 || count > 3)
                        board[i][j] = 2; //Mark live to dead as 2
                }

                //If current cell is dead
                else if(board[i][j] == 0) {
                    if(count == 3)
                        board[i][j] = 3; //Mark dead to live as 3
                }
            }
        }

        //traverse through matrix and replace 2 with 0 and 3 with 1

        for(int i =0 ; i <m; i++) {
            for(int j=0; j <n; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;

                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }

    }

    private int getOneCount(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        int[][] dir = {{0, -1}, {0, 1}, {-1,0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];

            if(r >=0 && r <m && c >=0 && c <n && (board[r][c] ==1 || board[r][c] == 2)) {
                count++;
            }
        }

        return count;
    }
}