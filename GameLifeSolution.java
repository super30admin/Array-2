// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class GameLifeSolution {
    private int rows;
    private int cols;
    public void gameOfLife(int[][] board) {
        //use 2 when 1 -> 0
        //use 3 when 0 -> 1
        rows = board.length;
        cols = board[0].length;
        for(int r = 0; r < rows; r += 1) {
            for(int c = 0; c < cols; c += 1) {
                int neighbours = getNeighbours(board, r, c);
                if(board[r][c] == 0) {
                    if(neighbours == 3) {
                        board[r][c] = 3;
                    }
                } else {
                    if(neighbours < 2 || neighbours > 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
        
        for(int r = 0; r < rows; r += 1) {
            for(int c = 0; c < cols; c += 1) {
                if(board[r][c] == 2) {
                    board[r][c] = 0;
                } else if(board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }
    
    private int getNeighbours(int[][] board, int row, int col) {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int count = 0;
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
                count += 1;
            }
        }
        return count;
    }
}
