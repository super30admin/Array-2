/*
Game of Life
approach: using 8 directions array for neighbors and marking temporary states using 3,2

time: O(nxn)
space: O(1)
 */
public class Problem3 {

    static int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static void gameOfLife(int[][] board) {

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                int neighbors = getNeighbors(i, j, board, board.length, board[0].length);

                // 1 ->0 : 3
                // 0 ->1: 2
                if (board[i][j] == 1) {
                    if (neighbors<2 || neighbors>3) board[i][j] = 3;
                }
                else {
                    if (neighbors==3) board[i][j] = 2;
                }
            }
        }

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {

                // 1 ->0 : 3
                // 0 ->1: 2
                if (board[i][j] == 3) board[i][j] = 0;
                else {
                    if (board[i][j]==2) board[i][j] = 1;
                }
            }
        }
    }

    static int getNeighbors(int row, int col, int[][] board, int rows, int cols) {
        int res = 0;
        for (int[] dir: dirs) {
            int nr = dir[0]+row;
            int nc = dir[1]+col;

            if (nr<rows && nr>=0 && nc>=0 && nc<cols && (board[nr][nc]==1 || board[nr][nc]==3)) res+=1;
        }

        return res;
    }

    public static void main(String []args) {
        gameOfLife(new int[][]{{1,1},{1,0}});
    }
}
