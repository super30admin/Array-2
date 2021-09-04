// Time Complexity : O(m*n) where m is rows and n is columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/**
 * Game of Life It is mentioned in the problem that we need to use only the
 * given array but not the extra array So we need to chanage the potential dead
 * cell to 3 and potential live cell to 2 and change them bac to 0 and 1 later
 */

public class GameLife {
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = getNeighborCount(board, i, j);
                if (board[i][j] == 1 && count < 2)
                    board[i][j] = 3; // later turns to 0
                else if (board[i][j] == 1 && (count == 2 || count == 3))
                    board[i][j] = 1;
                else if (board[i][j] == 1 && count > 3)
                    board[i][j] = 3; // later turns to 0
                else if (board[i][j] == 0 && count == 3)
                    board[i][j] = 2; // later turns 1
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

    }

    public int getNeighborCount(int[][] board, int row, int column) {
        int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };
        int count = 0;

        for (int i = 0; i < dir.length; i++) {
            if ((dir[i][0] + row >= 0 && dir[i][0] + row <= board.length - 1)
                    && (dir[i][1] + column >= 0 && dir[i][1] + column <= board[0].length - 1)) {
                if (board[row + dir[i][0]][column + dir[i][1]] == 1 || board[row + dir[i][0]][column + dir[i][1]] == 3)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        GameLife gl = new GameLife();
        int[][] nums = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gl.gameOfLife(nums);
    }
}
