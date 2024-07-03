// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int m = board.length; // row
        int n = board[0].length; // coloumn;

        // 0 --> 1 = 3
        // 1 --> 0 = 4

        int[][] dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0},
                {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                int alives = countAlives(board, i, j, m, n, dirs);

                if(board[i][j] == 1) {

                    // rule 1 and 3 applies
                    if(alives > 3 || alives < 2) {
                        board[i][j] = 4;
                    }
                }
                else {
                    if(alives == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {

                if(board[i][j] == 3){
                    board[i][j] = 1;
                }

                if(board[i][j] == 4) {
                    board[i][j] = 0;
                }

            }
        }
    }

    private int countAlives(int[][] board, int r, int c, int m, int n, int[][] dirs) {
        int count = 0;
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // check boundaries
            if(nr >= 0 && nr < m && nc >= 0 && nc < n
                    &&(board[nr][nc] == 1 || board[nr][nc] == 4))
            {
                count++;
            }

        }
        return count;
    }

    }
}