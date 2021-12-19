// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board.length ==0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for(int i =0 ; i< m;i++) {
            for(int j =0; j< n;j++) {
                // counting live cells for each cell
                int lives = countLiveCells(board, i, j, m,n);
                // these are as per the rules given in ques
                if(board[i][j] ==1) {
                    if(lives < 2 || lives>3) {
                        board[i][j] = 3;
                    }
                } else if(board[i][j] == 0 && lives ==3) {
                    board[i][j] = 2;
                }
            }
        }

        // reverting the elements back to the original elements
        for(int i =0 ; i< m;i++) {
            for(int j =0; j< n;j++) {
                if(board[i][j] ==3) {
                    board[i][j]=0;
                } else if(board[i][j] ==2) {
                    board[i][j] =1;
                }
            }
        }
    }

    // Counting live cells present in the 8 directions
    public int countLiveCells(int [][] board, int row, int col, int m, int n) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1, -1}, {-1,1}, {1, -1}, {1, 1}};
        int count =0;
        for(int [] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // When the cell has value 1 or 3, 3 because we modified the live cell to 3, it contributes to the live cells present
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && (board[newRow][newCol] ==1 || board[newRow][newCol]==3)) {
                count++;
            }
        }

        return count;
    }
}
