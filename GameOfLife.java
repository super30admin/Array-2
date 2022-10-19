// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class GameOfLife {
    final static int [][] dire = {{-1,-1}, {-1, 0}, {-1, +1}, {0 ,1}, {1,1}, {1, 0}, {1,-1}, {0, -1}};
    int live = 1;
    int dead = 0;

    int live_dead = 2;
    int dead_live = 3;

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int col = board[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                int aliveCount = findAlive(board, i , j);
                //live
                if (board[i][j] == live) {
                    if (aliveCount < 2 || aliveCount > 3) {
                        board[i][j] = live_dead;
                    }
                }
                // dead
                else {
                    if (aliveCount == 3) {
                        board[i][j] = dead_live;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == live_dead){
                    board[i][j] = dead;
                }
                if (board[i][j] == dead_live){
                    board[i][j] = live;
                }
            }

        }
    }

    public int findAlive(int[][] board , int i , int j){
        int aliveCount = 0;

        for (int[] arr : dire){
            int i1 = i + arr[0];
            int j1 = j + arr[1];

            if (i1 >= 0 && j1 >=0 && i1 <= board.length -1 && j1 <= board[0].length -1 ){
                if (board[i1][j1] == live || board[i1][j1] == live_dead) {
                    aliveCount++;
                }
            }
        }
        return  aliveCount;
    }

    public static void main(String[] args){
        GameOfLife obj = new GameOfLife();
        int [][] nums = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(nums);
    }

}
