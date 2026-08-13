
//Approach: The idea behind this solution is to iterate through the matrix using direction array and apply the rules to
//mark a particular element is dead or alive. To avoid collisions, in the first iteration mark the dead and alive with
// other any numbers other than 0 and 1. At the end, iterate through the matrix to replace with original 0 and 1.

//Time Complexity: O(mxn)
//Space Complexity: O(1)
class GameOfLife
{
    int[][] dirs;
    int m, n;
    public void gameOfLife(int[][] board) {

        this.dirs = new int[][] {{-1, 1}, {-1,0}, {-1, -1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};

        //live to die => -1
        //die to live => 2
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 1) {
                    //Case-1 or Case-3
                    if(livingCount(board, i, j) < 2 || livingCount(board, i, j) > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    //Case-4
                    if(livingCount(board, i, j) == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                } else if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int livingCount(int[][] board, int i, int j) {
        int count = 0, m = board.length, n = board[0].length;

        for (int[] dir : dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == -1)) // Check boundaries
            {
                count++;
            }
        }

        return count;
    }
}