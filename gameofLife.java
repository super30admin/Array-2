/*
TC --> O(8*n*m)
SC --> O(1)
 */
class Solution {

    public void gameOfLife(int[][] board) {
        //directions up-left, up, up-right, left, down-left, down, down-right, right
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};
        int ROW = board.length;
        int COL = board[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {

                int count = 0;
                for (int k = 0; k < directions.length; k++) {
                    int row = directions[k][0];
                    int col = directions[k][1];
                    int r = i + row;
                    int c = j + col;

                    if (isValid(r, c, ROW, COL)) {
                        if (board[r][c] == 1 || board[r][c] == -1) {
                            count++;

                        }

                    }//if

                }//for

                //case 1 when 0
                //System.out.print("Count:"+count+" ");
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2;
                    }

                } else {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }

                }

            }//for

        }//for

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                //System.out.print(board[i][j]+" ");
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }

            }
            //System.out.println();
        }

    }//method

    public boolean isValid(int row, int col, int ROW, int COL) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            return false;
        }
        return true;
    }

}//class
