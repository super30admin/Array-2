// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Approach - create directions matrix for 8 directions, create helper function to find alive neighbor count. for each cell in matrix call this function. use the conditions on count. if 1 becomes 0 in iteration then put 3 there and if 0 becomes 1 then put 2 to keep them different from old 0 and 1 values. In getCount function, use all 8 directions and check if neighbor is 1 or 2-> count++. At the end, in main function, change back 2 and 3 to 0 and 1 resp.

public class GameOfLife {
    int[][] directions;
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        this.directions = new int[][]{
                {-1,-1}, {-1, 0}, {-1, 1},
                { 0,-1},          { 0, 1},
                { 1,-1}, { 1, 0}, { 1, 1}
        };

        this.m = board.length;
        this.n = board[0].length;

        //for each cell find its next value
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = getNeighborsCount(board, i, j);
                //if cell is dead (0) and has exactly 3 live neighbors => it becomes live (3 = "0->1")
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
                //if cell is live (1) and has <2 or >3 neighbors => it becomes dead (2 = "1->0")
                else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        //covert back 2 and 3 to 0 and 1 respectively
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    //helper function to find alive neighbors count
    private int getNeighborsCount(int[][] board, int i, int j) {
        int count = 0;
        for(int[] dir: directions) {
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < m && c < n) {
                //if value is 1 or 2 => originally alive
                if(board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    //helper function to print the board in grid form
    private static void printBoard(int[][] board) {
        for(int[] row : board) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GameOfLife sol = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        sol.gameOfLife(board);
        System.out.println("\nBoard After 1 Iteration:");
        printBoard(board);
    }
}
